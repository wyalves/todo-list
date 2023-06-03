# Base stage
FROM eclipse-temurin:17-jdk-alpine AS base

WORKDIR /app
COPY .mvn/ .mvn
COPY pom.xml mvnw ./
RUN ./mvnw dependency:resolve
COPY src ./src

# Test stage
FROM base as test
CMD ["./mvnw", "test"]

# Development stage (with remote debugging)
FROM base AS development
CMD ["./mvnw", "spring-boot:run", "-Dspring-boot.run.jvmArguments='-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005'"]

# Build stage
FROM base AS build
RUN ./mvnw package -DskipTests

# Production stage (with JRE instead of JDK)
FROM eclipse-temurin:17-jre-alpine AS production
EXPOSE 8080
COPY --from=build /app/target/*.jar todo_list_api.jar
CMD ["java", "-jar", "todo_list_api.jar"]
