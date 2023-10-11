import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { USER_BASE_URL, USER_SERVICE } from 'src/app/commons/endpoint/user/UserEndPoint';
import { GenericResponseDTO } from 'src/app/commons/response/GenericResponseDTO';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  constructor(private http: HttpClient) { }

  userService(params: { userEmail: string; userPassword: string; }): Observable<GenericResponseDTO> {
    console.log( "entramos")
    return this.http
    .post<GenericResponseDTO>(USER_BASE_URL + USER_SERVICE, params);
  }
}
