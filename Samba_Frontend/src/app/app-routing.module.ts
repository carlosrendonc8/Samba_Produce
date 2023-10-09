import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', redirectTo: '/samba-login-page', pathMatch: 'full' },
  { path: 'samba-login-page', loadChildren: () =>
      import( './module/login/login.module').then( m => m.LoginModule)},

  { path: 'samba-register-page', loadChildren: () =>
      import( './module/register/register.module').then( m => m.RegisterModule)},

  { path: 'samba-machinery-page', loadChildren: () =>
      import( './module/machinery/machinery.module').then( m => m.MachineryModule)},

  { path: 'samba-list-machinery-page', loadChildren: () =>
      import( './module/list/list-machinery.module').then( m => m.ListMachineryModule)},

  { path: 'samba-register-activity-page', loadChildren: () =>
  import('./module/register-activity/register-activity.module').then( m => m.RegisterActivityModule)},

  { path: 'samba-edit-machinery-page', loadChildren: () =>
    import( './module/edit-machinery/edit-machinery.module').then( m => m.EditMachineryModule)}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

