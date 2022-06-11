FROM openjdk:17-jdk
RUN addgroup spring && adduser --ingroup spring spring
USER spring:spring
ARG DEPENDENCIES=build/dependencies
COPY ${DEPENDENCIES}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCIES}/META-INF /app/META-INF
COPY ${DEPENDENCIES}/BOOT-INF/classes /app
ENTRYPOINT ["java", "-cp", "app:app/lib/*", "com.qomolangma.Application"]
