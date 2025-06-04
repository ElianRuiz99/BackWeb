# Config-Server 🔨

El Config Server es un componente centralizado cuya responsabilidad principal es:

- Centralizar la configuración de múltiples microservicios en un único lugar.

- Servir archivos de configuración (YAML/Properties) a los distintos microservicios al momento de arrancar.

- Facilitar el cambio de parámetros (base de datos, puertos, URLs, propiedades personalizadas, etc.) sin necesidad de recompilar o redeplegar cada servicio.

- Mantener un repositorio (local o Git) donde se almacenan las propiedades específicas de cada servicio, organizadas por nombre de aplicación y perfil.

Config Server gestiona y expone la configuración para dos proyectos:

## 🖋️ Autores-Noticias 
para revisar la configuracion de este microservicio, ingrese a esta URL: http://localhost:8888/Autores-Noticias/default

## 📝 Ordenes-Productos
para revisar la configuracion de este microservicio, ingrese a esta URL: http://localhost:8888/Ordenes-Productos/default

## 🚀 Cómo ejecutar el Config Server
1. Clona (o sitúa) este proyecto en tu máquina local.
2. Verifica que la carpeta _src/main/resources/configuration/_ exista y contenga los dos archivos:
- Ordenes-Productos.yml
- Autores-Noticias.yml
3. Abre el archivo src/main/resources/application.yml y asegúrate de que la propiedad de search-locations (o git.uri si usas Git) apunte correctamente a tu carpeta configuration.
4. Abre la consola y ejecuta el comando **_bootRun_**


