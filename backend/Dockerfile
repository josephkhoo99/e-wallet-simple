FROM eclipse-temurin:17-jre

WORKDIR /app

COPY target/e-wallet-api-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8085

ENTRYPOINT ["java", "-jar", "app.jar"]