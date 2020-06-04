FROM adoptopenjdk/openjdk13
ADD $GITHUB_WORKSPACE/jarpack/*.jar log-service.jar
EXPOSE 9040
ENTRYPOINT ["java","-jar","log-service.jar"]