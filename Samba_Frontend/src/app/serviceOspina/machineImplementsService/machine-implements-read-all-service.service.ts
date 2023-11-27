import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { MACHINE_IMPLEMENTS_BASE_URL, MACHINE_IMPLEMENTS_READ_ALL } from 'src/app/commons/endpoint/machineImplements/MachineImplements';
import { GenericResponseDTO } from 'src/app/commons/response/GenericResponseDTO';

@Injectable({
  providedIn: 'root'
})
export class MachineImplementsReadAllServiceService {
  constructor(private http:HttpClient) {}

  readAllMachineImplements() : Observable<GenericResponseDTO>{
    return this.http.get<GenericResponseDTO>(MACHINE_IMPLEMENTS_BASE_URL + MACHINE_IMPLEMENTS_READ_ALL);
  }
}
