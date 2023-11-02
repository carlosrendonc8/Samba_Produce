import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PrincipalRoutingModule } from './principal-routing.module';
import { PrincipalPageComponent } from './principal-page/principal-page.component';
import { SectionOneComponent } from './principal-page/components/section-one/section-one.component';
import { SectionTwoComponent } from './principal-page/components/section-two/section-two.component';
import { SectionThreeComponent } from './principal-page/components/section-three/section-three.component';
import { SectionFourComponent } from './principal-page/components/section-four/section-four.component';
import { SectionFiveComponent } from './principal-page/components/section-five/section-five.component';
import { ComponentModule } from 'src/app/component/component.module';


@NgModule({
  declarations: [
    PrincipalPageComponent,
    SectionOneComponent,
    SectionTwoComponent,
    SectionThreeComponent,
    SectionFourComponent,
    SectionFiveComponent
  ],
  imports: [
    CommonModule,
    PrincipalRoutingModule,
    ComponentModule
  ]
})
export class PrincipalModule { }
