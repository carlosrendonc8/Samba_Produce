import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { GenericResponseDTO } from 'src/app/commons/response/GenericResponseDTO';
import { MACHINE_BASE_URL, MACHINE_DELETE } from 'src/app/commons/endpoint/machine/Machine';

@Injectable({
  providedIn: 'root'
})
export class DeleteMachineServiceService {
  constructor(private http:HttpClient) {}

  deleteMachine(machineSambaId:number) : Observable<GenericResponseDTO>{
    return this.http.delete<GenericResponseDTO>(MACHINE_BASE_URL + MACHINE_DELETE + machineSambaId);
  }
}