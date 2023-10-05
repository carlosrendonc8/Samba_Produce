import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserModel } from 'src/app/commons/domains/user/UserModel';
import { USER_BASE_URL, USER_CREATE } from 'src/app/commons/endpoint/user/UserEndPoint';
import { GenericResponseDTO } from 'src/app/commons/response/GenericResponseDTO';

@Injectable({
  providedIn: 'root'
})
export class UserCreateService {

  constructor(private http: HttpClient) { }

  userCreate(userModel: UserModel): Observable<GenericResponseDTO> {
    return this.http
    .post<GenericResponseDTO>(USER_BASE_URL + USER_CREATE, userModel);
}
}
