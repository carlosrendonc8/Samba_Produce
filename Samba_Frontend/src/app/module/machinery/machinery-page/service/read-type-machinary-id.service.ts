import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';
import { TYPEMACHINERY_BASE_URL, TYPEMACHINERY_READ_ALL } from 'src/app/commons/endpoint/typeMachinary/TypeMachinaryEndPoint';
import { GenericResponseDTO } from 'src/app/commons/response/GenericResponseDTO';

@Injectable({
  providedIn: 'root'
})
export class ReadTypeMachinaryIdService {

  constructor( private http:HttpClient) { }

  readTypeIdMachinary(): Observable<GenericResponseDTO> {
    
    return this.http
    .get<GenericResponseDTO>(TYPEMACHINERY_BASE_URL + TYPEMACHINERY_READ_ALL)
    .pipe(
        catchError((error: HttpErrorResponse) => {
            return throwError(error);
    })
    );
  }
}
