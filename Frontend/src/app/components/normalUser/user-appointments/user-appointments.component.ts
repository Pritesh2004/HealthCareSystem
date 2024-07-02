import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { AppointmentService } from 'src/app/service/appointment.service';
import { Appointment } from '../../models/appointment.model';

@Component({
  selector: 'app-user-appointments',
  templateUrl: './user-appointments.component.html',
  styleUrls: ['./user-appointments.component.css']
})
export class UserAppointmentsComponent implements OnInit {

  appointments: Appointment[] = [];
  userId = 0;
  displayedColumns: string[] = ['doctorName', 'userName', 'appointmentDate', 'appointmentTime', 'bookingDate', 'reason', 'status'];
  dataSource = new MatTableDataSource<Appointment>();

  constructor(private appointmentService: AppointmentService) { }

  ngOnInit(): void {
    // To set user_id
    let userStr: any = localStorage.getItem('user');
    if (userStr) {
      let user = JSON.parse(userStr);
      this.userId = user.userId;
    } else {
      console.error('User data not found in localStorage.');
    }
    this.getAppointments();
  }

  getAppointments(): void {
    this.appointmentService.getAppointmentsByUserId(this.userId).subscribe(
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
        // Perform any additional actions upon success
      },
      (error) => {
        console.error('Error updating appointment:', error);
        // Handle error scenarios
      }
    );
  }
}
