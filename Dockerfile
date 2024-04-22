FROM openjdk:21-jdk

EXPOSE 8089

LABEL author=kevin.rojo

COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]