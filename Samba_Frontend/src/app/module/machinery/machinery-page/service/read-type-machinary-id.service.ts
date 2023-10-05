import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';
import { TYPEMACHINEY_BASE_URL, TYPEMACHINARY_READ } from 'src/app/commons/endpoint/typeMachinary/TypeMachinaryEndPoint';
import { GenericResponseDTO } from 'src/app/commons/response/GenericResponseDTO';

@Injectable({
  providedIn: 'root'
})
export class ReadTypeMachinaryIdService {

  constructor( private http:HttpClient) { }

  readTypeIdMachinary(): Observable<GenericResponseDTO> {
    
    return this.http
    .get<GenericResponseDTO>(TYPEMACHINEY_BASE_URL + TYPEMACHINARY_READ)
    .pipe(
        catchError((error: HttpErrorResponse) => {
            return throwError(error);
    })
    );
  }
}
