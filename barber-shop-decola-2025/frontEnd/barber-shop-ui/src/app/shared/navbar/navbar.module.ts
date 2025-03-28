import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router'; // Necessário para os routerLinks
import { NavbarComponent } from './navbar.component';

@NgModule({
  declarations: [NavbarComponent], // Declaração do componente Navbar
  imports: [CommonModule, RouterModule], // RouterModule adicionado para suportar routerLink
  exports: [NavbarComponent] // Exportando para uso no AppModule
})
export class NavbarModule { }
