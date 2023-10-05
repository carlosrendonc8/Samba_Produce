import { Component } from '@angular/core';
import rutasImagenes from 'src/app/shared/rutasImagenes';

@Component({
  selector: 'app-section-one',
  templateUrl: './section-one.component.html',
  styleUrls: ['./section-one.component.scss']
})
export class SectionOneComponent {
  imageMain = rutasImagenes.IMAGE_MAIN;

}