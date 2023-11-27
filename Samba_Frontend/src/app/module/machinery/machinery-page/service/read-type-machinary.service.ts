import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';
import { TYPE_MACHINERY_BASE_URL, TYPE_MACHINERY_READ_ALL } from 'src/app/commons/endpoint/typeMachinery/TypeMachineryEndPoint';
import { GenericResponseDTO } from 'src/app/commons/response/GenericResponseDTO';

@Injectable({
  providedIn: 'root'
})
export class ReadTypeMachinaryService {

  constructor( private http:HttpClient) { }

  readTypeMachinary(): Observable<GenericResponseDTO> {
    return this.http.get<GenericResponseDTO>(TYPE_MACHINERY_BASE_URL + TYPE_MACHINERY_READ_ALL);
  }
}
