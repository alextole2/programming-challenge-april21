FROM postgres
ADD init-user-db.sh /docker-entrypoint-initdb.d/

FROM openjdk:8-jdk-alpine
RUN apk update && apk upgrade
VOLUME /tmp
EXPOSE 8680
#RUN gradle clean build -i --stacktrace
ADD build/libs/*.jar movies-backend.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=production","-jar","/movies-backend.jar"]
#CMD ["java", "-jar", "-Xms64m", "-Xmx128m", "movies-backend.jar"]