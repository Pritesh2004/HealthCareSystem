import { Component } from '@angular/core';
import { AdminService } from 'src/app/service/admin.service';

@Component({
  selector: 'app-add-specialization',
  templateUrl: './add-specialization.component.html',
  styleUrls: ['./add-specialization.component.css']
})
export class AddSpecializationComponent {


  specializationName: string;

  constructor(private adminService: AdminService) {
    this.specializationName = '';
  }

  addSpec() {
    const specialization = { specializationName: this.specializationName };
    this.adminService.addSpecialization(specialization)
      .subscribe(
        response => {
          alert("Specialization added...")
          console.log('New Specialization Added:', response);
          // Handle success, e.g., show success message
        },
        error => {
          console.error('Error adding specialization:', error);
          // Handle error, e.g., show error message
        }
      );
  }
}
