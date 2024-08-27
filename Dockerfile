# IMAGEN MODELO
FROM eclipse-temurin:17.0.12_7-jdk

# Informar el puerto donde se ejecuta el contenedor (INFORMATIVO)
EXPOSE 8080

# DEFINIR EL DIRECTORIO RAIZ DEL CONTENEDOR
WORKDIR /root

# copiar y pegar archivos dentro del contenedor
COPY ./pom.xml /root
COPY ./.mvn /root/.mvn
COPY ./mvnw /root

# Descargar dependencias
RUN ./mvnw dependency:go-offline

# copiar el codigo fuente al contenedor
COPY ./src /root/src

# Construir la aplicacion - se salta test (no recomendado)
RUN ./mvnw clean install -DskipTests

# Levantar la aplicacion cuando el contenedor inicie
ENTRYPOINT ["java", "-jar", "/root/target/catalogo-0.0.1-SNAPSHOT.jar"]

