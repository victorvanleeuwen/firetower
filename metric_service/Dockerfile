FROM adoptopenjdk/openjdk13
ADD $GITHUB_WORKSPACE/jarpack/*.jar metric-service.jar
EXPOSE 9050
ENTRYPOINT ["java","-jar","metric-service.jar"]