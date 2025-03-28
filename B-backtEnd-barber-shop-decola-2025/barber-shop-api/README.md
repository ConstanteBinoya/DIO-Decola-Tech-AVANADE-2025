# 🏢 Barber Shop API

## 📌 Sobre o Projeto
A **Barber Shop API** é o backend do sistema de agendamento para barbearias, permitindo a gestão de clientes, horários e serviços. Este projeto foi desenvolvido para fornecer uma solução robusta e escalável, garantindo a melhor experiência tanto para barbearias quanto para seus clientes.

## 🚀 Tecnologias Utilizadas
O backend foi desenvolvido utilizando as seguintes tecnologias:
- **Node.js** - Ambiente de execução para JavaScript no servidor.
- **Express.js** - Framework para criação de APIs rápidas e flexíveis.
- **TypeScript** - Tipagem estática para maior segurança e manutenção do código.
- **PostgreSQL** - Banco de dados relacional para armazenamento dos dados.
- **TypeORM** - ORM para facilitar a manipulação do banco de dados.
- **JWT (JSON Web Token)** - Autenticação e segurança dos endpoints.
- **Docker** - Containerização para facilitar o deploy e o desenvolvimento.

## 📂 Estrutura do Projeto
A estrutura do backend segue um padrão modular para facilitar a manutenção e escalabilidade:
```
📦 barber-shop-api
 ┣ 📂 src
 ┃ ┣ 📂 controllers   # Lógica de controle das requisições
 ┃ ┣ 📂 entities      # Modelos de dados (TypeORM)
 ┃ ┣ 📂 middlewares   # Middlewares de autenticação e validação
 ┃ ┣ 📂 repositories  # Lógica de acesso ao banco de dados
 ┃ ┣ 📂 routes        # Definição das rotas da API
 ┃ ┣ 📂 services      # Regras de negócio
 ┃ ┗ 📜 server.ts     # Inicialização do servidor
 ┣ 📜 .env.example    # Exemplo do arquivo de variáveis de ambiente
 ┣ 📜 package.json    # Dependências e scripts do projeto
 ┣ 📜 tsconfig.json   # Configuração do TypeScript
 ┗ 📜 docker-compose.yml # Configuração do Docker
```

## 🔧 Configuração e Execução
### 1️⃣ **Pré-requisitos**
Antes de rodar o projeto, certifique-se de ter instalado:
- [Node.js](https://nodejs.org/) (versão recomendada: 18+)
- [Docker](https://www.docker.com/) e [Docker Compose](https://docs.docker.com/compose/)
- [PostgreSQL](https://www.postgresql.org/) (caso não utilize Docker)

### 2️⃣ **Configuração do Ambiente**
Crie um arquivo `.env` na raiz do projeto baseado no `.env.example` e configure as variáveis de ambiente:
```env
DATABASE_URL=postgres://usuario:senha@localhost:5432/barbershop
JWT_SECRET=minhaChaveSecreta
PORT=3000
```

### 3️⃣ **Instalação das Dependências**
```sh
npm install
```

### 4️⃣ **Rodando o Projeto**
#### ✅ Modo Desenvolvimento
```sh
npm run dev
```
#### 🐳 Modo Docker
```sh
docker-compose up --build
```

### 5️⃣ **Rodando as Migrações do Banco**
```sh
npm run typeorm migration:run
```

## 🔗 Endpoints da API
### 🔐 **Autenticação**
- `POST /auth/register` - Criar um novo usuário
- `POST /auth/login` - Autenticar usuário e obter token JWT

### 👥 **Usuários**
- `GET /users` - Listar usuários
- `GET /users/:id` - Buscar usuário por ID

### 📅 **Agendamentos**
- `POST /appointments` - Criar um novo agendamento
- `GET /appointments` - Listar agendamentos
- `DELETE /appointments/:id` - Cancelar um agendamento

### ✂️ **Serviços**
- `GET /services` - Listar serviços disponíveis
- `POST /services` - Criar um novo serviço
- `DELETE /services/:id` - Remover um serviço

## 📡 Integração com o Frontend
O frontend faz chamadas para os endpoints acima utilizando `fetch` ou `HttpClient` do Angular. Certifique-se de que a API está rodando na mesma URL configurada no frontend (`environment.ts`).

Caso esteja usando o frontend localmente e a API no Docker, utilize `http://localhost:3000` como base URL.

## 📝 Considerações Finais
Este backend foi desenvolvido para ser escalável e modular. Novos recursos podem ser facilmente adicionados e melhorias podem ser implementadas conforme necessário.

💡 **Dúvidas ou sugestões?** Fique à vontade para contribuir! 🚀

