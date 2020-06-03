FROM adoptopenjdk/openjdk13
ADD /home/runner/work/firetower/firetower/jarpack/*.jar eureka-serivce.jar
EXPOSE 8761
ENTRYPOINT ["java","-jar","eureka-serivce.jar"]