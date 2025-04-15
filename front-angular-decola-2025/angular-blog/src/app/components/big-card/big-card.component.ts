// Component: Decorador que transforma a classe em componente Angular.
// Input: Permite receber valores externos de outro componente pai (como o HomeComponent).
// OnInit: Interface usada para executar código no momento da inicialização do componente.
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-big-card',                   // selector: Nome da tag que representa esse componente no HTML (<app-big-card>).
  templateUrl: './big-card.component.html',   // templateUrl: Caminho para o arquivo de estrutura HTML.
  styleUrls: ['./big-card.component.css']     // styleUrls: Caminho para o CSS do componente.
})

// Define a classe do componente, que conterá os dados e lógica.
// implements OnInit: indica que vamos usar o método ngOnInit() logo abaixo.
export class BigCardComponent implements OnInit {

  // O @Input() permite receber esse valor do componente pai.
  @Input()
  photoCover:string = ""         // Esta variável será usada no HTML para definir o endereço da imagem.
  @Input()
  cardTitle:string = ""          // Usado no HTML como título do card. 
  @Input()
  cardDescription:string = ""    // Descrição que aparece abaixo do título.
  @Input()
  Id:string="0"                  // Este id será usado como parte da rota, para abrir a página /content/:id.

  // Construtor vazio — não precisa de dependências externas neste caso.
  constructor() { }

  // Método que o Angular chama automaticamente quando o componente é iniciado.
  //Aqui está vazio, pois não há lógica extra no momento da inicialização.
  ngOnInit(): void {
  }

}
