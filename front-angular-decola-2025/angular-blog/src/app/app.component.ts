// É a lógica e a configuração do componente raiz da aplicação.

import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'angular-blog';
}

// @Component ->	Define que essa classe é um componente Angular

// selector: 'app-root'	-> Este é o nome da tag personalizada usada no index.html para renderizar o app

// templateUrl	-> Aponta para o HTML do componente (estrutura visual)

// styleUrls	-> Aponta para o CSS local deste componente

// export class AppComponent ->	Declara a classe onde você pode colocar lógica adicional

// title = 'angular-blog'	-> Uma variável de exemplo (não está sendo usada, mas pode ser usada no HTML com {{ title }})