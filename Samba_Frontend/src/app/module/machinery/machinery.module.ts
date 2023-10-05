import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MachineryRoutingModule } from './machinery-routing.module';
import { MachineryPageComponent } from './machinery-page/machinery-page.component';
import { SectionOneComponent } from './machinery-page/components/section-one/section-one.component';
import { HttpClientModule } from '@angular/common/http';

import { ComponentModule } from "../../component/component.module";
import { ReadTypeMachinaryIdService } from './machinery-page/service/read-type-machinary-id.service';



@NgModule({
    declarations: [
        MachineryPageComponent,
        SectionOneComponent
    ],
    imports: [
        CommonModule,
        MachineryRoutingModule,
        HttpClientModule,
        CommonModule,
        ComponentModule
    ],
    providers: [
        ReadTypeMachinaryIdService
    ]
})
export class MachineryModule { }
