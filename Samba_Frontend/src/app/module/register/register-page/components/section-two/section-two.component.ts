import { Component } from '@angular/core';
import rutasImagenes from 'src/app/shared/rutasImagenes';

@Component({
  selector: 'app-section-two',
  templateUrl: './section-two.component.html',
  styleUrls: ['./section-two.component.scss']
})
export class SectionTwoComponent {
  imageRegister = rutasImagenes.IMAGE_REGISTER;
}
