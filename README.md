
# Proyecto Backend

## 📚 Tabla de Contenido

- [🗒️ ¿Qué trae este proyecto?](#️-que-trae-este-proyecto-)
- [🧩 Arquitectura del Proyecto](#-arquitectura-del-proyecto)
  - [🚪 API Gateway: api-gateway](#-api-gateway-api-gateway)
  - [🔎 Servidor de descubrimiento: eureka-server](#-servidor-de-descubrimiento-eureka-server)
  - [⚙️ Servidor de configuración: config-server](#-servidor-de-configuración-config-server)
  - [📰 Microservicio 1: Autores-Noticias](#-microservicio-1-autores-noticias)
  - [📦 Microservicio 2: Ordenes-Productos](#-microservicio-2-ordenes-productos)
  - [🛠️ Configuración de bases de datos](#️-configuración-de-bases-de-datos)
- [✅ ¿ Como es el flujo general?](#-como-es-el-flujo-general)
- [🚀 Pasos para ejecutar el sistema completo](#-pasos-para-ejecutar-el-sistema-completo)
  - [🧱 1. Levantar las bases de datos con Docker](#-1-levantar-las-bases-de-datos-con-docker)
  - [📦 2. Iniciar el Servidor de Descubrimiento (eureka-server)](#-2-iniciar-el-servidor-de-descubrimiento-eureka-server)
  - [⚙️ 3. Iniciar el Servidor de Configuración (config-server)](#-3-iniciar-el-servidor-de-configuración-config-server)
  - [🔧 4. Iniciar los microservicios](#-4-iniciar-los-microservicios)
  - [🚪 5. Iniciar el API Gateway (api-gateway)](#-5-iniciar-el-api-gateway-api-gateway)
  - [🧪 6. Probar todo desde el navegador o Postman](#-6-probar-todo-desde-el-navegador-o-postman)
- [✅ Verificación final](#-verificación-final)


## 🗒️ ¿Que trae este proyecto?

Este proyecto consta de:
- API Getway: api-Getway
- Servidor de descubrimiento: eureka-server
- Servidor de configuración: config-server
- Microservicio 1: Autores-Noticias
- Microservicio 2: Ordenes-Productos
- Configuracion de base de datos: Config-DB, Config-Mongo


## 🧩 Arquitectura del Proyecto
Este proyecto está basado en una arquitectura de microservicios desacoplados utilizando Spring Boot, Spring Cloud, Eureka, y Docker, y se organiza en los siguientes módulos:

### 🚪 API Gateway: api-gateway
Actúa como el punto de entrada único para todas las peticiones al sistema.

Enruta dinámicamente las solicitudes hacia los microservicios registrados en Eureka.

Facilita el balanceo de carga, enrutamiento, filtros y gestión centralizada de accesos.

Utiliza Spring Cloud Gateway para enrutar de forma automática gracias al descubrimiento de servicios.

### 🔎 Servidor de descubrimiento: eureka-server
Es el registro de servicios centralizado (Service Registry) del sistema.

Permite que los microservicios se registren automáticamente y se descubran entre sí sin conocer sus ubicaciones exactas.

Facilita la escalabilidad y el balanceo de carga.

Implementado con Spring Cloud Netflix Eureka.

### ⚙️ Servidor de configuración: config-server
Provee configuración externa y centralizada para todos los microservicios.

Carga los archivos .yml desde un repositorio local o remoto (por ejemplo, config-repo).

Permite separar la configuración del código fuente, lo que facilita los cambios sin necesidad de recompilar.

Implementado con Spring Cloud Config Server.

### 📰 Microservicio 1: Autores-Noticias
Es un microservicio funcional que gestiona autores y noticias.

Conecta a una base de datos MongoDB.

Registra sus endpoints en Eureka y obtiene su configuración desde Config Server.

Expuesto mediante el Gateway en rutas como:
http://localhost:8082/autores-noticias/...

### 📦 Microservicio 2: Ordenes-Productos
Es un microservicio funcional que gestiona órdenes y productos.

Utiliza una base de datos PostgreSQL.

También se registra en Eureka y se configura dinámicamente desde Config Server.

Expuesto mediante el Gateway en rutas como:
http://localhost:8081/ordenes-productos/...

### 🛠️ Configuración de bases de datos
Config-DB:
Contiene archivos docker-compose.yml para levantar la base de datos PostgreSQL utilizada por Ordenes-Productos.

Config-Mongo:
Contiene archivos docker-compose.yml para iniciar la base de datos MongoDB utilizada por Autores-Noticias.

## ✅ ¿Como es el flujo general?
Se arranca eureka-server para permitir el registro de servicios.

Luego config-server, que provee la configuración remota.

Después los microservicios (Autores-Noticias, Ordenes-Productos), que se configuran y registran automáticamente.

Finalmente api-gateway, que enruta peticiones a los microservicios a través de Eureka.

## 🚀 Pasos para ejecutar el sistema completo

### 🧱 1. Levantar las bases de datos con Docker
Primero debes asegurarte de que las bases de datos estén activas y listas para conectarse.

- 🔹 PostgreSQL (para Ordenes-Productos)
1. Ve al directorio Config-DB (donde está el archivo docker-compose.yml para PostgreSQL).

2. Ejecuta:

```bash
 docker-compose up -d
```

- 🔹 MongoDB (para Autores-Noticias)
1. Ve al directorio Config-Mongo.

2. Ejecuta:

```bash
 docker-compose up -d
```

3. Verifica que los contenedores estén funcionando:

bash
Copiar
Editar
docker ps

### 📦 2. Iniciar el Servidor de Descubrimiento (eureka-server)
1. Ve al proyecto eureka-server.

2. Ejecuta el microservicio:

```bash
 ./gradlew bootRun
```

3. Verifica que está funcionando abriendo:
👉 _http://localhost:8761_

### ⚙️ 3. Iniciar el Servidor de Configuración (config-server)
1. Ve al proyecto config-server.

2. Asegúrate de que dentro del proyecto se encuentren los .yml de configuración de los micros, estos estan en la ruta _config-server/src/main/resources/configuration_

3. Ejecuta:
```bash
 ./gradlew bootRun
```

4. Verifica desde el navegador:
- 👉 _http://localhost:8888/Autores-Noticias/default_
- 👉 _http://localhost:8888/Ordenes-Productos/default_

### 🔧 4. Iniciar los microservicios
- 📰 Autores-Noticias
1. Ve al proyecto Autores-Noticias.

2. Ejecuta:
```bash
 ./gradlew bootRun
```
3. Este microservicio:

- Se conectará a MongoDB.

- Cargará configuración desde Config Server.

- Se registrará en Eureka.

- Escuchará en el puerto definido en el YAML (por ejemplo, 8082).

4. Verifica que ambos microservicios aparecen como UP en:
👉 _http://localhost:8761_

### 🚪 5. Iniciar el API Gateway (api-gateway)
1. Ve al proyecto api-gateway.

2. Ejecuta:
```bash
 ./gradlew bootRun
```

3. Este Gateway:

- Se conecta a Eureka.

- Descubre los microservicios automáticamente.

- Enruta peticiones a /autores-noticias/** y /ordenes-productos/**


### 🧪 6. Probar todo desde el navegador o Postman
#### 🔹 Endpoints funcionales vía Gateway:
- 👉 http://localhost:8080/autores-noticias/autores

- 👉 http://localhost:8080/ordenes-productos/productos

#### 🔹 Ver documentación Swagger:
- 👉 http://localhost:8082/swagger-ui.html (Autores-Noticias directo)

- 👉 http://localhost:8081/swagger-ui.html (Ordenes-Productos directo)


## ✅ Verificación final

| Componente         | Puerto | Verificar en...                                         |
|--------------------|--------|----------------------------------------------------------|
| PostgreSQL         | 5432   | Docker (base de datos corriendo)                        |
| MongoDB            | 27017  | Docker (base de datos corriendo)                        |
| Eureka Server      | 8761   | [`http://localhost:8761`](http://localhost:8761)        |
| Config Server      | 8888   | `http://localhost:8888/<service>/default`               |
| Autores-Noticias   | 8082   | `http://localhost:8080/autores-noticias/...`            |
| Ordenes-Productos  | 8081   | `http://localhost:8080/ordenes-productos/...`           |
| API Gateway        | 8080   | [`http://localhost:8080`](http://localhost:8080)        |
