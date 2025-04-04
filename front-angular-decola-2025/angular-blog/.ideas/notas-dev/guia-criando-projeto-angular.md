# 🎯 Guia de Criação de Projeto Angular

## 💾 1. Instalação do Angular e Configuração do Ambiente
Antes de iniciar o projeto, é necessário ter o Node.js e o Angular CLI instalados.

### Instalar Node.js e Angular CLI
1. Baixe e instale o Node.js.
2. Verifique a instalação:
   ```bash
   node -v
   npm -v
   ```
3. Instale o Angular CLI globalmente:
   ```bash
   npm install -g @angular/cli
   ```
4. Verifique a instalação do Angular CLI:
   ```bash
   ng version
   ```

---

## 💻 2. Criando um Novo Projeto Angular
No terminal, execute o comando para criar um novo projeto:

```bash
ng new meu-projeto
```
### ⁉️ **O Angular CLI solicitará algumas configurações:**

- 1️⃣ **Would you like to add Angular routing?** (Gostaria de adicionar roteamento Angular?) → **Y** (Sim, para ativar o roteamento)

- 2️⃣ **Which stylesheet format would you like to use?** (Qual formato de folha de estilo você gostaria de usar?) → Escolha entre **CSS, SCSS, SASS ou LESS**

- 3️⃣ **Do you want to enable Server-Side Rendering (SSR) and Static Site Generation (SSG/Prerendering)?** → **Escolha Y para ativar SSR ou N para não ativar.**

   - **SSR (Server-Side Rendering):** Ideal para sites dinâmicos com conteúdo atualizado frequentemente, como e-commerces, redes sociais e plataformas interativas. O SEO é fortalecido porque o servidor entrega páginas já renderizadas com o conteúdo atualizado a cada requisição.
   - **SSG (Static Site Generation):** Excelente para sites estáticos (blogs, documentações, landing pages), pois gera tudo no build e entrega rapidamente.

- 4️⃣ **Would you like to use the Server Routing and App Engine APIs (Developer Preview) for this server application? (y/N)**

   Se você responder **"y"**, o Angular ativará o suporte para Server Routing e App Engine APIs. Isso significa que:  
   - ✅ Você poderá definir rotas diretamente no servidor.  
   - ✅ Terá acesso a APIs do App Engine para gerenciar requisições.  
   - ✅ O projeto usará um modelo mais próximo de um backend tradicional, com funcionalidades avançadas.

   Se responder **"n"**, o Angular seguirá com o roteamento padrão no cliente (navegador), ou seja, as rotas continuarão funcionando apenas como parte da SPA, sem interação com o servidor.

   **🤔 Quando escolher "y" ou "n"?**
   - Escolher **"y"** se quiser um servidor mais robusto, com rotas e APIs no backend (ideal para aplicações que fazem processamento no servidor).
   - Escolher **"n"** se quiser um projeto mais simples, baseado em SPA tradicional, onde todas as rotas são gerenciadas pelo Angular no navegador do usuário.

5️⃣ **Aguarde a instalação das dependências e a criação dos arquivos do projeto.**

🔧 **Após o processo terminado seu projeto terá a seguinte estrutura criada automaticamente pelo CLI:**

- Logo após a finalização do `ng new`:    
![Após o `ng new`](.ideas/img/ng-new.png)  

- /vscode:  
![Após o `ng new`](.ideas/img/ng-new_vscode.png)  

- /node_modules:  
![Após o `ng new`](.ideas/img/ng-new_node_modules.png)  

- /public:  
![Após o `ng new`](.ideas/img/ng-new_public.png)  

- /src:  
![Após o `ng new`](.ideas/img/ng-new_src.png)  

- /src/app:  
![Após o `ng new`](.ideas/img/ng-new_src_app.png)

📌 **Toda esta estrutura, acima, é criada automaticamente pelo sistema ao executar o comando `ng new`.**

---

## ⚠️ 3. Instalando Dependências com npm install ⚠️
### ⛔ **Esta fase só deve ser executada se seu projeto se enquadrar nas situaçãoes a baixo:**

