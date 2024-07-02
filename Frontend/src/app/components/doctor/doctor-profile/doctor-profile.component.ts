import { Component } from '@angular/core';
import { DoctorService } from 'src/app/service/doctor.service';

@Component({
  selector: 'app-doctor-profile',
  templateUrl: './doctor-profile.component.html',
  styleUrls: ['./doctor-profile.component.css']
})
export class DoctorProfileComponent {

  doctorSpec :any;
  userId:any;
  constructor(private doctorService : DoctorService){}


  ngOnInit(): void {
    let userStr: any = localStorage.getItem('user');
    if (userStr) {
      let user = JSON.parse(userStr);
      this.userId = user.userId;
    } else {
      console.error('User data not found in localStorage.');
    }
    this.getDoctorSpec();
  }
  getDoctorSpec(): void {
    this.doctorService.getDoctorSpecializationByDoctorId(this.userId).subscribe(
      (data) => {
        this.doctorSpec = data;
      },
      (error) => {
        console.error('Error fetching user details:', error);
        // Handle error as per your application's requirements
      }
    );
  }
}
