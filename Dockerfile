# Base: Ubuntu latest
FROM ubuntu:latest

# Atualizar lista de pacotes
RUN apt update

# Instalar Gradle e OpenJDK 17
RUN apt install -y gradle openjdk-17-jdk

# Copiar todo o projeto para a pasta /App dentro do container
COPY ./ /App/

# Definir diretório de trabalho
WORKDIR /App/

# Comando padrão ao iniciar o container
CMD ./gradlew build