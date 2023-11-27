import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { MachineModel } from 'src/app/commons/domains/machine/MachineModel';
import { MACHINE_BASE_URL, MACHINE_UPDATE } from 'src/app/commons/endpoint/machine/Machine';
import { GenericResponseDTO } from 'src/app/commons/response/GenericResponseDTO';

@Injectable({
  providedIn: 'root'
})
export class UpdateMachineServiceService {
  constructor(private http:HttpClient) {}

  updateMachine(machine: MachineModel) : Observable<GenericResponseDTO>{
    return this.http.put<GenericResponseDTO>(MACHINE_BASE_URL + MACHINE_UPDATE, machine);
  }
}
