FROM openjdk:17.0.2-jdk-slim-buster
VOLUME /tmp
COPY build/libs/config-0.0.1.jar config.jar
ENTRYPOINT ["java","-jar","/config.jar"]