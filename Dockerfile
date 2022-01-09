FROM openjdk:11.0.13-jre-slim
COPY target/api-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]