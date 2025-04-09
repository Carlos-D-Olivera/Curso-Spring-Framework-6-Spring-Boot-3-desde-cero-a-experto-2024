# Usa una imagen base de OpenJDK
FROM openjdk:17-jdk-slim AS build

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo pom.xml y descarga las dependencias
COPY pom.xml .

# Descargar dependencias de Maven (esto crea una capa cacheada, si no cambian las dependencias, no se reconstruye)
RUN ./mvnw dependency:go-offline -B

# Copia el código fuente al contenedor
COPY src ./src

# Compila la aplicación y genera el archivo JAR
RUN ./mvnw clean package -DskipTests

# Usa una imagen base más pequeña para ejecutar la aplicación
FROM openjdk:17-jdk-slim

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el JAR generado del contenedor anterior al contenedor final
COPY --from=build /app/target/*.jar app.jar

# Expone el puerto en el que la aplicación Spring Boot estará escuchando (por defecto, 8080)
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
