🛒 E-Commerce Microservices Ecosystem
Sistema distribuido de alto rendimiento diseñado para la gestión integral de ventas y control de inventario, desarrollado bajo principios de Clean Architecture y Domain-Driven Design (DDD).

🚀Demo & Documentación
Interactive Docs (Swagger): http://68.211.161.210:8001/swagger-ui/index.html#

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
