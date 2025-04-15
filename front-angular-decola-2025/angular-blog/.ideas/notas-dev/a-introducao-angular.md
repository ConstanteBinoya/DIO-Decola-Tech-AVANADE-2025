# Introdução ao Angular 14 🚀

## 💡 O que é o Angular?

O **Angular** é um **framework front-end baseado em TypeScript**, mantido pelo Google. Ele permite criar **aplicações web estruturadas, modulares e escaláveis**. Diferente de bibliotecas como o React (que se concentra apenas na camada de visualização), o Angular é **completo** e já oferece **soluções integradas para rotas, formulários, requisições HTTP, testes, injeção de dependência, entre outros.**

## 🔬 Principais Tecnologias Envolvidas

- **HTML**: Estrutura da página.
- **CSS/SCSS**: Estilização dos elementos.
- **TypeScript**: Lógica de programação fortemente tipada.
- **JavaScript**: Base fundamental do comportamento dinâmico na web.

## 🧱 Estrutura e funcionamento:
* 🔤 **Base:** Angular se apoia no **HTML, CSS e JavaScript,** mas usa **TypeScript** como linguagem principal, o que adiciona tipagem estática e recursos avançados de orientação a objetos.

* 🧩 **Componentes:** São a unidade básica da **UI no Angular**. Cada componente possui:
  * Um **template HTML** (estrutura),
  * Uma **classe TypeScript** (lógica),
  * E um **arquivo CSS/SCSS** (estilo). Esses componentes podem ser **reutilizados** em diferentes partes da aplicação.

* 🌐 **Roteamento:** O **Angular Router** permite criar **navegação entre páginas (componentes)** da aplicação, de forma declarativa, mapeando caminhos (URLs) para componentes.



## 🧠 Conceitos Fundamentais 

### ✅ Componentes

- São a **unidade básica de uma aplicação Angular**.
- Cada componente é composto por:
  - Um arquivo `.ts` (classe com a lógica)
  - Um arquivo `.html` (template)
  - Um arquivo `.css` ou `.scss` (estilo)
- Permitem **reutilização de UI e lógica**, facilitando manutenção e expansão do projeto.

### ✅ Roteamento

- Gerenciado pelo **Angular Router**.
- Permite a navegação entre diferentes **componentes/páginas** sem recarregar a aplicação (SPA - Single Page Application).
- Roteamento é definido no módulo principal (geralmente `app-routing.module.ts`).

## 📌 Porque Usar Angular?

- Estrutura completa para grandes aplicações.
- Padrões modernos de desenvolvimento.
- Injeção de dependência embutida.
- Ótimo suporte para testes.
- Comunidade ativa e documentação abrangente.

---

# Estrutura Arquitetural com Angular CLI 🛠️

Uma das maiores vantagens de trabalhar com Angular é o poder da sua **CLI (Command Line Interface)**, que automatiza grande parte da criação estrutural do projeto. Isso permite que desenvolvedores foquem mais na lógica de negócio do que na configuração inicial da aplicação.

## 📎 Comandos Fundamentais

### 📦 Criação de um novo projeto

```bash
ng new nome-do-projeto
```
✏️ Esse comando:
* Cria a **estrutura básica** de uma aplicação Angular.
* **Gera todos os arquivos de configuração necessários** (como `angular.json`, `tsconfig.json`, `package.json`, etc).
* Prepara o projeto com **boas práticas e arquitetura modular** desde o início.

## 🧩 Criação de componentes reutilizáveis
```bash
ng generate component components/nome-do-componente
```
✏️Este comando cria:
* Uma pasta com 4 arquivos (`.ts`, `.html`, `.css` e `.spec.ts`) organizados dentro de src/app/components/.
* Um componente funcional pronto para ser usado na aplicação, sem que seja preciso escrever código manualmente para sua estrutura básica.

## 📄 Criação de páginas principais
```bash
ng generate component pages/nome-da-pagina
```
Segue a mesma lógica do comando anterior, mas direcionado ao diretório pages/, ideal para abrigar componentes de páginas completas da aplicação (ex: Home, Login, Dashboard, etc).

---

### **Benefícios da Angular CLI:**  
✅ Automatiza a criação da estrutura do projeto  
✅ Garante padronização e boas práticas  
✅ Otimiza o tempo do desenvolvedor  
✅ Facilita a escalabilidade e manutenção da aplicação

---

# **Resumindo**  🚀

O desenvolvimento de uma aplicação em Angular pode ser dividido, de forma didática, em **duas grandes etapas**:

---

## 📐 **1. Criação Arquitetural com Angular CLI (`≈ 70% do trabalho`)**

A maior parte da estrutura inicial do projeto é gerada automaticamente pela **Angular CLI**, o que torna o processo **ágil, padronizado e profissional.**  

Principais ações automatizadas:

- **Criação do projeto** (`ng new`)
- **Geração de componentes reutilizáveis** (`ng generate component components/nome`)
- **Criação de páginas principais** (`ng generate component pages/nome`)
- **Organização da estrutura de pastas**
- **Configurações iniciais de build e ambiente**
- **Arquivos de mock de dados para testes** (ex: `dataFake.ts`)
- **Testes automatizados** com arquivos `.spec.ts` gerados automaticamente

Essa etapa economiza tempo e garante uma **base sólida para desenvolvimento**, além de ser altamente escalável.

---

## 🧠 **2. Desenvolvimento de Lógica e Estilo (`≈ 30% do trabalho`)**

Após a estruturação básica, o programador desenvolve:

- **Configuração das rotas** (`app-routing.module.ts`)  
  Conecta os componentes e páginas dentro da navegação da aplicação.

- **Lógica de negócio**  
  Criação de serviços, interfaces, requisições HTTP, manipulação de dados e regras específicas.

- **Estilização**  
  Com CSS, SCSS ou frameworks como Bootstrap e Angular Material, aplicando o layout e visual de acordo com o projeto.

- **Build final da aplicação**  
  Com o comando:

  ```bash
  ng build
  ```

### ✅ Conclusão
Podemos considerar, de forma aproximada, uma divisão de **70% para a criação arquitetural com CLI e 30% para o desenvolvimento personalizado da lógica e aparência da aplicação.**

Essa metodologia proporciona agilidade, organização e clareza no desenvolvimento moderno com Angular.

---

📘 *Essa introdução foi desenvolvida como parte do meu processo de aprendizagem em Engenharia de Software e estudos em Angular 14.*

Desenvolvido por: **Constante Binoya Vallangca Segundo**  
GitHub: [@ConstanteBinoya](https://github.com/ConstanteBinoya)  
LinkedIn: [Constante Binoya](https://www.linkedin.com/in/constante-binoya-26474b25a/)  

