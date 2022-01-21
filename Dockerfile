## To build, run the following command from the top level project directory:
##
## docker build -f src/main/docker/Dockerfile .
#
FROM openjdk:17-jdk-alpine as builder
WORKDIR /task2
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar
RUN mvn clean install
#RUN java -Djarmode=layertools -jar application.jar extract

FROM openjdk:17-jdk-alpine
#COPY --from=builder dependencies/ ./
#COPY --from=builder spring-boot-loader/ ./
##COPY --from=builder internal-dependencies/ ./
#COPY --from=builder snapshot-dependencies/ ./
#COPY --from=builder application/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]
#FROM openjdk:17-jdk-alpine
#RUN addgroup -S spring && adduser -S spring -G spring
#USER spring:spring
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} app.jar
#EXPOSE 8080
#ENTRYPOINT ["java","-jar","/app.jar"]