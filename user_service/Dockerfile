FROM adoptopenjdk/openjdk13
ADD target/user-service.jar user-service.jar
EXPOSE 9000
ENTRYPOINT ["java","-jar","user-service.jar"]