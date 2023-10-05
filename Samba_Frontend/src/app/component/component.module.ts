import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ComponentRoutingModule } from './component-routing.module';
import { SectionNavbarComponent } from './componeteGlobal/section-navbar/section-navbar.component';
import { SectionFooterComponent } from './componeteGlobal/section-footer/section-footer.component';


@NgModule({
  declarations: [
    SectionNavbarComponent,
    SectionFooterComponent
  ],
  imports: [
    CommonModule,
    ComponentRoutingModule
  ],
  exports:[
    SectionNavbarComponent,
    SectionFooterComponent
  ]
})
export class ComponentModule { }
