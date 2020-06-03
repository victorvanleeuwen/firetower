FROM adoptopenjdk/openjdk13
ADD target/log-service.jar log-service.jar
EXPOSE 9040
ENTRYPOINT ["java","-jar","log-service.jar"]