FROM openjdk:8
MAINTAINER hemchandra@outlook.com
VOLUME /tmp
ARG JAR_FILE
ADD ${JAR_FILE} boot_mysql_app.jar
EXPOSE 8082
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
ENTRYPOINT ["java","-jar","/boot_mysql_app.jar"]