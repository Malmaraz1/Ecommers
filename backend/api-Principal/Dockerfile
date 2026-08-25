FROM maven:3.9.6-eclipse-temurin-17-alpine AS builder
WORKDIR /app

# 1. Copiamos solo el pom.xml primero
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

RUN chmod +x mvnw
# 2. Descargamos las dependencias (este paso se cachea si el pom no cambia)
# Usamos 'dependency:go-offline' para bajar todo lo necesario sin compilar
RUN ./mvnw dependency:go-offline -B

# 3. Recién ahora copiamos el código fuente
# Si cambias algo en src, Docker empezará desde aquí hacia abajo
COPY src ./src
RUN ./mvnw clean package -DskipTests
ENV MAVEN_OPTS="-Xmx350m"

# 4. Compilamos el proyecto
# Como las dependencias ya están en la imagen, esto será rapidísimo



FROM eclipse-temurin:17-jre-alpine

WORKDIR /app
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

COPY --from=builder /app/target/*.jar app.jar
ENV PORT=8001
EXPOSE $PORT


# Ejecutamos el archivo renombrado para que sea más simple
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]