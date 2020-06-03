FROM adoptopenjdk/openjdk13
ADD $GITHUB_WORKSPACE/jarpack/*.jar eureka-serivce.jar
EXPOSE 8761
ENTRYPOINT ["java","-jar","eureka-serivce.jar"]