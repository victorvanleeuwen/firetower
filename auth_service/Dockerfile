FROM adoptopenjdk/openjdk13
ADD target/auth-service.jar auth-service.jar
EXPOSE 9010
ENTRYPOINT ["java","-jar","auth-service.jar"]