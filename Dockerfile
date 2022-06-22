FROM openjdk:17-jdk
MAINTAINER neilwang webmaster@neilwang.wiki
ENV TZ "Asia/Shanghai"
RUN mkdir -p /data/apps/
ADD build/libs/qomolangma-3.0.1.jar  /data/apps/qomolangma-3.0.1.jar
WORKDIR /data/apps/
EXPOSE 8080
CMD ["java", "-jar", "qomolangma-3.0.1.jar"]
