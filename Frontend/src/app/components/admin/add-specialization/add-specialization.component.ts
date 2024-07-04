import { Component } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { AdminService } from 'src/app/service/admin.service';

@Component({
  selector: 'app-add-specialization',
  templateUrl: './add-specialization.component.html',
  styleUrls: ['./add-specialization.component.css']
})
export class AddSpecializationComponent {


  specializationName: string;

  constructor(private adminService: AdminService, private snack : MatSnackBar) {
    this.specializationName = '';
  }

  addSpec() {
    const specialization = { specializationName: this.specializationName };
    this.adminService.addSpecialization(specialization)
      .subscribe(
        response => {
          const snackBarRef = this.snack.open("Specialization Added..", 'ok', {
            verticalPosition: 'top'
          });
        
          snackBarRef.onAction().subscribe(() => {
            window.location.reload();
          });
          console.log('New Specialization Added:', response);
          // Handle success, e.g., show success message
        },
        error => {
          console.error('Error adding specialization:', error);
          const snackBarRef = this.snack.open("Error Adding..", 'ok', {
            verticalPosition: 'top'
          });
        
          snackBarRef.onAction().subscribe(() => {
            window.location.reload();
          });
          // Handle error, e.g., show error message
        }
      );
  }
}
