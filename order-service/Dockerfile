FROM openjdk:21-jdk-slim
RUN apt-get update && apt-get install -y curl
VOLUME /tmp
COPY target/order-service-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
