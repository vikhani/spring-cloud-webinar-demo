# Demo project for the Spring Cloud Webinar

### Presentation should be available [here](https://vikhani.github.io/spring-cloud-webinar/).

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white) ![Spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white) ![RabbitMQ](https://img.shields.io/badge/rabbitmq-%23FF6600.svg?&style=for-the-badge&logo=rabbitmq&logoColor=white) ![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white) 	![Kubernetes](https://img.shields.io/badge/kubernetes-%23326ce5.svg?style=for-the-badge&logo=kubernetes&logoColor=white) ![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)

This project contains basic examples for adding **Spring Cloud** components to your own projects.

Each branch shows changes needed to add the corresponding component:

#### 1. [Config](https://github.com/vikhani/spring-cloud-webinar-demo/tree/1_config)
> Component for configuring several modules/services from the same config source.

#### 2. [Discovery](https://github.com/vikhani/spring-cloud-webinar-demo/tree/2_discovery)
> Service discovery component.

#### 3. [OpenFeign](https://github.com/vikhani/spring-cloud-webinar-demo/tree/3_feign)
> A declarative REST client.

#### 4. [Gateway](https://github.com/vikhani/spring-cloud-webinar-demo/tree/4_gateway)
> Routing service component.

#### 5. [Circuit Breaker](https://github.com/vikhani/spring-cloud-webinar-demo/tree/5_circuit_breaker)
> Component that provides an abstraction for the Circuit Breaker pattern with Resilience4j as an implementation.

#### 6. [Vault](https://github.com/vikhani/spring-cloud-webinar-demo/tree/6_vault)
> Secret storage management - Hashicorp's Vault.

#### 7. [Bus](https://github.com/vikhani/spring-cloud-webinar-demo/tree/7_bus)
> Broadcast service for system-wide configuration update triggers or other messages. Uses RabbitMQ as a transport system.


Additionally:
#### [Minimal K8s demo](https://github.com/vikhani/spring-cloud-webinar-demo/tree/8_k8s)
> Minimal demonstration on how Spring Cloud components can be used with the Kubernetes deployments.

