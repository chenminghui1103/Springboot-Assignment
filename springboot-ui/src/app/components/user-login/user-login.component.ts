import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user.model';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {

    user: User={
      "loginName": '',
      "password": ''
    };

    errorMsg: string = '';

    constructor(
      private userSvc: UserService,
      private router: Router) { }

    ngOnInit() {
    }

    toRegister(){
      this.router.navigate(["/register"]);
    }

    userLogin(): void {
      console.log(this.user);
      if(this.validateInput(this.user)){
        this.userSvc.userLogin(this.user).subscribe(
          res => {
            console.log('login response===',res);
            if(res.valueOf()){
              this.router.navigate(["/update"],{ queryParams: { login_name: this.user.loginName } });
            }else{
              this.errorMsg = 'The username or password is wrong!';
            }   
            
          },
          err => {
            console.log('err===',err);
            this.errorMsg = err.error;
          }
        )
      }
      
    }

    validateInput(user: User): boolean {
      let validateRst = false;
      if(user.loginName.trim() == ''){
        this.errorMsg = "User Name can't empty!";
      }else if(user.password.trim() == ''){
        this.errorMsg = "User Password can't empty!";
      }else {
        validateRst = true;
      }
      
      return validateRst;
    }

    reset(): void {
      this.errorMsg = '';
      this.user = {
        "loginName": '',
        "password": ''
      };
    }

}
