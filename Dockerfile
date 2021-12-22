FROM openjdk:8
EXPOSE 8080
ADD target/spring-boot-jenkins-example.jar spring-boot-jenkins-example.jar
ENTRYPOINT ["java","-jar","/spring-boot-jenkins-example.jar"]