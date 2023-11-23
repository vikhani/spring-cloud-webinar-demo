FROM openjdk:17.0.2-jdk-slim-buster
VOLUME /tmp
COPY build/libs/docgen-0.0.1.jar docgen.jar
ENTRYPOINT ["java","-jar","/docgen.jar"]