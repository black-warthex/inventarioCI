FROM  openjdk:17-jdk-alpine3.14
COPY /build/libs/ci-0.0.1-SNAPSHOT.jar appCi.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar", "appCi.jar"]
