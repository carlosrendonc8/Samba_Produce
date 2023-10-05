import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ConectorComponentService {
  
  private sharedData = new BehaviorSubject<number>(0);

  sharedData$ = this.sharedData.asObservable();

  compartirDatos(datos: number) {
    this.sharedData.next(datos);
  }
}
