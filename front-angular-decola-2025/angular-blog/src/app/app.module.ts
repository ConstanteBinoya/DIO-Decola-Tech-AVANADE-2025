// A classe AppModule funciona como o "container" da aplicação, e o Angular CLI sempre espera encontrar 
// essa classe para dar o bootstrap da aplicação (iniciá-la).

// Cada import aqui traz um componente que você criou usando Angular CLI.
// Eles precisam ser declarados no módulo para que o Angular reconheça e permita seu uso.
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MenuBarComponent } from './components/menu-bar/menu-bar.component';
import { MenuTitleComponent } from './components/menu-title/menu-title.component';
import { BigCardComponent } from './components/big-card/big-card.component';
import { SmallCardComponent } from './components/small-card/small-card.component';
import { HomeComponent } from './pages/home/home.component';
import { ContentComponent } from './pages/content/content.component';

// Decorador @NgModule:
@NgModule({
  declarations: [         // declarations: [...] -> Lista todos os componentes, diretivas e pipes criados nesta aplicação.
    AppComponent,         // É obrigatório declarar aqui todos os componentes que você quer usar no HTML da sua aplicação.
    MenuBarComponent,
    MenuTitleComponent,
    BigCardComponent,
    SmallCardComponent,
    HomeComponent,
    ContentComponent
  ],

  imports: [              // imports: [...] -> Aqui você informa quais módulos externos o Angular deve conhecer:
    BrowserModule,        // BrowserModule -> Necessário para a aplicação funcionar no navegador.
    AppRoutingModule      // AppRoutingModule -> Importa o sistema de rotas que você criou (conecta URL com componentes).
  ],

  providers: [],                // providers: [] -> Lista de serviços (services) que serão disponíveis globalmente no app.

  bootstrap: [AppComponent]     // bootstrap: [AppComponent] -> Define qual é o componente principal que inicia a aplicação.
})                              // Neste caso, é o AppComponent, que normalmente contém:
                                     // <app-header></app-header>
                                     //<router-outlet></router-outlet>
                                     //<app-footer></app-footer>
export class AppModule { }
