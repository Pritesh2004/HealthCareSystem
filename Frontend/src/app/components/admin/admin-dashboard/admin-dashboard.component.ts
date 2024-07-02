import { Component } from '@angular/core';
import { LoginService } from 'src/app/service/login.service';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent {

  user :any;

  constructor(private loginService : LoginService) {
  }

  ngOnInit(): void {
   
      this.user = this.loginService.getUser();
  }
}
