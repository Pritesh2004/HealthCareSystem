import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root'
})
export class AppointmentService {

  private baseUrl = 'http://localhost:8181/appointment'; // Spring Boot URL


  constructor(private http: HttpClient, private loginService : LoginService) { }

  bookAppointment(appointment: any): Observable<any> {
    const url = `${this.baseUrl}/`;
    const headers = new HttpHeaders().set('Authorization', 'Bearer ' + this.loginService.getToken());
    return this.http.post<any>(url, appointment, {headers});
    
  }

  getAppointmentsByUserId(user_id:any): Observable<any> {
    const url = `${this.baseUrl}/getByUserId/${user_id}`;
    const headers = new HttpHeaders().set('Authorization', 'Bearer ' + this.loginService.getToken());
    return this.http.get<any>(url, {headers});
  }

  getAppointmentsByDoctorId(doctor_id:any): Observable<any> {
    const url = `${this.baseUrl}/getByDoctorId/${doctor_id}`;
    const headers = new HttpHeaders().set('Authorization', 'Bearer ' + this.loginService.getToken());
    return this.http.get<any>(url, {headers});
  }


  updateStatus(appointmentId: any, status:any): Observable<any> {
    const url = `${this.baseUrl}/updateStatus/${appointmentId}`;
    const headers = new HttpHeaders().set('Authorization', 'Bearer ' + this.loginService.getToken());
    return this.http.put<any>(url, {status},{headers});
  }

 

}
