# 💠 Introdução à Componentização no Angular

## ❓ O que é Componentização?
A componentização é um dos princípios fundamentais do Angular. Trata-se da prática de dividir a interface do usuário em pequenos blocos independentes chamados **componentes**. Cada componente é responsável por uma parte específica da interface e pode ser reutilizado em diversas partes da aplicação.

💡 Pense num lego ou um aparelho teleônico modular - **que se divide em partes e pode ser alterada sua composição ao trocar os módulos/partes** - os componentes são as partes ou módilos de um todo.
Dessa maneira, a componentização é muito interessante quando se tem "partes", segmentos, estruturas que se repetem em sua essência, mas, com a sutil diferença do seu contúdo específico.  

- Ex: Imagine uma página web, que se divide em `menu`, `header`, `big-card` e `small-card`
![](/.ideas/img/componentizacao.png)
essa estrutura se repetirá em todas as páginas do site: **home**, **serviços**, **quem somos**... Com a utilização de componentes é possível estruturar um padrão de blocos e personalizá-los de acordo com a regra de negócios, isso torna o trabalho mais rápido e organizado.  

  ♻️ Ou seja, quando pensar em uma estrutura componentezada, pense em **REUTILIZAÇÃO** inteligente do código.

---

## 🏪 Estrutura de um Componente Angular
Um componente Angular é formado por quatro principais arquivos:

1. **Arquivo TypeScript (`.ts`)**: Contém a lógica do componente (é construido em TypeScript).
2. **Arquivo HTML (`.html`)**: Define a estrutura do layout do componente.
3. **Arquivo CSS/SCSS (`.css` ou `.scss`)**: Define os estilos específicos do componente.
4. **Arquivo de Testes (`.spec.ts`)** *(Opcional)*: Utilizado para testes unitários do componente.

---

## 🚧 Criando um Novo Componente
Para criar um componente no Angular, utilize o comando:

```bash
ng generate component nome-do-componente
# Ou a forma abreviada:
ng g c nome-do-componente
```

Isso irá gerar uma pasta contendo os quatro arquivos mencionados anteriormente.

---

## 🏦 Estrutura de um Componente Exemplo
Exemplo de um componente chamado `menu-bar`:

```
menu-bar/
│── menu-bar.component.ts    # Lógica do componente
│── menu-bar.component.html  # Estrutura HTML
│── menu-bar.component.css   # Estilos do componente
│── menu-bar.component.spec.ts  # Testes do componente (opcional)
```

---

## ⁉️ Como um Componente Funciona?
O Angular trabalha com um sistema de **componentes hierárquicos**, onde componentes podem ser pais e filhos. Cada componente tem um **decorator** chamado `@Component`, que define sua configuração:

```typescript
import { Component } from '@angular/core';

@Component({
  selector: 'app-menu-bar',  // Nome usado na tag HTML
  templateUrl: './menu-bar.component.html',
  styleUrls: ['./menu-bar.component.css']
})
export class MenuBarComponent {
  title = 'Meu Menu';
}
```

📌 Neste exemplo, o componente `menu-bar` poderá ser usado em outro template HTML como:

```html
<app-menu-bar></app-menu-bar>
```

## ↔️ Passando Dados entre Componentes
Para comunicar componentes pais e filhos, usamos **Property Binding** e **Event Binding**:

### 👴 >> 👶 Passando Dados do Pai para o Filho
Usamos o decorator `@Input()`:

👶 **Componente Filho (`small-card.component.ts`)**:
```typescript
import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-small-card',
  templateUrl: './small-card.component.html',
  styleUrls: ['./small-card.component.css']
})
export class SmallCardComponent {
  @Input() title: string = '';
}
```

👴 **Uso no Componente Pai (`home.component.html`)**:
```html
<app-small-card [title]="'Meu Card'" ></app-small-card>
```

### 👶 >> 👴 Enviando Eventos do Filho para o Pai
Usamos o decorator `@Output()`:

**Componente Filho (`menu-bar.component.ts`)**:
```typescript
import { Component, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-menu-bar',
  templateUrl: './menu-bar.component.html',
  styleUrls: ['./menu-bar.component.css']
})
export class MenuBarComponent {
  @Output() menuClicked = new EventEmitter<string>();

  onClick() {
    this.menuClicked.emit('Menu foi clicado!');
  }
}
```

**Uso no Componente Pai (`app.component.html`)**:
```html
<app-menu-bar (menuClicked)="onMenuClick($event)"></app-menu-bar>
```

**Componente Pai (`app.component.ts`)**:
```typescript
export class AppComponent {
  onMenuClick(event: string) {
    console.log(event);
  }
}
```

## Benefícios da Componentização
✔ **Reutilização de Código** – Facilita a manutenção e reaproveitamento.  
✔ **Facilidade de Testes** – Componentes menores são mais fáceis de testar.  
✔ **Organização** – Divide a aplicação em pequenas partes modulares.  
✔ **Performance** – Carregamento dinâmico e eficiente de componentes.

