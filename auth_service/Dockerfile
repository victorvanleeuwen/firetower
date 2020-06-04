FROM adoptopenjdk/openjdk13
ADD $GITHUB_WORKSPACE/jarpack/*.jar auth-service.jar
EXPOSE 9010
ENTRYPOINT ["java","-jar","auth-service.jar"]