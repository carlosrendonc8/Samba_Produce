import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { REGISTER_ACTIVITY_BASE_URL, REGISTER_ACTIVITY_DELETE } from 'src/app/commons/endpoint/registerActivity/RegisterActivity';
import { GenericResponseDTO } from 'src/app/commons/response/GenericResponseDTO';

@Injectable({
  providedIn: 'root'
})
export class DeleteRegisterActivityServiceService {
  constructor(private http:HttpClient) {}

  DeleteRegisterActivityServiceService(registerActivityId:number) : Observable<GenericResponseDTO>{
    return this.http.delete<GenericResponseDTO>(REGISTER_ACTIVITY_BASE_URL + REGISTER_ACTIVITY_DELETE + registerActivityId);
  }
}