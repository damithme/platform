FROM openjdk:8-jdk-alpine
#ENV APP_FILE user-service-1.0.jar
#ENV APP_HOME /home
#VOLUME /tmp
#RUN mkdir -p ${APP_HOME}
#WORKDIR ${APP_HOME}
#EXPOSE 8000
#COPY /build/libs/${APP_FILE}  ${APP_HOME}/${APP_FILE}
#ENTRYPOINT ["sh", "-c"]
#CMD ["exec java -Xmx50m -jar ${APP_FILE}"]

VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=build/libs/user-service-1.0.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Xmx50m","-jar","/app.jar"]
