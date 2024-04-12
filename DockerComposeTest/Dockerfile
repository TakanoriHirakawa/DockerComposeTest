#Build the application
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn package -DskipTests

#Run the application
FROM openjdk:17-alpine
WORKDIR /app
COPY --from=build /app/target/DockerComposeTest-0.0.1-SNAPSHOT.jar ./compose-demo.jar
EXPOSE 8080
CMD ["java", "-jar", "compose-demo.jar"]