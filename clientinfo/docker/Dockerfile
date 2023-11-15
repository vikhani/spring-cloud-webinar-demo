FROM openjdk:17.0.2-jdk-slim-buster
VOLUME /tmp
COPY build/libs/clientinfo-0.0.1.jar clientinfo.jar
ENTRYPOINT ["java","-jar","/clientinfo.jar"]