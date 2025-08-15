# Use Eclipse Temurin OpenJDK 17 with Alpine Linux as the base image
FROM eclipse-temurin:17-jdk-alpine

# Create a mountable directory for temporary files
VOLUME /tmp

# Copy the built JAR file from the build output to the container
COPY build/libs/*.jar app.jar

# Set the entrypoint to run the JAR file using Java
ENTRYPOINT ["java","-jar","/app.jar"]