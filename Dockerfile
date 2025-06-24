# Use Java 21 base image
FROM eclipse-temurin:21-jdk

# Create app folder inside the container
WORKDIR /app

# Copy the JAR file from target/ folder
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080 (Render uses this)
EXPOSE 8080

# Run the app
CMD ["java", "-jar", "app.jar"]
