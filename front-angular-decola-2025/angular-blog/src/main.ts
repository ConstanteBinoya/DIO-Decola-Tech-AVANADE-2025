// Este é o ponto de entrada da aplicação Angular:
// Ele inicializa o Angular, decide se está em modo de produção e carrega o AppModule.
// Criado automaticamente após o 'ng new'

import { enableProdMode } from '@angular/core';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

import { AppModule } from './app/app.module';
import { environment } from './environments/environment';

if (environment.production) {
  enableProdMode();
}

platformBrowserDynamic().bootstrapModule(AppModule)
  .catch(err => console.error(err));
