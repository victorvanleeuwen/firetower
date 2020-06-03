FROM adoptopenjdk/openjdk13
ADD target/alert-service.jar alert-service.jar
EXPOSE 9070
ENTRYPOINT ["java","-jar","alert-service.jar"]