- ✅ **Instalar as dependências do projeto:**  
  - Quando você clona um projeto Angular de um repositório (como o GitHub), os arquivos das bibliotecas e pacotes utilizados não vêm junto. O `npm install` baixa e instala todas as dependências listadas no arquivo package.json.

- ✅ **Criar a pasta node_modules/:**  
  - O comando baixa os pacotes necessários e os armazena na pasta node_modules/. Essa pasta pode ser pesada e, por isso, geralmente é ignorada no versionamento (via .gitignore).

- ✅ **Garantir que o projeto funcione corretamente:**  
  - Sem executar npm install, o Angular CLI e outros pacotes do projeto podem não estar disponíveis, resultando em erros ao tentar rodar a aplicação.

### 🚩 **Dessa maneira, após clonar o projeto, entre na pasta do projeto e execute:**
```bash
npm install
```
Isso garante que todas as bibliotecas necessárias sejam instaladas corretamente.

✅ **O que `npm install` faz?**
- Instala todas as dependências listadas no `package.json`.
- Cria a pasta `node_modules/`.
- Garante que o projeto funcione corretamente.

💡 **Quando executar `npm install`?**
- Após clonar um projeto Angular de um repositório.
- Após deletar a pasta `node_modules/`.
- Após modificar pacotes no `package.json` manualmente.

---

## 💽 4. Criando Componentes

### 📄 Estrutura Básica de um Componente Angular
Quando você executa o comando abaixo:

```bash
ng generate component components/nome-diretorio
```
O Angular cria automaticamente a estrutura básica de um componente, localizada em:
`src/app/components/nome-diretorio`

### 📁 Estrutura Criada
```css
src/
└── app/
    └── components/
        └── nome-diretorio/
            ├── nome-diretorio.component.ts          ← Lógica (classe) do componente
            ├── nome-diretorio.component.html        ← Template (estrutura HTML)
            ├── nome-diretorio.component.css         ← Estilos do componente 
            └── nome-diretorio.component.spec.ts     ← Arquivo de testes (unitários)
```

### 📇 Gere os componentes principais para o seu modelo de blog:
Após, estratégicamente, ter decidido previamente quais serão os componentes que estruturarão o corpo da página, fique a vontade para criar cada um deles.  
Ex: 
```bash
ng generate component components/menu-bar
ng generate component components/menu-title
ng generate component components/big-card
ng generate component components/small-card
```
💡 Aprofunde-se em [guia-componentizacao.md](guia-componentizacao.md)

---

## 📋 5. Criando Páginas e Configurando Rotas
Crie as páginas principais:

```bash
ng generate component pages/home
ng generate component pages/content
```
Você está criando dois componentes dentro da pasta `pages`, que indicam páginas principais da aplicação Angular.

### 🔍 Significado de `pages/home` e `pages/content`
- **pages:** Diretório reservado para armazenar views completas do sistema (páginas com layout próprio).

- **home:** Componente que representa a página inicial.

- **content:** Componente que pode representar uma página de conteúdo específico (ex: artigo, dashboard, post, etc).

### ✅ Boas Práticas
Organizar componentes em pages é uma boa prática recomendada, especialmente em projetos maiores, pois:

- 📦 Organiza melhor as páginas principais do sistema;

- 🚀 Facilita a escalabilidade, separando views e componentes reutilizáveis;

- 🔧 Melhora a manutenção e leitura do código;

- 🌐 Alinha com a configuração de rotas do Angular (`RouterModule`).

### 🧠 O que colocar dentro da pasta pages/content
A pasta `content`, dentro da estrutura `pages/content`, geralmente representa **uma página de conteúdo específico da sua aplicação Angular**. Ela pode funcionar como um template ou uma view para exibir dados principais, artigos, dashboards ou qualquer outra informação importante.

- 📁 **A pasta é criada com quatro arquivos por padrão:**
```css
content.component.ts       → Lógica do componente
content.component.html     → Estrutura (HTML)
content.component.css      → Estilos locais
content.component.spec.ts  → Testes do componente
```

