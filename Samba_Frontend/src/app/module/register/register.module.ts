import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RegisterRoutingModule } from './register-routing.module';
import { RegisterPageComponent } from './register-page/register-page.component';
import { SectionOneComponent } from './register-page/components/section-one/section-one.component';
import { SectionTwoComponent } from './register-page/components/section-two/section-two.component';
import { FormsModule,ReactiveFormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { UserCreateService } from './register-page/service/user-create.service';


@NgModule({
  declarations: [
    RegisterPageComponent,
    SectionOneComponent,
    SectionTwoComponent,
  ],
  imports: [
    CommonModule,
    RegisterRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [
    UserCreateService
  ],
})
export class RegisterModule { }
