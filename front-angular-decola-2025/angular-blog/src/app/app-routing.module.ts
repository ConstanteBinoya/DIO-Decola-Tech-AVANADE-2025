// 1) Preparam o ambiente para configurar o sistema de rotas e 
//    Informam quais componentes serão carregados quando o usuário acessar determinadas URLs:

// Importa o decorador @NgModule para transformar a classe abaixo em um módulo Angular
import { NgModule } from '@angular/core';

// Importa as ferramentas de roteamento do Angular
import { RouterModule, Routes } from '@angular/router';

// Importa os componentes que serão associados às rotas, que no caso são os componentes de estrutura repetitiva e a home
import { ContentComponent } from './pages/content/content.component';
import { HomeComponent } from './pages/home/home.component';

// 2) Criação de um array (vetor) de rotas chamado - 'routes'
//    O Angular vai usar para navegar dentro da aplicação:

const routes: Routes = [
  // ROTA 1:
  {
    path: '',                   // URL vazia - é a página inicial, ou seja, quando o usuário acessa.
    component: HomeComponent    // Quando essa rota for acessada, o Angular renderiza o 'HomeComponent'.
  },

  // ROTA 2:
  {
    path: 'content/:id',           // Cria uma rota dinâmica, ou seja, com um parâmetro na URL (:id)
    component: ContentComponent    // Quando essa rota for acessada, o Angular renderiza o 'ContentComponent'.
  }                                // Exemplo: localhost:4200/content/3 -> carrega o 'ContentComponent' e recebe 'id = 3'
];

// 3)Declaração de uma classe em módulo Angular através do @NgModule({...})

@NgModule({
  imports: [RouterModule.forRoot(routes)], // Configura o RouterModule com as rotas definidas.
                                           // forRoot() -> informa que esse é o módulo de rotas principal da aplicação.

  exports: [RouterModule]   // Torna o roteador disponível para outros módulos e componentes.
})
export class AppRoutingModule { }
