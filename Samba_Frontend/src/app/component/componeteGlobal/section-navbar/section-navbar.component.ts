import { Component } from '@angular/core';
import rutasImagenes from 'src/app/shared/rutasImagenes';

@Component({
  selector: 'app-section-navbar',
  templateUrl: './section-navbar.component.html',
  styleUrls: ['./section-navbar.component.scss']
})
export class SectionNavbarComponent {
  imageLogo = rutasImagenes.IMAGE_LOGO;
}
