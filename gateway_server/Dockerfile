FROM adoptopenjdk/openjdk13
ADD $GITHUB_WORKSPACE/jarpack/*.jar gateway-service.jar
EXPOSE 8762
ENTRYPOINT ["java","-jar","gateway-service.jar"]