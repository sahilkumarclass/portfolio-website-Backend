# Use the official Maven image to build the application
FROM maven:3.8.6-openjdk-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package

# Use the OpenJDK image to run the application
FROM openjdk:21-jdk-slim
COPY --from=build /app/target/musicplay-0.0.1-SNAPSHOT.jar /app/musicplay.jar
ENTRYPOINT ["java", "-jar", "/app/musicplay.jar"]
