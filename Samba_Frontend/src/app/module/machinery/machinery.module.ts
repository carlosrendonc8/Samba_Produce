import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MachineryRoutingModule } from './machinery-routing.module';
import { MachineryPageComponent } from './machinery-page/machinery-page.component';
import { SectionOneComponent } from './machinery-page/components/section-one/section-one.component';
import { HttpClientModule } from '@angular/common/http';

import { ComponentModule } from "../../component/component.module";
import { ReadTypeMachinaryService } from './machinery-page/service/read-type-machinary.service';



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
        ReadTypeMachinaryService
    ]
})
export class MachineryModule { }
