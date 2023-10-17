import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import rutasImagenes from 'src/app/shared/rutasImagenes';
import { UserServiceService } from '../../service/user-service.service';

@Component({
  selector: 'app-section-two',
  templateUrl: './section-two.component.html',
  styleUrls: ['./section-two.component.scss']
})
export class SectionTwoComponent {
  imageLogo = rutasImagenes.IMAGE_LOGO;
  users: FormGroup;

  constructor(private userServiceService: UserServiceService, private formUser: FormBuilder, private router: Router){
    this.users = this.formUser.group({
      userEmail: ['', [Validators.required, Validators.email]],
      userPassword: ['', [Validators.required]]
    })
  }

  login(){
    const userEmail = this.users.get("userEmail")?.value;
    const userPassword = this.users.get("userPassword")?.value;
    const params = {userEmail,userPassword }

    this.userServiceService.userService(params).subscribe(
      (response) => {
        console.log("prueba login" + response)
        this.router.navigateByUrl('/samba-machinery-page');
      }
    );
    
  }
}
