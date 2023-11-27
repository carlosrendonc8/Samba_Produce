import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { TYPE_MACHINERY_BASE_URL, TYPE_MACHINERY_DELETE } from 'src/app/commons/endpoint/typeMachinery/TypeMachineryEndPoint';
import { GenericResponseDTO } from 'src/app/commons/response/GenericResponseDTO';

@Injectable({
  providedIn: 'root'
})
export class DeleteTypeMachineryServiceService {
  constructor(private http:HttpClient) {}

  DeleteTypeMachineryServiceService(typeMachineryId:number) : Observable<GenericResponseDTO>{
    return this.http.delete<GenericResponseDTO>(TYPE_MACHINERY_BASE_URL + TYPE_MACHINERY_DELETE + typeMachineryId);
  }
}
