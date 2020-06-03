FROM adoptopenjdk/openjdk13
ARG JAR_FILE=""
ADD target/eureka-serivce.jar ${JAR_FILE}
EXPOSE 8761
ENTRYPOINT ["java","-jar","eureka-serivce.jar"]