FROM adoptopenjdk/openjdk13
ADD $GITHUB_WORKSPACE/jarpack/*.jar data-service.jar
EXPOSE 9060
ENTRYPOINT ["java","-jar","data-service.jar"]