📎 **Você pode usar essa pasta para:**
- Exibir conteúdo principal (como posts, produtos, dashboards);
- Criar layouts específicos para essa seção;
- Conectar-se a serviços para buscar e mostrar dados dinâmicos (via API ou Firebase, por exemplo);
- Configurar rotas para navegar até a página (ex: /content, /content/:id etc).

### 🧱 Exemplo de Estrutura de Pastas
```css
src/
└── app/
    ├── pages/
    │   ├── home/
    │   │   ├── home.component.ts
    │   │   └── ...
    │   └── content/
    │       ├── content.component.ts
    │       └── ...
    ├── components/
    │   ├── header/
    │   └── footer/
    └── app-routing.module.ts
```
Essa abordagem torna o projeto modular e preparado para crescimento, facilitando o desenvolvimento com qualidade e organização.

### 🚸 Configure as rotas em `app.routes.ts`:

```typescript
import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { ContentComponent } from './pages/content/content.component';

export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'content', component: ContentComponent }
];
```

### 🧩 main.ts (inicialização com provideRouter)
Certifique-se de configurar o roteamento no main.ts, assim:
```typescript
import { bootstrapApplication } from '@angular/platform-browser';
import { AppComponent } from './app/app.component';
import { provideRouter } from '@angular/router';
import { routes } from './app/app.routes';

bootstrapApplication(AppComponent, {
  providers: [provideRouter(routes)]
});
```
---

## 📜 6. Criando um Arquivo de Dados Fake (`dataFake.ts`)
Crie o arquivo `dataFake.ts` dentro de `src/app/data/`:
```bash
ng generate service data/dataFake
```
### 📌 O que significa `service` no comando ng generate service `data/dataFake`:  
- service é uma especificação de tipo de artefato do Angular que indica que você quer gerar **um serviço Angular**.

- O Angular CLI entende que você deseja criar uma classe de serviço TypeScript, com suporte à injeção de dependência e uso compartilhado entre componentes.

### 🧪 O que é um serviço no Angular?

Um **serviço** (`service`) no Angular é uma **classe reutilizável** usada para encapsular funcionalidades que não estão diretamente ligadas à exibição de dados (como ocorre nos componentes), mas sim à lógica de negócio e manipulação de dados.

### Funções e Utilidades

| Função                      | Descrição                                                                 |
|----------------------------|---------------------------------------------------------------------------|
| 🔄 **Compartilhar lógica**     | Compartilhar código entre componentes, como regras de negócio.            |
| 💾 **Gerenciar dados**         | Controlar dados da aplicação (ex: buscar, armazenar ou simular dados).    |
| 🌐 **Fazer chamadas HTTP**     | Consumir APIs externas com o `HttpClient`.                                |
| 🧠 **Separar responsabilidades** | Manter os componentes mais limpos e organizados.                          |

### 🎯 Vantagens

- Reduz a duplicação de código
- Facilita a manutenção e testes
- Permite injeção de dependência (DI) para desacoplamento

### 💡 Exemplo de configuração:
```typescript
export const dataFake = [
  {
    id: '1',
    title: 'Título do Post',
    description: 'Descrição do post...',
    photoCover: 'https://source.unsplash.com/random'
  },
  {
    id: '2',
    title: 'Outro Post',
    description: 'Mais informações...',
    photoCover: 'https://source.unsplash.com/random'
  }
];
```
### 📌 O que é o dataFake.ts?
O arquivo `dataFake.ts` é uma **simulação de dados** — ou seja, ele não é um recurso nativo ou obrigatório do Angular. Ele serve para fornecer dados temporários e estáticos que imitam a estrutura de dados reais, como se viessem de uma API ou banco de dados.

### 🧠 Para que ele serve?
Ele é utilizado principalmente para **protótipos, testes e desenvolvimento de interface**. Em vez de já configurar um backend real ou uma API, você simula a presença de dados reais no frontend com esse tipo de arquivo.

💡 **Exemplo de usos:**
- Popular cards, listas ou tabelas com conteúdo.
- Desenvolver e testar visualmente os componentes.
- Trabalhar no frontend enquanto o backend ainda está em construção.
- Fazer testes de navegação entre páginas com base em `id`.

