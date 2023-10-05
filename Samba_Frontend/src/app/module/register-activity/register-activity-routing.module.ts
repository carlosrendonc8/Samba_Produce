import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegisterActivityPageComponent } from './register-activity-page/register-activity-page.component';
const routes: Routes = [
    { path: '', component: RegisterActivityPageComponent }
];
@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class RegisterActivityRoutingModule { }

