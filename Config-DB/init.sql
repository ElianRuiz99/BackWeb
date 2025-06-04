-- Crear esquema si no existe
CREATE SCHEMA IF NOT EXISTS proyectoBack;

-- Crear tabla Productos
DROP TABLE IF EXISTS proyectoBack.productos;

CREATE TABLE proyectoBack.productos (
    id_producto SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,    
    descripcion TEXT,
    precio_unitario DECIMAL(10, 2) NOT NULL,
    stock INT NOT NULL,
    categoria VARCHAR(50)
);

-- Crear tabla Ordenes
DROP TABLE IF EXISTS proyectoBack.ordenes;

CREATE TABLE proyectoBack.ordenes (
    id_orden SERIAL PRIMARY KEY,
    fecha TIMESTAMP,
    id_producto INT REFERENCES proyectoBack.productos(id_producto),
    cantidad INT NOT NULL,
    total DECIMAL(10, 2),
    estado VARCHAR(20)
);

INSERT INTO proyectoBack.productos (nombre, descripcion, precio_unitario, stock, categoria) VALUES
('Taladro eléctrico', 'Taladro de alta potencia para concreto', 350.00, 25, 'Herramientas'),
('Disco de corte', 'Disco para corte de acero inoxidable', 25.00, 200, 'Accesorios'),
('Guantes industriales', 'Guantes anticorte reforzados', 18.50, 150, 'Seguridad'),
('Casco de seguridad', 'Casco con ajuste y visera transparente', 42.00, 90, 'Seguridad'),
('Soldadora inverter', 'Equipo portátil para soldadura SMAW', 890.00, 10, 'Maquinaria'),
('Arnés de seguridad', 'Arnés con doble anclaje y líneas de vida', 120.00, 50, 'Seguridad'),
('Escalera extensible', 'Escalera de aluminio 6 metros', 310.00, 15, 'Herramientas'),
('Botas dieléctricas', 'Calzado con punta de acero y suela aislante', 85.00, 75, 'Seguridad'),
('Cinta métrica', 'Cinta de 8m con bloqueo automático', 15.00, 300, 'Instrumentos'),
('Esmeril angular', 'Herramienta para corte y desbaste de metal', 260.00, 40, 'Herramientas');

INSERT INTO proyectoBack.ordenes (fecha, id_producto, cantidad, total, estado) VALUES
(NOW(), 1, 2, 700.00, 'Pendiente'),
(NOW(), 2, 10, 250.00, 'Completada'),
(NOW(), 3, 5, 92.50, 'Pendiente'),
(NOW(), 4, 3, 126.00, 'Cancelada'),
(NOW(), 5, 1, 890.00, 'Completada'),
(NOW(), 6, 2, 240.00, 'Pendiente'),
(NOW(), 7, 1, 310.00, 'Pendiente'),
(NOW(), 8, 4, 340.00, 'Completada'),
(NOW(), 9, 5, 75.00, 'Pendiente'),
(NOW(), 10, 1, 260.00, 'Pendiente');

