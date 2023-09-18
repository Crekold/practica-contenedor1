# Utiliza la imagen de Java como base
FROM openjdk:17-jdk-alpine

# Copia el archivo JAR de tu aplicación al contenedor
COPY target/contenedor-0.0.1-SNAPSHOT.jar /app.jar

# Expón el puerto en el que se ejecutará tu aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "/app.jar"]
