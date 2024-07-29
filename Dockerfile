<<<<<<< HEAD
FROM openjdk:17
ARG JAR_FILE=build/libs/*-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
=======
FROM openjdk:17
ARG JAR_FILE=build/libs/*-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
>>>>>>> branch 'main' of https://github.com/Urcarcher/urcarcher-be.git
