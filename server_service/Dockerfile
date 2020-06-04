FROM adoptopenjdk/openjdk13
ADD $GITHUB_WORKSPACE/jarpack/*.jar server-service.jar
EXPOSE 9030
ENTRYPOINT ["java","-jar","server-service.jar"]