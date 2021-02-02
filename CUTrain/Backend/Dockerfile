# syntax=docker/dockerfile:experimental
FROM maven:3-jdk-8-slim as builder

LABEL MAINTAINER="Siritas Dho <siritas@gmail.com>"

ENV MAVEN_OPTS="-Xmx1024m"

WORKDIR /usr/src

COPY pom.xml .
RUN --mount=type=cache,target=/root/.m2 mvn -B -e -fn -C -T 1C dependency:go-offline

COPY src ./src
RUN --mount=type=cache,target=/root/.m2 mvn -B -e -o -T 1C -DskipTests verify

# Stage 2
FROM adoptopenjdk:8-hotspot

ENV JAVA_OPTS="-Djava.awt.headless=true  -Djava.security.egd=file:/dev/./urandom  -Dspring.jmx.enabled=false -XX:+UseG1GC -XX:TieredStopAtLevel=1 -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -Dfile.encoding=UTF-8 -noverify -server"
ENV SPRING_PROFILES_ACTIVE=uat
ENV SPRING_APPLICATION_JSON='{}'

# Add Maven dependencies (not shaded into the artifact; Docker-cached)
ARG DEPENDENCY=/usr/src/target/dependency
COPY --from=builder ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=builder ${DEPENDENCY}/org /app/org
COPY --from=builder ${DEPENDENCY}/WEB-INF /app/WEB-INF

EXPOSE 8080

ENTRYPOINT ["java", "-cp", "app:app/WEB-INF/classes:app/WEB-INF/lib-provided/*:app/WEB-INF/lib/*", "com.ssru.back.admission.MainApplication"]
