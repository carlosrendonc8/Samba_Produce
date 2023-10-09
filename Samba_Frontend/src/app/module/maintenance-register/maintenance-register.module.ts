import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MaintenanceRegisterRoutingModule } from './maintenance-register-routing.module';
import { MaintenanceRegisterPageComponent } from './maintenance-register-page/maintenance-register-page.component';
import { SectionOneComponent } from './maintenance-register-page/components/section-one/section-one.component';
import { SectionTwoComponent } from './maintenance-register-page/components/section-two/section-two.component';
import { SectionThreeComponent } from './maintenance-register-page/components/section-three/section-three.component';
import { SectionFourComponent } from './maintenance-register-page/components/section-four/section-four.component';
import { ComponentModule } from 'src/app/component/component.module';
import { FormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    MaintenanceRegisterPageComponent,
    SectionOneComponent,
    SectionTwoComponent,
    SectionThreeComponent,
    SectionFourComponent
  ],
  imports: [
    CommonModule,
    MaintenanceRegisterRoutingModule,
    ComponentModule,
    FormsModule
  ]
})
export class MaintenanceRegisterModule { }
