FROM openjdk:17.0.2-jdk-slim-buster
VOLUME /tmp
COPY build/libs/discovery-0.0.1.jar discovery.jar
ENTRYPOINT ["java","-jar","/discovery.jar"]