### 🧩 Como ele é utilizado?
Suponha que você tenha um componente que renderiza um "card de post". Você importa o `dataFake.ts` e usa os dados dele para alimentar o HTML:

## 📍 Resumo sobre `dataFake.ts`

| Característica        | Descrição                                                                 |
|-----------------------|---------------------------------------------------------------------------|
| 🔨 **Tipo**            | Simulação manual de dados (*mock*)                                        |
| 📦 **Nativo do Angular** | ❌ Não. É específico do seu projeto ou de algum tutorial que você esteja seguindo |
| 🎯 **Finalidade**       | Substituir dados reais enquanto desenvolve o frontend                   |
| 🚀 **Quando remover?**  | Quando integrar com um backend real ou API oficial                       |

---
---

## 🎨 7. Estilizando a Aplicação
Adicione estilos globais em `src/styles.css`. Exemplo de estilização de `big-card.component.css`:

```css
.big-card {
  width: 100%;
  border-radius: 10px;
  overflow: hidden;
  box-shadow: 2px 2px 10px rgba(0, 0, 0, 0.1);
}
```

---

## 🎬 8. Executando e Testando a Aplicação
Para rodar o projeto localmente:

```bash
ng serve
```

Acesse `http://localhost:4200/` no navegador.

---

## 📺 9. Preparando para Deploy
Gere os arquivos para produção:

### 📦 Comando `ng build` no Angular
🔧 **O que é `ng build`?**

O comando `ng build` no Angular serve para **compilar e empacotar** a aplicação em arquivos otimizados e prontos para serem hospedados em servidores web (produção ou homologação).

### ✅ Sintaxes Possíveis

📁 1. `ng build`
- Gera a build padrão (modo desenvolvimento).
- Utiliza a configuração `development` definida no `angular.json`.
- Gera arquivos **não otimizados**, úteis para testes locais.

🚀 2. `ng build --configuration=production`
- Gera a build em modo **produção**.
- Utiliza a configuração `production` definida no `angular.json`.
- Aplica **otimizações automáticas** como:
  - Minificação do código.
  - Remoção de código morto (tree-shaking).
  - Compactação de arquivos.
  - Habilitação de modo produção no Angular.

---

## 🧪 Quando usar qual?

| Situação                        | Comando recomendado                   |
| ------------------------------ | ------------------------------------- |
| Testes locais com debug ativo  | `ng build`                            |
| Publicar aplicação em servidor | `ng build --configuration=production` |

---

## 🧳 Onde ficam os arquivos gerados?

Após o build, os arquivos compilados são colocados na pasta `dist/nome-do-projeto/`

---
---

# 📁 Entendendo a Estrutura do Projeto Angular-Blog 📁

## **Diretórios e Arquivos Principais**

### Configurações e Dependências

| Caminho               | Função                                                | Gerado Automaticamente? | Fato Gerador |
|----------------------|--------------------------------------------------|----------------------|--------------|
| `angular.json`       | Configuração global do Angular CLI.                | ✅ | Criado pelo comando `ng new`. |
| `.browserslistrc`    | Define quais navegadores devem ser suportados.      | ✅ | Criado pelo comando `ng new`. |
| `.editorconfig`      | Define regras de formatação do código.              | ✅ | Criado pelo comando `ng new`. |
| `karma.conf.js`      | Configuração do Karma (ferramenta de testes).       | ✅ | Criado pelo comando `ng new`. |
| `package.json`       | Lista as dependências do projeto e scripts úteis.   | ✅ | Criado pelo comando `ng new`. |
| `tsconfig.app.json`  | Configuração TypeScript específica para a aplicação. | ✅ | Criado pelo comando `ng new`. |
| `tsconfig.json`      | Configuração global do TypeScript.                   | ✅ | Criado pelo comando `ng new`. |
| `tsconfig.spec.json` | Configuração TypeScript para testes.                 | ✅ | Criado pelo comando `ng new`. |

### Dependências e Build

