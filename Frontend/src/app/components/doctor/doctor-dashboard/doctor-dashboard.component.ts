import { Component } from '@angular/core';
import { LoginService } from 'src/app/service/login.service';

@Component({
  selector: 'app-doctor-dashboard',
  templateUrl: './doctor-dashboard.component.html',
  styleUrls: ['./doctor-dashboard.component.css']
})
export class DoctorDashboardComponent {

  user :any;

  constructor(private loginService : LoginService) {
  }


  ngOnInit(): void {
   
      this.user = this.loginService.getUser();
  }
}
