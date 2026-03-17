# 🛒 E-Commerce Microservices Ecosystem

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-17-orange)](https://www.oracle.com/java/)
[![Docker](https://img.shields.io/badge/Docker-Enabled-blue)](https://www.docker.com/)
[![Azure](https://img.shields.io/badge/Azure-VM%20Deployed-0078D4)](https://azure.microsoft.com/)

Sistema distribuido de alto rendimiento diseñado para la gestión integral de ventas y control de inventario. Desarrollado bajo principios de **Clean Architecture** y **Domain-Driven Design (DDD)**.

---

## 🏗️ Arquitectura del Sistema
El ecosistema se basa en una arquitectura de **Microservicios** para garantizar escalabilidad e independencia de datos:

* **Main API (MySQL):** 🧠 Orquestador de ventas, gestión de usuarios y procesamiento de órdenes.
* **Stock Service (PostgreSQL):** 📦 Especializado en el control de inventario con alta integridad referencial.
* **API Gateway:** 🚪 Punto de entrada único (Puerto 8080) que centraliza el tráfico, seguridad y ruteo.
* **Comunicación Sincrónica:** Implementada con **OpenFeign** para validaciones de stock en tiempo real.
* **Mensajería Asíncrona:** Uso de **RabbitMQ** para desacoplar procesos críticos y garantizar la consistencia eventual.

---

## 🚀 Demo & Documentación Interactiva
Explorá y testeá los endpoints directamente a través de las interfaces de **Swagger UI**:

| Servicio | Documentación Interactiva |
| :--- | :--- |
| **Servicio Principal** | [🔗 Ver Docs Principal](http://68.211.161.210:8001/swagger-ui/index.html) |
| **Servicio Stock** | [🔗 Ver Docs Stock](http://68.211.161.210:8002/swagger-ui/index.html) |
| **Gateway (Consolidado)** | [🔗 Ver Docs Gateway](http://68.211.161.210:8080/swagger-ui/index.html) |

---

## 🛠️ Stack Tecnológico
* **Lenguaje:** Java 17.
* **Framework:** Spring Boot 3 (Data JPA, Cloud, Security).
* **Persistencia Políglota:** * `MySQL`: Flujo transaccional y usuarios.
    * `PostgreSQL`: Control de inventario y depósitos.
* **Integraciones Clave:**
    * 💳 **Stripe API:** Procesamiento de pagos seguro (Modo Test).
    * 💱 **ExchangeRate API:** Conversión dinámica de divisas en tiempo real.
* **Infraestructura:** Docker & Docker Compose desplegados en **Azure Virtual Machine**.

---

## 🧪 Calidad de Software (Testing)
> *"El código que no se testea, no existe en producción."*

Contamos con una suite de pruebas robusta para garantizar la integridad de la lógica de negocio:
* **Unit Testing:** Implementado con **JUnit 5**.
* **Mocking:** Uso de **Mockito** para aislar capas de servicio y simular integraciones externas (Stripe/Rabbit).
* **Edge Cases:** Foco crítico en validaciones de stock y procesamiento de pagos.

---

## 📂 Guía de Instalación Rápida

### 1️⃣ Clonar el repositorio
git clone [https://github.com/tu-usuario/tu-repo.git](https://github.com/tu-usuario/tu-repo.git)

### 2️⃣ Configurar Entorno (.env)
cp .env.example .env

### 3️⃣ Levantar con Docker 🚀
docker-compose up --build -d

### 📞 Contacto & Portfolio
https://matias-backend-portfolio.netlify.app/

