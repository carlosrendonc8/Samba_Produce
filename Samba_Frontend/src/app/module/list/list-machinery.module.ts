import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ListMachineryRoutingModule } from './list-machinery-routing.module';
import { ListMachineryPageComponent } from './list-machinery-page/list-machinery-page.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { SectionOneComponent } from './list-machinery-page/components/section-one/section-one.component';
import { ComponentModule } from 'src/app/component/component.module';
import { ReadListMachineryService } from './list-machinery-page/components/service/read-list-machinery.service';

@NgModule({
  declarations: [
    ListMachineryPageComponent,
    SectionOneComponent
  ],
  
  imports: [
    CommonModule,
    ListMachineryRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    ComponentModule
  ],
  providers: [
    ReadListMachineryService
  ]

})
export class ListMachineryModule { }
