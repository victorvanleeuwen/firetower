FROM adoptopenjdk/openjdk13
ADD $GITHUB_WORKSPACE/jarpack/*.jar monitoring-service.jar
EXPOSE 9080
ENTRYPOINT ["java","-jar","monitoring-service.jar"]