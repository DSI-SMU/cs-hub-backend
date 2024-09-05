FROM openjdk:17
WORKDIR app
ARG JAR_FILE=target/ai-driver.jar
COPY ${JAR_FILE} ai-driver.jar
EXPOSE 8088
ENTRYPOINT ["java","-jar","ai-driver.jar"]