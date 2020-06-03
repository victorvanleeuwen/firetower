FROM adoptopenjdk/openjdk13
ADD target/eureka-serivce.jar /home/runner/work/firetower/firetower/jarpack/*.jar
EXPOSE 8761
ENTRYPOINT ["java","-jar","eureka-serivce.jar"]