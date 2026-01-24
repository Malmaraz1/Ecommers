FROM maven:3.9.6-eclipse-temurin-17-alpine AS build
WORKDIR /app

COPY ./target/ecommerce-0.0.1-SNAPSHOT.jar .

EXPOSE 8080

ENTRYPOINT ["java","-jar","ecommerce-0.0.1-SNAPSHOT.jar"]

