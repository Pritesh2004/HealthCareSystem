import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/service/login.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit{
  isLoggedIn = false; // Check authentication status
  isNormalUser = false; // Check user type
  isAdmin = false; // Check user type
  isDoctor = false;
  user = null;
  userRole = "";

  menuVariable:boolean=false;

  openMenu(){
    this.menuVariable =! this.menuVariable;
  }

  constructor(private loginService : LoginService, private router : Router) {
  }

  ngOnInit(): void {
    this.isAdmin=false;
    this.isDoctor=false;
    this.isNormalUser=false;
    this.isLoggedIn = this.loginService.isLoggenIn();
      this.user = this.loginService.getUser();
      this.userRole = this.loginService.getUserRole();

      if(this.userRole ==  "NORMAL"){
        this.isNormalUser = true;
      }
      else if(this.userRole == "ADMIN"){
        this.isAdmin = true;
      }
      else if(this.userRole=="DOCTOR"){
        this.isDoctor = true;
      }
  
    this.loginService.loginStatusSubject.asObservable().subscribe(data => {
      this.isLoggedIn = this.loginService.isLoggenIn();
      this.user = this.loginService.getUser();
      this.userRole = this.loginService.getUserRole();

      if(this.userRole ==  "NORMAL"){
        this.isNormalUser = true;
      }
      else if(this.userRole == "ADMIN"){
        this.isAdmin = true;
      }
      else if(this.userRole=="DOCTOR"){
        this.isDoctor = true;
      }
  
     
    });
  }

  logout(): void {
    this.isNormalUser = false; // Check user type
    this.isAdmin = false; // Check user type
    this.isDoctor = false;
    this.loginService.logout();
    this.loginService.loginStatusSubject.next(false);
    
    this.router.navigate(['/login']) 


}
  
}
