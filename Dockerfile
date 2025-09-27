# Estágio de Build: Usa o Maven para compilar o projeto
FROM maven:3.9-eclipse-temurin-17 AS builder
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

# Estágio Final: Usa uma imagem Java leve para rodar a aplicação
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
# Copia o .jar gerado e o renomeia para app.jar
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8080
# Inicia a aplicação usando o novo nome genérico
CMD ["java", "-jar", "app.jar"]