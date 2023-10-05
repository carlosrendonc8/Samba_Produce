import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MachineryPageComponent } from './machinery-page/machinery-page.component';

const routes: Routes = [
  {path:'', component: MachineryPageComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MachineryRoutingModule { }
