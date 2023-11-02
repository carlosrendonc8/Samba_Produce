import { Component, OnInit } from '@angular/core';
import rutasImagenes from 'src/app/shared/rutasImagenes';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { UserModel } from 'src/app/commons/domains/user/UserModel';
import { UserCreateService } from '../../service/user-create.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-section-one',
  templateUrl: './section-one.component.html',
  styleUrls: ['./section-one.component.scss']
})
export class SectionOneComponent implements OnInit{
  imageLogo = rutasImagenes.IMAGE_LOGO;
  users:FormGroup;
  userModel!:UserModel;

  constructor(private userCreate: UserCreateService, private formUser: FormBuilder, private router: Router){
    this.users = this.formUser.group({
      userName: ['', [Validators.required]],
      userLastName:['', [Validators.required]],
      userEmail: ['', [Validators.required, Validators.email]],
      userPassword: ['', [Validators.required]],
      userPhoneNumber: ['', [Validators.required]],
      userIdentification: ['', [Validators.required]]
    })
  }
  ngOnInit(): void {
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
      (response) => {
        console.log(response);
        Swal.fire(
          '',
          'Usuario creado con exito',
          'success',
        )
        this.router.navigateByUrl( '/samba-login-page')
      }
    );
  }
}
