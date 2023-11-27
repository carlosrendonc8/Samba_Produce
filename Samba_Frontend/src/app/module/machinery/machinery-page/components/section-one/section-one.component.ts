import { Component, OnInit } from '@angular/core';
import { TypeMachineryModel } from 'src/app/commons/domains/typeMachinery/TypeMachineryModel';
import rutasImagenes from 'src/app/shared/rutasImagenes';
import { ReadTypeMachinaryService } from '../../service/read-type-machinary.service';
import { ConectorComponentService } from 'src/app/module/list/list-machinery-page/components/service/conector-component.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-section-one',
  templateUrl: './section-one.component.html',
  styleUrls: ['./section-one.component.scss']
})
export class SectionOneComponent implements OnInit{
  typeMachine:TypeMachineryModel [] = [];
  imageN1 = rutasImagenes.IMAGE_N1;
  imageLogo = rutasImagenes.IMAGE_LOGO;
  
  constructor(  private readTypeMachinaryService: ReadTypeMachinaryService, 
                private conectorComponentService: ConectorComponentService )
                {}
  ngOnInit(): void {
    this.getTypeMachinery();
    Swal.fire({
      title: 'Recuerda tus manetenimientos diarios',
      html:
        '<ul>' +
        '<li>Cambio de aceite motor</li>' +
        '<li>Cambio filtro de aceite</li>' +
        '<li>Cambio del filtro de combustible </li>' +
        '<li>Cambio de aceite hidráulico </li>' +
        '<li>Cambio de aceite del diferencial</li>' +
        '<li>Cambio de aceite engranaje planetario</li>' +
        '<li>Lubricacion del balancins</li>' +
        '<li>Lubricacion de chanelas</li>' +
        '<li>Lubricacion de crucetas </li>' +
        '</ul>',
      showCancelButton: false,
      showCloseButton: true,
      confirmButtonText: 'Aceptar'
    });
  }

  getTypeMachinery( ){
    this.readTypeMachinaryService.readTypeMachinary().subscribe(
      (res) => {
        for(let typeMachinery of res.objectResponse){
          this.typeMachine.push(typeMachinery)
        }
      }
    )
  }
}