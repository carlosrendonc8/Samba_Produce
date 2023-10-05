import { Component } from '@angular/core';
import rutasImagenes from 'src/app/shared/rutasImagenes';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { UserModel } from 'src/app/commons/domains/user/UserModel';
import { UserCreateService } from '../../service/user-create.service';

@Component({
  selector: 'app-section-one',
  templateUrl: './section-one.component.html',
  styleUrls: ['./section-one.component.scss']
})
export class SectionOneComponent {
  imageLogo = rutasImagenes.IMAGE_LOGO;
  users:FormGroup;
  userModel!:UserModel;

  constructor(private userCreate: UserCreateService, private formUser: FormBuilder){
    this.users = this.formUser.group({
      userName: ['', [Validators.required]],
      userLastName:['', [Validators.required]],
      userEmail: ['', [Validators.required, Validators.email]],
      userPassword: ['', [Validators.required]],
      userPhoneNumber: ['', [Validators.required]],
      userIdentification: ['', [Validators.required]]
    })
  }

  createUser(){
    this.userModel = {
      userId:0, 
      userName:this.users.get("userName")?.value,
      userLastName: this.users.get("userLastName")?.value,
      userEmail:this.users.get("userEmail")?.value,
      userPassword: this.users.get("userPassword")?.value,
      userPhoneNumber: this.users.get("userPhoneNumber")?.value,
      userIdentification:this.users.get("userIdentification")?.value
    }

    this.userCreate.userCreate(this.userModel).subscribe(
      (response) => console.log(response)
    );
  }
}
