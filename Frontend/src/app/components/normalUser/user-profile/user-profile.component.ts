import { Component, OnInit } from '@angular/core';
import { first } from 'rxjs';
import { NormalUserService } from 'src/app/service/normal-user.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit{

  update : boolean = false;


  user :any;
  userEmail:any;

  userDto ={
    email: '',
    password: '',
    firstName: '',
    lastName : '',
    phoneNumber: '',
    gender: '',
    dateOfBirth: '',
    address: ''
  };
  

  constructor(private normalUserService : NormalUserService){}


  ngOnInit(): void {
    let userStr: any = localStorage.getItem('user');
    if (userStr) {
      let user = JSON.parse(userStr);
      this.userEmail = user.email;
    } else {
      console.error('User data not found in localStorage.');
    }
    this.getUserDetails();
  }

  routeToFormAndProfile(){
    this.update = !this.update;
  }

  updateProfile(){
    let userStr: any = localStorage.getItem('user');
    if (userStr) {
      let user = JSON.parse(userStr);
      this.userDto.email = user.email;
      this.userDto.password = user.password;
      console.log(this.userDto)
    } else {
      console.error('User data not found in localStorage.');
    }
    this.normalUserService.updateUser(this.userDto.email, this.userDto)
    .subscribe(
      updatedUser => {
        console.log('User updated:', updatedUser);
        // Handle success, e.g., show a success message
      },
      error => {
        console.error('Error updating user:', error);
        // Handle error, e.g., show an error message
      }
    );
  }

  getUserDetails(): void {
    this.normalUserService.getUser(this.userEmail).subscribe(
      (data) => {
        this.user = data;
      },
      (error) => {
        console.error('Error fetching user details:', error);
        // Handle error as per your application's requirements
      }
    );
  }
}
