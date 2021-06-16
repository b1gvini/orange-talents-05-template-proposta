FROM adoptopenjdk/openjdk11:alpine
MAINTAINER "Vinicius de França"
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8081