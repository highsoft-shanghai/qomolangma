FROM openjdk:17-jdk
MAINTAINER neilwang webmaster@neilwang.wiki
ENV TZ "Asia/Shanghai"
RUN mkdir -p /data/apps/
ADD build/libs/${APP_NAME}.jar  /data/apps/${APP_NAME}.jar
WORKDIR /data/apps/
EXPOSE 8080
CMD ["java", "-jar", "${APP_NAME}.jar"]
