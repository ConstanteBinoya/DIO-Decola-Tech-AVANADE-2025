// O ContentComponent é o componente responsável por exibir o conteúdo individual de um post ao acessar a rota /content/:id.
// Ele é ativado dinamicamente pelo Angular quando o usuário clica em um card e a rota muda para, por exemplo, /content/2.

// content.component.ts (o cérebro do componente)
import { Component, OnInit } from '@angular/core';   // Component	Define um componente Angular
                                                     // OnInit	Ciclo de vida do Angular que executa código ao inicializar

import { ActivatedRoute } from '@angular/router';    // ActivatedRoute	Acesso aos parâmetros da rota ativa (ex: :id)

import {dataFake} from '../../data/dataFake'         // dataFake	Simula um banco de dados local com os posts


@Component({
  selector: 'app-content',                    // selector	Nome da tag do componente (usado internamente pelo Angular)
  templateUrl: './content.component.html',    // templateUrl	Linka o HTML (visão)
  styleUrls: ['./content.component.css']      // styleUrls	Linka o CSS local do componente
})
export class ContentComponent implements OnInit {
  photoCover:string = ""
  contentTitle:string = ""
  contentDescription:string = ""
  private id:string | null = "0"

  constructor(
    private route:ActivatedRoute
  ) { }

  // Capta rotas via parâmetro :id
  ngOnInit(): void {
    this.route.paramMap.subscribe( value =>
     this.id = value.get("id")
    )

    // Passa o id para o método que vai buscar os dados
    this.setValuesToComponent(this.id)
  }

  // Buscar os dados no "banco simulado"
  // Filtra o dataFake pelo id recebido na rota
  //Salva os dados do post nas variáveis que o HTML irá usar
  setValuesToComponent(id:string | null){
    const result = dataFake.filter(article => article.id == id)[0]

    this.contentTitle = result.title
    this.contentDescription = result.description
    this.photoCover = result.photoCover
  }

}
