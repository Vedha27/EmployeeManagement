# Stage 1: Build the application using Maven with JDK 21
FROM maven:3.9.4-eclipse-temurin-21 AS builder

# Set working directory
WORKDIR /app

# Copy all project files
COPY . .

# Build the Spring Boot application (without running tests)
RUN mvn clean package -DskipTests

# Stage 2: Run the app with JDK 21
FROM eclipse-temurin:21-jdk

# Set working directory inside container
WORKDIR /app

# Copy the built jar from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose the port the app runs on
EXPOSE 8081

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
