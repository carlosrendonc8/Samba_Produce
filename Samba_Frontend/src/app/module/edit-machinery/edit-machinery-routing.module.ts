import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EditMachineryPageComponent } from './edit-machinery-page/edit-machinery-page.component';

const routes: Routes = [
  { path: '', component: EditMachineryPageComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EditMachineryRoutingModule { }
