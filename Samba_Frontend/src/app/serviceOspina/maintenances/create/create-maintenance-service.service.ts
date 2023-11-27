import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { MaintenanceModel } from 'src/app/commons/domains/maintenance/MaintenanceModel';
import { MAINTENANCE_BASE_URL, MAINTENANCE_CREATE } from 'src/app/commons/endpoint/maintenance/Maintenance';
import { GenericResponseDTO } from 'src/app/commons/response/GenericResponseDTO';

@Injectable({
  providedIn: 'root'
})
export class CreateMaintenanceServiceService {

  constructor(private http:HttpClient) {}

  createMaintenance(maintenance:MaintenanceModel) : Observable<GenericResponseDTO>{
    return this.http.post<GenericResponseDTO>(MAINTENANCE_BASE_URL + MAINTENANCE_CREATE, maintenance);
  }
}