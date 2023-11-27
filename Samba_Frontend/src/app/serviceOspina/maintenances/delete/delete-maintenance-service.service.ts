import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { MAINTENANCE_BASE_URL, MAINTENANCE_DELETE } from 'src/app/commons/endpoint/maintenance/Maintenance';
import { GenericResponseDTO } from 'src/app/commons/response/GenericResponseDTO';

@Injectable({
  providedIn: 'root'
})
export class DeleteMaintenanceServiceService {
  constructor(private http:HttpClient) {}

  DeleteMaintenanceServiceService(maintenanceId:number) : Observable<GenericResponseDTO>{
    return this.http.delete<GenericResponseDTO>(MAINTENANCE_BASE_URL + MAINTENANCE_DELETE + maintenanceId);
  }
}