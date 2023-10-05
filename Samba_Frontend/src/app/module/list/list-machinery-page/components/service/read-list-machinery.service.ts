import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LIST_MACHINERY_READ_ID, LIST_MACHINEY_BASE_URL } from 'src/app/commons/endpoint/listMachinery/ListMachinery';
import { GenericResponseDTO } from 'src/app/commons/response/GenericResponseDTO';

@Injectable({
  providedIn: 'root'
})
export class ReadListMachineryService {

  constructor(private http: HttpClient) { }

  readListMachinery(index: number): Observable<GenericResponseDTO>{
    console.log("id de la consulta" + (index + 1));
    return this.http.get<GenericResponseDTO>(LIST_MACHINEY_BASE_URL + LIST_MACHINERY_READ_ID + (index + 1));
  }
}
