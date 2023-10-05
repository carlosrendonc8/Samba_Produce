import { Component, OnInit } from '@angular/core';
import { ConectorComponentService } from '../service/conector-component.service';
import { ReadListMachineryService } from '../service/read-list-machinery.service';
import { GenericResponseDTO } from 'src/app/commons/response/GenericResponseDTO';
import { ListMachineryModel } from 'src/app/commons/domains/listMachinery/ListMachineryModel';
import { IAdapterMachine } from 'src/app/commons/domains/listMachinery/IAdapterMachine';

@Component({
  selector: 'app-section-one',
  templateUrl: './section-one.component.html',
  styleUrls: ['./section-one.component.scss']
})
export class SectionOneComponent implements OnInit {

  datosCompartidos!: number;

  listMachinery!: ListMachineryModel[];
  adapter: IAdapterMachine[] = [];

  constructor(private conectorComponentService: ConectorComponentService, private readListMachineryService: ReadListMachineryService) {
    this.conectorComponentService.sharedData$.subscribe(datos => {
      this.datosCompartidos = datos;
    });
  }

  ngOnInit(): void {
    console.log("datos entre Padres: " + this.datosCompartidos);
    this.readListMachineryService.readListMachinery(this.datosCompartidos).subscribe(
      (res: GenericResponseDTO) => {
        for (let item of res.objectResponse) {
          console.log("Prueba" + item.brandMachine)
          this.adapter.push(item)
        }
      }
    )
  }
}
