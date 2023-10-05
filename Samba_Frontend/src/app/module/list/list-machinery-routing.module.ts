import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListMachineryPageComponent } from './list-machinery-page/list-machinery-page.component'; 

const routes: Routes = [
  {path: '', component:ListMachineryPageComponent },

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ListMachineryRoutingModule { }
