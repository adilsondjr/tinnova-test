# Cadastro de Veículos
REST APIs implementada utilizando Spring Boot 3 e H2 Database.

## Como executar?

Está aplicação está utilizando um servidor Tomcat embutido rodando na porta 8080. Não é necessário instalação do Tomcat. Você pode rodar utilizando apenas o comando ```java -jar```

* Clone este repositório

* Utilize Java 17 e Maven 3x+

## REST APIs Endpoints

* Cadastrar um Veículo: ``` /veiculos (POST) ```
* Atualizar um Veículo: ``` /veiculos/{id} (PUT)```
* Listar os Veículo: ``` /veiculos (GET)```
* Buscar um Veículo por ID: ``` /veiculos/{id} (GET)```
* Atualizar Parcialmente um Veículo: ``` /veiculos/{id} (PATCH)```
* Excluir um Veículo: ``` /veiculos/{id} (DELETE)```