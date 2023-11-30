import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { TYPE_MACHINERY_BASE_URL, TYPE_MACHINERY_READL_ALL_MACHINES_ENABLE_FOR_TYPE_MACHINERY } from 'src/app/commons/endpoint/typeMachinery/TypeMachineryEndPoint';
import { GenericResponseDTO } from 'src/app/commons/response/GenericResponseDTO';

@Injectable({
  providedIn: 'root'
})
export class BringAllMachinesEnableForTypeMachineTypeMachineServiceService {
  constructor(private http:HttpClient) { }

  bringAllMachinesEnableForTypeMachinery(typeMachineryId:number) : Observable<GenericResponseDTO>{
    return this.http.get<GenericResponseDTO>(TYPE_MACHINERY_BASE_URL + TYPE_MACHINERY_READL_ALL_MACHINES_ENABLE_FOR_TYPE_MACHINERY + typeMachineryId);
  }
}