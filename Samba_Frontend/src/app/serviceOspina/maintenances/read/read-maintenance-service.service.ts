import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { MAINTENANCE_BASE_URL, MAINTENANCE_READ } from 'src/app/commons/endpoint/maintenance/Maintenance';
import { GenericResponseDTO } from 'src/app/commons/response/GenericResponseDTO';

@Injectable({
  providedIn: 'root'
})
export class ReadMaintenanceServiceService {
  constructor(private http:HttpClient) {}

  readMaintenance(maintenanceId:number) : Observable<GenericResponseDTO>{
    return this.http.get<GenericResponseDTO>(MAINTENANCE_BASE_URL + MAINTENANCE_READ + maintenanceId);
  }
}
