🛒 E-Commerce Microservices Ecosystem
Sistema distribuido de alto rendimiento diseñado para la gestión integral de ventas y control de inventario, desarrollado bajo principios de Clean Architecture y Domain-Driven Design (DDD).

🚀Demo & Documentación 

servicio-principal Interactive Docs (Swagger): http://68.211.161.210:8001/swagger-ui/index.html#

servicio-stock
Interactive Docs (Swagger): http://68.211.161.210:8002/swagger-ui/index.html#

🏗️ Arquitectura Técnica
El proyecto se basa en una arquitectura de Microservicios para garantizar escalabilidad e independencia de datos:

Main API (MySQL): Orquestador de ventas, gestión de usuarios y procesamiento de órdenes.

Stock Service (PostgreSQL): Microservicio especializado en el control de inventario con alta integridad referencial.

Comunicación: Sincrónica mediante OpenFeign para validación de stock en tiempo real antes de confirmar compras.

Mensajería Asíncrona: Implementación de RabbitMQ para desacoplar procesos críticos.

🧪 Calidad de Software (Testing)
Esto es vital para un backend. Agregá una sección específica de Testing:

Testing & Quality Assurance
El proyecto cuenta con una robusta suite de pruebas para garantizar la integridad de la lógica de negocio:

Unit Testing: Implementado con JUnit 5.

Mocking: Uso de Mockito para aislar las capas de servicio y simular el comportamiento de repositorios e integraciones externas (Stripe/Rabbit).

Cobertura: Foco en la validación de casos de borde en el cálculo de conversiones y procesamiento de pagos.

Stack Tecnológico
Backend: Java 17, Spring Boot 3 (Data JPA, Cloud, Security).

Persistencia Políglota: MySQL para el flujo transaccional y PostgreSQL para el inventario.

Integraciones: * Stripe API: Procesamiento de pagos seguro (Modo Test).

ExchangeRate API: Conversión dinámica de divisas.

Infraestructura: Docker & Docker Compose para orquestación y despliegue en Azure Virtual Machine.

📂 Estructura del Repositorio
/ecommerce-api: Lógica principal y pagos.

/stock-microservice: Lógica de inventario.

/docker-compose.yml: Definición de red y contenedores.

/.env.example: Plantilla de configuración.

🛠️ Instalación y Ejecución Local
Para replicar el entorno de producción en tu máquina, seguí estos pasos:

Clonar el repositorio:

Bash
git clone [URL_DE_TU_REPO]
cd [NOMBRE_CARPETA]
Configurar Variables de Entorno:
Copiá el archivo .env.example a uno nuevo llamado .env y completá tus credenciales:

Bash
STRIPE_API_KEY=tu_llave_test
EXCHANGE_RATE_KEY=tu_api_key
DB_PASSWORD=tu_password_local
Levantar con Docker:

Bash
docker-compose up --build
Los servicios estarán disponibles en el puerto 8080 (Gateway).
