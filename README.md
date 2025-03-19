# client-api 🚀

## 🌟 Descrição

Bem-vindo ao **client-api**! 😎  
Este é um projeto em Java para a criação de uma API RESTful, desenvolvido como parte de um desafio de **LAB da DIO** (Digital Innovation One). Ele utiliza **Spring Boot**, **JPA**, **Hibernate** e **MySQL** para a persistência de dados, e **Railway** para o deployment. 

A API permite o **cadastro de clientes** com as operações CRUD (Criar, Ler, Atualizar, Excluir). Simples, eficiente e escalável! 🔥

## 🛠️ Tecnologias Usadas

- **Spring Boot**: O framework que acelera o desenvolvimento da sua API REST.
- **JPA (Hibernate)**: Mapeamento objeto-relacional, para que você se concentre no código e não nos detalhes do banco de dados.
- **MySQL**: Banco de dados relacional para armazenar todas as informações de clientes.
- **Railway**: Deployment fácil e sem complicação na nuvem.
- **Maven/Gradle**: Ferramentas para gerenciamento de dependências e builds (escolha a que preferir!).

## 🔥 Funcionalidades

O **client-api** te oferece um CRUD completo para **Clientes**:
- **Criar** novos clientes.
- **Listar** todos os clientes.
- **Visualizar** detalhes de um cliente específico.
- **Excluir** um cliente.

Agora você pode gerenciar clientes com facilidade e sem complicação! 😄

### 📥 Pré-requisitos

Antes de começar, verifique se você tem o seguinte instalado:
- **JDK 11 ou superior** ☕
- **MySQL** (ou qualquer outro banco relacional configurado no `application.yml`) 🗄️
- **Maven ou Gradle** para rodar o projeto 🚧

---

### 📝 Uso Exemplos de Requisições API
1. Criar um cliente ✨
Método: POST
Endpoint: /clients
Body:

```json
{
  "name": "John Doe",
  "email": "john.doe@example.com"
}
```

2. Obter todos os clientes 👥
Método: GET
Endpoint: /clients

3. Obter um cliente por ID 🔍
Método: GET
Endpoint: /clients/{id}

4. Excluir um cliente 🗑️
Método: DELETE
Endpoint: /clients/{id}

---

### 🏗️ Estrutura do Projeto
A estrutura de pastas do client-api é organizada da seguinte forma:

```css
📦 client-api
┣ 📂 src/main/java/com/example/clientapi
┃ ┣ 📂 controller → Camada de controle
┃ ┣ 📂 service → Camada de serviço
┃ ┃ ┣ 📂 impl → Implementação das regras de negócio
┃ ┣ 📂 repository → Interface de acesso ao banco
┃ ┣ 📂 model → Representação das entidades
┃ ┣ 📂 dto → Data Transfer Object
┃ ┣ 📜 ClientApiApplication.java → Classe principal
┣ 📂 src/main/resources
┃ ┣ 📜 application.yml → Configuração do banco
┣ 📜 build.gradle → Dependências do projeto
```
---

### 🔗 Diagrama de Banco de Dados/Relacionamentos
Aqui está o diagrama que representa os relacionamentos do banco de dados, com base nas entidades Client e Order:

```mermaid
classDiagram
    Client "1" --> "0..*" Order : has
    Client : +Long id
    Client : +String name
    Client : +String email

    Order : +Long id
    Order : +String product
    Order : +Double price
    Order : +Long client_id

    Order --> Client : belongsTo
```
---
### 📝 Licença
Este projeto está licenciado sob a Licença MIT.

---

### 📬 Contato
Se tiver alguma dúvida, sugestão ou feedback, fique à vontade para entrar em contato! Vamos conversar! 😃

Email: constantebinoyaz1@gmail.com  
GitHub: https://github.com/ConstanteBinoya



