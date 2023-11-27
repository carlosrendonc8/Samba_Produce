import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { MAINTENANCE_BASE_URL, MAINTENANCE_READ_ALL } from 'src/app/commons/endpoint/maintenance/Maintenance';
import { GenericResponseDTO } from 'src/app/commons/response/GenericResponseDTO';

@Injectable({
  providedIn: 'root'
})
export class ReadAllMaintenanceServiceService {
  constructor(private http:HttpClient) {}

  readAllMaintenance() : Observable<GenericResponseDTO>{
    return this.http.get<GenericResponseDTO>(MAINTENANCE_BASE_URL + MAINTENANCE_READ_ALL);
  }
}
