import { Component } from '@angular/core';
import { AdminService } from 'src/app/service/admin.service';

@Component({
  selector: 'app-add-doctor',
  templateUrl: './add-doctor.component.html',
  styleUrls: ['./add-doctor.component.css']
})
export class AddDoctorComponent {

  doctor: any = {}; // Define your user data model here

  specializations : any[] = [];

  ngOnInit(): void {
    this.fetchSpecializations();
  }

  constructor(private adminService : AdminService){

  }

  fetchSpecializations() {
    this.adminService.getAllSpecializations()
      .subscribe(
        response => {
          this.specializations = response;
          console.log('Specializations:', this.specializations);
          // Handle success, e.g., update UI
        },
        error => {
          console.error('Error fetching specializations:', error);
          // Handle error, e.g., show error message
        }
      );
  }

  addDoctor(){
    this.adminService.saveDoctor(this.doctor)
    .subscribe(
      response => {
        console.log('Saved Doctor:', response);
        alert("Doctor Saved Successfully")
        // Handle success, e.g., show success message
      },
      error => {
        console.error('Error saving doctor:', error);
        alert("Error saving doctor");
        // Handle error, e.g., show error message
      }
    );
  }
}
