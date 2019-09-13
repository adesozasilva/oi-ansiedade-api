FROM openjdk:8-jdk-alpine
MAINTAINER Anderson Silva
EXPOSE 8080
ADD /target/oiansiedade-1.0.0-SNAPSHOT.jar oiansiedade-1.0.0-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "oiansiedade-1.0.0-SNAPSHOT.jar"]

