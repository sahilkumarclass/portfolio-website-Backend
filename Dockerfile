# Use OpenJDK 22 as base image
FROM openjdk:22-jdk-slim

# Set working directory
WORKDIR /app

# Copy the JAR file into the image
COPY target/Backend-0.0.1-SNAPSHOT.jar app.jar

# Run the JAR file
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
