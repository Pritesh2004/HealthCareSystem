import { Component } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/service/login.service';
import { NgxUiLoaderService } from "ngx-ui-loader"; // Import NgxUiLoaderService

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  userRequest = {
    email: '',
    password: ''
  };


  constructor(private loginService: LoginService, private router:Router, private snack: MatSnackBar, private ngxService: NgxUiLoaderService){}

  loginUser(){
    this.ngxService.start();
    this.loginService.generateToken(this.userRequest).subscribe(

      (response :any)=>{
        this.ngxService.stop();
        console.log("Token generated successfully");
        console.log("Token", response);

        this.loginService.userLogin(response.token);

        this.loginService.getLoggedInUser().subscribe(
          userData=>{
            console.log("User ->",userData);
            this.loginService.setUser(userData);

            if(this.loginService.getUserRole() == "ADMIN"){
              console.log("Admin user")
              this.router.navigate(['/adminDashboard']);
              this.loginService.loginStatusSubject.next(true);
            }
            else if(this.loginService.getUserRole() == "DOCTOR"){
              console.log("Doctor user")

              this.router.navigate(['/doctorDashboard']);
              this.loginService.loginStatusSubject.next(true);
            }
            else if(this.loginService.getUserRole() == "NORMAL"){
              console.log("Normal user")
              this.router.navigate(['/userDashboard']);
              this.loginService.loginStatusSubject.next(true);
            }
            else{
              this.loginService.logout();
            }
          }

        );
      },
      error =>{
        console.log("Error while generating token", error);
        this.snack.open("Invalid Credentials",'ok',{
          verticalPosition:'top'
        });      }

    );
   
  }
}