import { Component } from '@angular/core';
import rutasImagenes from 'src/app/shared/rutasImagenes';

@Component({
  selector: 'app-section-two',
  templateUrl: './section-two.component.html',
  styleUrls: ['./section-two.component.scss']
})
export class SectionTwoComponent {
  imagePrincipal = rutasImagenes.IMAGE_PRINCIPAL;
  imageP2 = rutasImagenes.IMAGE_P2;
  imageP3 = rutasImagenes.IMAGE_P3;
}
