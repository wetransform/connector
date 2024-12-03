FROM eclipse-temurin:21.0.2_13-jre-alpine

ARG JVM_ARGS=""
ARG JAR

RUN apk --no-cache add curl

WORKDIR /app

COPY ${JAR} connector.jar

EXPOSE 8080

ENV WEB_HTTP_PORT="8080"
ENV WEB_HTTP_PATH="/"

HEALTHCHECK --interval=5s --timeout=5s --retries=10 CMD curl --fail http://localhost:8080/api/check/health

ENV ENV_JVM_ARGS=$JVM_ARGS

CMD ["sh", "-c", "exec java -jar connector.jar"]
