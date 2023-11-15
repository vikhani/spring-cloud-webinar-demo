FROM openjdk:17.0.2-jdk-slim-buster
VOLUME /tmp
COPY build/libs/gateway-0.0.1.jar gateway.jar
ENTRYPOINT ["java","-jar","/docgen.jar"]