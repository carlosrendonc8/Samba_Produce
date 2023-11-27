import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { MACHINE_BASE_URL, MACHINE_READ_ALL } from 'src/app/commons/endpoint/machine/Machine';
import { GenericResponseDTO } from 'src/app/commons/response/GenericResponseDTO';

@Injectable({
  providedIn: 'root'
})
export class ReadAllMachineServiceService {
  constructor(private http:HttpClient) {}

  readAllMachine() : Observable<GenericResponseDTO>{
    return this.http.get<GenericResponseDTO>(MACHINE_BASE_URL + MACHINE_READ_ALL);
  }
}