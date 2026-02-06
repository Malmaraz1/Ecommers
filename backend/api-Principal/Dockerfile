FROM maven:3.9.6-eclipse-temurin-17-alpine AS builder
WORKDIR /app

# 1. Copiamos solo el pom.xml primero
COPY pom.xml .

# 2. Descargamos las dependencias (este paso se cachea si el pom no cambia)
# Usamos 'dependency:go-offline' para bajar todo lo necesario sin compilar
RUN mvn dependency:go-offline

# 3. Recién ahora copiamos el código fuente
# Si cambias algo en src, Docker empezará desde aquí hacia abajo
COPY src ./src

# 4. Compilamos el proyecto
# Como las dependencias ya están en la imagen, esto será rapidísimo
RUN mvn clean package -DskipTests


FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar
ENV PORT=8001
EXPOSE $PORT

# Ejecutamos el archivo renombrado para que sea más simple
ENTRYPOINT ["java","-jar","app.jar"]