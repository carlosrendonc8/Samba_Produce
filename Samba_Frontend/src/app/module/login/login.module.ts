import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LoginRoutingModule } from './login-routing.module';
import { LoginPageComponent } from './login-page/login-page.component';
import { SectionOneComponent } from './login-page/components/section-one/section-one.component';
import { SectionTwoComponent } from './login-page/components/section-two/section-two.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { UserServiceService } from './login-page/service/user-service.service';


@NgModule({
  declarations: [
    LoginPageComponent,
    SectionOneComponent,
    SectionTwoComponent
  ],
  
  imports: [
    CommonModule,
    LoginRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [
    UserServiceService
  ],
})
export class LoginModule { }
