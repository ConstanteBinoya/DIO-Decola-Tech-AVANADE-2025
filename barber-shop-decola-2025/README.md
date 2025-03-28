# 💈 Barber Shop - Sistema de Agendamento

Bem-vindo ao **Barber Shop**, um sistema completo para gerenciamento de agendamentos em barbearias. Este projeto foi desenvolvido como parte de um desafio acadêmico e inclui tanto o **frontend** quanto o **backend**, garantindo uma experiência fluida e moderna para clientes e administradores.  

💡 **Este projeto faz parte do repósitório para entregas do bootcamp Decola Tech-2025, oferecido pela DIO (Digital Innovation One) em parceria com a AVANADE.**

---

## 🚀 Tecnologias Utilizadas

### 🔹 Frontend
- **Framework:** Angular 19
- **Linguagens:** TypeScript, HTML, SCSS
- **Gerenciamento de Estado:** Services e Observables
- **Estilização:** SCSS, Angular Material
- **Roteamento:** Angular Router
- **Construção & Deploy:** Angular CLI

### 🔹 Backend
- **Linguagem:** Node.js
- **Framework:** Express.js
- **Banco de Dados:** PostgreSQL
- **ORM:** Prisma
- **Autenticação:** JWT (JSON Web Token)
- **API RESTful:** CRUD de usuários, agendamentos e serviços

---

## 📌 Funcionalidades Principais

### 🏆 Para Clientes
- Agendar horários com barbeiros
- Consultar agendamentos futuros
- Cancelar ou reagendar horários
- Cadastro e login seguro

### ✂️ Para Administradores
- Gerenciar agenda da barbearia
- Cadastrar, editar e excluir serviços
- Gerenciar clientes e agendamentos
- Painel administrativo com estatísticas

---

## 🛠️ Como Executar o Projeto

### 📂 1. Clonar o Repositório
```bash
git clone https://github.com/seu-usuario/barber-shop.git
cd barber-shop
```

### 🔧 2. Configurar o Backend
```bash
cd backend
npm install
```

Criar um arquivo **.env** e definir as variáveis de ambiente:
```env
DATABASE_URL=postgresql://usuario:senha@localhost:5432/barbershop
JWT_SECRET=seu_segredo_aqui
```

Rodar as migrações do banco de dados:
```bash
npx prisma migrate dev
```

Iniciar o servidor:
```bash
npm start
```

### 🎨 3. Configurar o Frontend
```bash
cd ../frontend
npm install
ng serve
```

O frontend estará disponível em: **http://localhost:4200**

---

## 🏗️ Estrutura do Projeto

```
barber-shop/
│
├── frontend/          # Aplicação Angular
│   ├── src/
│   │   ├── app/
│   │   │   ├── components/
│   │   │   ├── pages/
│   │   │   ├── services/
│   │   │   ├── app.module.ts
│   │   │   ├── app.component.ts
│   ├── angular.json
│   ├── package.json
│
├── backend/           # API Node.js + Express
│   ├── src/
│   │   ├── controllers/
│   │   ├── models/
│   │   ├── routes/
│   │   ├── server.ts
│   ├── prisma/
│   ├── package.json
│   ├── .env.example
│
└── README.md
```

---

## 📌 Melhorias Futuras
- 📅 Integração com Google Calendar
- 📲 Notificações via WhatsApp
- 🔐 Recuperação de senha via e-mail
- 📊 Dashboard analítico para administradores

---

## 📞 Contato
Caso tenha dúvidas ou sugestões, entre em contato:
📧 Email: constantebinoyaz1@gmail.com  
🔗 LinkedIn: [/in/constante-binoya-26474b25a](https://linkedin.com/in/seu-perfil)  
🚀 Projeto desenvolvido com dedicação e aprendizado!

---

💡 **"Qualidade no atendimento começa com uma boa organização!"** ✂️💈

