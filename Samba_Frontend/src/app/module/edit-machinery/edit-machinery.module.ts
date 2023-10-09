import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EditMachineryRoutingModule } from './edit-machinery-routing.module';
import { EditMachineryPageComponent } from './edit-machinery-page/edit-machinery-page.component';
import { SectionOneComponent } from './edit-machinery-page/components/section-one/section-one.component';
import { ComponentModule } from 'src/app/component/component.module';
import { SectionTwoComponent } from './edit-machinery-page/components/section-two/section-two.component';


@NgModule({
  declarations: [
    EditMachineryPageComponent,
    SectionOneComponent,
    SectionTwoComponent
  ],
  imports: [
    CommonModule,
    EditMachineryRoutingModule,
    ComponentModule
  ]
})
export class EditMachineryModule { }
