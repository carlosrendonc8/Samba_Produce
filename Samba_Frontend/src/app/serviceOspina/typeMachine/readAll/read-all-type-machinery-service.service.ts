import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { TYPE_MACHINERY_BASE_URL, TYPE_MACHINERY_READ_ALL } from 'src/app/commons/endpoint/typeMachinery/TypeMachineryEndPoint';
import { GenericResponseDTO } from 'src/app/commons/response/GenericResponseDTO';

@Injectable({
  providedIn: 'root'
})
export class ReadAllTypeMachineryServiceService {
  constructor(private http:HttpClient) {}

  readAllTypeMachinery() : Observable<GenericResponseDTO>{
    return this.http.get<GenericResponseDTO>(TYPE_MACHINERY_BASE_URL + TYPE_MACHINERY_READ_ALL);
  }
}