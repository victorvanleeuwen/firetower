FROM adoptopenjdk/openjdk13
ADD target/server-service.jar server-service.jar
EXPOSE 9030
ENTRYPOINT ["java","-jar","server-service.jar"]