FROM adoptopenjdk/openjdk13
ADD target/eureka-serivce.jar $GITHUB_WORKSPACE/jarpack/*.jar
EXPOSE 8761
ENTRYPOINT ["java","-jar","eureka-serivce.jar"]