import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RegisterActivityRoutingModule } from './register-activity-routing.module';
import { RegisterActivityPageComponent } from './register-activity-page/register-activity-page.component';
import { SectionOneComponent } from './register-activity-page/components/section-one/section-one.component';
import { ComponentModule } from "../../component/component.module";

@NgModule({
    declarations: [
        RegisterActivityPageComponent,
        SectionOneComponent
    ],
    imports: [
        CommonModule,
        RegisterActivityRoutingModule,
        ComponentModule
    ]
})
export class RegisterActivityModule { }

