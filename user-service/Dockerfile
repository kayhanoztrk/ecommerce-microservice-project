FROM arm64v8/openjdk:17-jdk
WORKDIR /src/uygulamam
COPY /target/user-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8082
CMD ["java","-jar","app.jar"]