# exercise3_sw_architecture
Exercise 3 - Backend applications. Contains the .yaml for swagger, 1 spring boot app of rest services and 1 gateway netflix zuul app

Este repositório contempla dois projetos spring boot:
1. MyApp - aplicação REST para consulta de livros + myAppAPI.yaml (arquivo swagger da documentacao da API)
2. Gateway - aplicação gateway com netflix zuul

Para executar os projetos, primeiro importe-os para o eclipse utilizando o comando "Import existing Maven project".

Em cada um dos projetos, vá nas Propriedades do Projeto -> Java Build Path e edite a JRE utilizada no projeto para uma jdk java

Em cada um dos projetos, realize um mvn install, para download da dependências de projetos necessárias.

Caso, ambos os projetos tenham sido instalados com sucesso, execute como uma aplicação Spring Boot o projeto MyApp e em seguida o projeto gateway.

Você conseguirá acessar a aplicação MyApp, através do gateway na seguinte url: http://localhost:8080/MyApp/
Ex.: Consulta dos livros http://localhost:8080/MyApp/books

