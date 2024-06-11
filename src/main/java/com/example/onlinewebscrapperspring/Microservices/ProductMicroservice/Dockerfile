FROM openjdk:22
LABEL authors="Kostiantyn"
EXPOSE 8082
ADD target/spring-boot-products-microservice.jar spring-boot-products-microservice.jar
ENTRYPOINT ["java", "-jar", "/spring-boot-products-microservice.jar"]