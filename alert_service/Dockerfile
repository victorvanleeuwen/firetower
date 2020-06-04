FROM adoptopenjdk/openjdk13
ADD $GITHUB_WORKSPACE/jarpack/*.jar alert-service.jar
EXPOSE 9070
ENTRYPOINT ["java","-jar","alert-service.jar"]