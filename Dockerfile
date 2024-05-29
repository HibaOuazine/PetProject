FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.war
COPY ./target/PetProject-0.0.1-SNAPSHOT.war app.war
LABEL authors="HP"

ENTRYPOINT ["java", "-war","./app.war"]