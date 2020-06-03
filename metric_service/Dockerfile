FROM adoptopenjdk/openjdk13
ADD target/metric-service.jar metric-service.jar
EXPOSE 9050
ENTRYPOINT ["java","-jar","metric-service.jar"]