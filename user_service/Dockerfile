FROM adoptopenjdk/openjdk13
ADD $GITHUB_WORKSPACE/jarpack/*.jar user-service.jar
EXPOSE 9000
ENTRYPOINT ["java","-jar","user-service.jar"]