import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { MachineModel } from 'src/app/commons/domains/machine/MachineModel';
import { MACHINE_BASE_URL, MACHINE_CREATE } from 'src/app/commons/endpoint/machine/Machine';
import { GenericResponseDTO } from 'src/app/commons/response/GenericResponseDTO';

@Injectable({
  providedIn: 'root'
})
export class CreateMachineServiceService {
  constructor(private http:HttpClient) { }

  createMachine(machine:MachineModel) : Observable<GenericResponseDTO> {
    return this.http.post<GenericResponseDTO>(MACHINE_BASE_URL + MACHINE_CREATE, machine);
  }
}