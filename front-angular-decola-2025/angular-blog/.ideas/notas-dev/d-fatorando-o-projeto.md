# 📘 Guia de Criação e Configuração de Rotas no Angular
## ✅ Passos Iniciais do Projeto Angular
### 1️⃣ Crie o projeto base
```bash
ng new meu-projeto
```

### 2️⃣ Crie os primeiros componentes de página (globais)
```bash
ng generate component pages/home
ng generate component pages/content
```

### 3️⃣ Crie os componentes reutilizáveis
```bash
ng generate component components/menu-bar
ng generate component components/menu-title
ng generate component components/big-card
ng generate component components/small-card
```

### 4️⃣ Crie o módulo de rotas **(caso não tenha sido gerado automaticamente)**
```bash
ng generate module app-routing --flat --module=app
```

### 5️⃣ Configure o arquivo app-routing.module.ts com os componentes criados
* 💡 **"O arquivo `app-routing.module.ts` é responsável por mapear as rotas da aplicação. Cada objeto no `array routes` conecta um caminho da URL a um componente. Por exemplo, quando o usuário acessa `/`, ele vê a Home, e quando acessa `/content/:id`, ele vê uma página de conteúdo específica. Essa configuração permite que nossa aplicação funcione como uma SPA (Single Page Application), onde as páginas mudam sem recarregar o navegador."**

```ts
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ContentComponent } from './pages/content/content.component';
import { HomeComponent } from './pages/home/home.component';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'content/:id',
    component: ContentComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
```

### 🧠 Explicação Linha a Linha
* `@NgModule`: Define um módulo Angular.
* `RouterModule.forRoot(routes)`: Registra o sistema de rotas principal da aplicação.
* `exports: [RouterModule]`: Torna as rotas disponíveis em toda a aplicação.

### 🔍 Rotas Criadas
| Caminho              | Componente                                                   | Descrição |
|---------------------|-------------------------------------------------------|----------------------|
| `''`    | `HomeComponent`                | Página inicial da aplicação |
| `content/:id` | `ContentComponent`      | Página de detalhe de conteúdo (dinâmica) |

**Cada rota associa um caminho da URL com um componente, formando o sistema de navegação da aplicação Angular.**

### 🧩 Ponto de renderização
Para que os componentes definidos nas rotas sejam exibidos, o HTML raiz (app.component.html) precisa conter:
```html
<router-outlet></router-outlet>
```
**Esse é o espaço onde o Angular vai injetar dinamicamente o componente da rota ativa.**

### 6️⃣ Criar um arquivo de dados simulados (dataFake.ts)
- **Serve como um "banco de dados fake" enquanto você ainda não tem um backend/API.**

Exemplo: `src/app/data/dataFake.ts`

```ts
export const dataFake = [
  {
    id: '1',
    title: 'Título do post 1',
    description: 'Conteúdo do post 1...',
    photoCover: 'Caminho até a imagem1'
  },
  {
    id: '2',
    title: 'Título do post 2',
    description: 'Conteúdo do post 2...',
    photoCover: 'Caminho até a imagem2'
  }
];
```

### 7️⃣ Exibir esses dados nos componentes
- **Agora você alimenta os componentes com os dados de dataFake.ts.**

Exemplo no `home.component.ts`:
```ts
import { Component } from '@angular/core';
import { dataFake } from '../../data/dataFake';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  data = dataFake;
}
```
Exemplo no `home.component.html`:
```html
<app-small-card
  *ngFor="let item of data"
  [Id]="item.id"
  [photoCover]="item.photoCover"
  [cardTitle]="item.title"
  [cardDescription]="item.description"
></app-small-card>
```

### 8️⃣ Criar lógica de navegação por ID
Exemplo no `content.component.ts`:
```ts
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { dataFake } from '../../data/dataFake';

@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.css']
})
export class ContentComponent implements OnInit {
  post: any;

  constructor(private route: ActivatedRoute) {}

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    this.post = dataFake.find(item => item.id === id);
  }
}
```
**Agora você consegue acessar /content/1 e ver os detalhes do post com ID 1.**

### 9️⃣ Estilizar a aplicação

**Você pode agora:**

- Ajustar os estilos globais em styles.css  
- Estilizar individualmente os componentes  
- Adicionar responsividade, cores, fontes, etc.