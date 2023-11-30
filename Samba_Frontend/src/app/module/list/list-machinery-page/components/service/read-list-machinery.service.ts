import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { MACHINE_BASE_URL } from 'src/app/commons/endpoint/machine/Machine';
import { TYPE_MACHINERY_READL_ALL_MACHINES_ENABLE_FOR_TYPE_MACHINERY } from 'src/app/commons/endpoint/typeMachinery/TypeMachineryEndPoint';
import { GenericResponseDTO } from 'src/app/commons/response/GenericResponseDTO';

@Injectable({
  providedIn: 'root'
})
export class ReadListMachineryService {

  constructor(private http: HttpClient) { }

  readListMachinery(index: number): Observable<GenericResponseDTO>{
    console.log("id de la consulta" + (index));
    return this.http.get<GenericResponseDTO>(MACHINE_BASE_URL + TYPE_MACHINERY_READL_ALL_MACHINES_ENABLE_FOR_TYPE_MACHINERY + index);
  }
}