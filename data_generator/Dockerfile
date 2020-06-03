FROM adoptopenjdk/openjdk13
ADD target/data-service.jar data-service.jar
EXPOSE 9060
ENTRYPOINT ["java","-jar","data-service.jar"]