| Caminho              | Função                                                   | Gerado Automaticamente? | Fato Gerador |
|---------------------|-------------------------------------------------------|----------------------|--------------|
| `node_modules/`    | Contém todas as dependências do projeto.                | ✅ | Criado ao rodar `npm install`. |
| `package-lock.json` | Define versões exatas das dependências instaladas.      | ✅ | Criado ao rodar `npm install`. |
| `dist/`            | Diretório gerado após o build da aplicação.              | ✅ | Criado ao rodar `ng build`. |
| `.angular/cache/`  | Cache gerado automaticamente pelo Angular.               | ✅ | Criado ao rodar `ng build` ou `ng serve`. |

## **Diretório `src` (Código-Fonte)**

| Caminho                      | Função                                                    | Gerado Automaticamente? | Fato Gerador |
|-----------------------------|--------------------------------------------------------|----------------------|--------------|
| `src/app/`                  | Contém componentes, páginas e módulos.                 | ✅ | Criado pelo comando `ng new`. |
| `src/app/components/`       | Diretório de componentes reutilizáveis.                | ❌ | Criado manualmente. |
| `src/app/pages/`            | Contém as páginas principais da aplicação.             | ❌ | Criado manualmente. |
| `src/app/data/dataFake.ts`  | Simula um banco de dados falso com dados mockados.     | ❌ | Criado manualmente. |
| `src/app/app-routing.module.ts` | Define as rotas da aplicação.                         | ✅ | Criado pelo comando `ng generate module app-routing`. |
| `src/app/app.component.ts`  | Componente raiz da aplicação.                         | ✅ | Criado pelo comando `ng new`. |
| `src/app/app.module.ts`     | Módulo principal da aplicação.                        | ✅ | Criado pelo comando `ng new`. |
| `src/assets/`               | Contém imagens e arquivos estáticos.                   | ✅ | Criado pelo comando `ng new`. |
| `src/environments/`         | Configurações para ambientes de dev e produção.       | ✅ | Criado pelo comando `ng new`. |
| `src/index.html`            | HTML principal da aplicação.                          | ✅ | Criado pelo comando `ng new`. |
| `src/main.ts`               | Ponto de entrada da aplicação.                        | ✅ | Criado pelo comando `ng new`. |
| `src/styles.css`            | Arquivo global de estilos.                            | ✅ | Criado pelo comando `ng new`. |

## **Componentes (`src/app/components/`)**

| Caminho           | Função                                    | Gerado Automaticamente? | Fato Gerador |
|------------------|----------------------------------------|----------------------|--------------|
| `big-card/`     | Exibe cartões grandes com conteúdo.     | ❌ | Criado manualmente ou `ng generate component big-card`. |
| `menu-bar/`     | Barra de menu da aplicação.             | ❌ | Criado manualmente ou `ng generate component menu-bar`. |
| `menu-title/`   | Título do menu, versão responsiva.      | ❌ | Criado manualmente ou `ng generate component menu-title`. |
| `small-card/`   | Exibe cartões menores.                  | ❌ | Criado manualmente ou `ng generate component small-card`. |

## **Páginas (`src/app/pages/`)**

| Caminho     | Função                            | Gerado Automaticamente? | Fato Gerador |
|------------|--------------------------------|----------------------|--------------|
| `content/` | Página que exibe conteúdo do blog. | ❌ | Criado manualmente ou `ng generate component pages/content`. |
| `home/`    | Página inicial do blog.          | ❌ | Criado manualmente ou `ng generate component pages/home`. |

## **Diretório `dist` (Build da Aplicação)**

| Arquivo          | Função                                       | Gerado Automaticamente? | Fato Gerador |
|----------------|-------------------------------------------|----------------------|--------------|
| `index.html`  | Entrada principal da aplicação.          | ✅ | Criado ao rodar `ng build`. |
| `main.js`     | Código principal da aplicação compilado. | ✅ | Criado ao rodar `ng build`. |
| `styles.css`  | Estilos compilados.                     | ✅ | Criado ao rodar `ng build`. |
| `runtime.js`  | Scripts necessários para execução.      | ✅ | Criado ao rodar `ng build`. |

Agora, você pode usar este README como manual para futuras consultas! 🚀


