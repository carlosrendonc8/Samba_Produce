import { Component, OnInit } from '@angular/core';
import { TypeMachineryModel } from 'src/app/commons/domains/typeMachinery/TypeMachineryModel';
import rutasImagenes from 'src/app/shared/rutasImagenes';
import { ReadTypeMachinaryIdService } from '../../service/read-type-machinary-id.service';
import { ConectorComponentService } from 'src/app/module/list/list-machinery-page/components/service/conector-component.service';

@Component({
  selector: 'app-section-one',
  templateUrl: './section-one.component.html',
  styleUrls: ['./section-one.component.scss']
})
export class SectionOneComponent implements OnInit{
  imageN1 = rutasImagenes.IMAGE_N1;
  imageLogo = rutasImagenes.IMAGE_LOGO;

  typeMachine:TypeMachineryModel [] = [];
  
  constructor( private readTypeMachinaryIdService: ReadTypeMachinaryIdService, private conectorComponentService: ConectorComponentService ){
 
    
  }
  ngOnInit(): void {
    this.getTypeMachinery();
  }

  getTypeMachinery( ){
    this.readTypeMachinaryIdService.readTypeIdMachinary().subscribe(
      (res) => {
        for(let typeMachinery of res.objectResponse){
          this.typeMachine.push(typeMachinery)
        }
      }
    )
  }
  prueba(index:number){
    console.log("hemos entrado al metodo: id del vehiculo: "+ (index + 1))

    this.conectorComponentService.compartirDatos(index);

  }

}