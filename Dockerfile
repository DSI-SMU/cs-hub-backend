FROM openjdk:17
WORKDIR app
ARG JAR_FILE=target/cs-hub.jar
COPY ${JAR_FILE} cs-hub.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","cs-hub.jar"]