import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MaintenanceRegisterPageComponent } from './maintenance-register-page/maintenance-register-page.component';

const routes: Routes = [
  {path: '', component: MaintenanceRegisterPageComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MaintenanceRegisterRoutingModule { }
