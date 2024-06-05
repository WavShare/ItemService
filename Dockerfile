# Use an official Maven image as the base image
FROM maven:3.9.6-eclipse-temurin-21-alpine AS build
# Set the working directory in the container
WORKDIR /app
# Copy mvn, the pom.xml and the project files to the container
#COPY .mvn/ .mvn
COPY pom.xml .
COPY src ./src
# Build the application using Maven
#RUN ./mvnw dependency:go-offline
RUN mvn clean package -DskipTests
# Use an official Maven image as the base image
FROM maven:3.9.6-eclipse-temurin-21-alpine
# Set the working directory in the container
WORKDIR /app
# Expose the port within the container
EXPOSE 8080
#EXPOSE 8091
# Copy the built JAR file from the previous stage to the container
COPY --from=build /app/target/*.jar /app/*.jar
# Run the application
ENTRYPOINT ["java","-jar","/app/*.jar"]