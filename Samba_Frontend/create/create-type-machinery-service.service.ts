import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { TypeMachineryModel } from 'src/app/commons/domains/typeMachinery/TypeMachineryModel';
import { REGISTER_ACTIVITY_BASE_URL, REGISTER_ACTIVITY_CREATE } from 'src/app/commons/endpoint/registerActivity/RegisterActivity';
import { GenericResponseDTO } from 'src/app/commons/response/GenericResponseDTO';

@Injectable({
  providedIn: 'root'
})
export class CreateTypeMachineryServiceService {
  constructor(private http:HttpClient) {}

  createTypeMachinery(typeMachinery:TypeMachineryModel) : Observable<GenericResponseDTO>{
    return this.http.post<GenericResponseDTO>(REGISTER_ACTIVITY_BASE_URL + REGISTER_ACTIVITY_CREATE, typeMachinery);
  }
}