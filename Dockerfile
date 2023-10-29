FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/*.jar it-aa-user-management-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/it-aa-user-management-0.0.1-SNAPSHOT.jar"]
EXPOSE 10001
