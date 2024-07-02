import { Component } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { AppointmentService } from 'src/app/service/appointment.service';
import { Appointment } from '../../models/appointment.model';

@Component({
  selector: 'app-doctor-appointments',
  templateUrl: './doctor-appointments.component.html',
  styleUrls: ['./doctor-appointments.component.css']
})
export class DoctorAppointmentsComponent {


  appointments: Appointment[] = [];
  doctorId = 0;
  displayedColumns: string[] = ['userName', 'userEmail', 'appointmentDate', 'appointmentTime', 'bookingDate', 'reason', 'status'];
  dataSource = new MatTableDataSource<Appointment>();

  constructor(private appointmentService: AppointmentService) { }

  ngOnInit(): void {
   // To set user_id
   let userStr: any = localStorage.getItem('user');
   if (userStr) {
     let user = JSON.parse(userStr);
     this.doctorId = user.userId;
   } else {
     console.error('User data not found in localStorage.');
   }
   this.getAppointments();
  }

  getAppointments(): void {
    this.appointmentService.getAppointmentsByDoctorId(this.doctorId).subscribe(
      (data: Appointment[]) => {
        this.appointments = data;
        this.dataSource.data = this.appointments;
      },
      (error) => {
        console.error(error);
      }
    );
  }

  updateStatus(appointmentId:any, status: any): void {
    this.appointmentService.updateStatus(appointmentId, status).subscribe(
      (data) => {
        console.log('Appointment Status update:', data);
        
        window.location.reload();
        alert("Status updated")
        // Perform any additional actions upon success
      },
      (error) => {
        console.error('Error updating appointment:', error);
        alert("Error updating appointment");
        // Handle error scenarios
      }
    );
  }


  
}
