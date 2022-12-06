FROM openjdk

ARG JAR_FILE=src/main/docker/*.jar

COPY ${JAR_FILE} app.jar

EXPOSE 80

ENTRYPOINT ["java", "-jar", "app.jar"]
