import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { REGISTER_ACTIVITY_BASE_URL, REGISTER_ACTIVITY_READ_ALL } from 'src/app/commons/endpoint/registerActivity/RegisterActivity';
import { GenericResponseDTO } from 'src/app/commons/response/GenericResponseDTO';

@Injectable({
  providedIn: 'root'
})
export class ReadAllRegisterActivityServiceService {
  constructor(private http:HttpClient) {}

  readAllRegisterActivity() : Observable<GenericResponseDTO>{
    return this.http.get<GenericResponseDTO>(REGISTER_ACTIVITY_BASE_URL + REGISTER_ACTIVITY_READ_ALL);
  }
}