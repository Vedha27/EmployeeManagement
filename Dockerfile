# Stage 1: Build the application
FROM maven:3.8.6-openjdk-17 AS builder

# Set working directory
WORKDIR /app

# Copy all project files
COPY . .

# Build the application without tests
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM openjdk:17

# Set working directory in the container
WORKDIR /app

# Copy the built jar from the previous stage
COPY --from=builder /app/target/*.jar app.jar

# Expose the port your app runs on
EXPOSE 8081

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
