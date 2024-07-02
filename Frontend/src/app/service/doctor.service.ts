import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LoginService } from './login.service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DoctorService {


  private baseUrl = 'http://localhost:8181/doctor'; // Spring Boot URL


  constructor(private http: HttpClient, private loginService : LoginService) { }


  getDoctor(userId:any): Observable<any> {
    const url = `${this.baseUrl}/getDoctorById/${userId}`;
    const headers = new HttpHeaders().set('Authorization', 'Bearer ' + this.loginService.getToken());
    return this.http.get<any>(url, {headers});
  }

  getAllDoctos(): Observable<any> {
    const url = `${this.baseUrl}/getAllDoc`;
    const headers = new HttpHeaders().set('Authorization', 'Bearer ' + this.loginService.getToken());
    return this.http.get<any>(url, {headers});
  }

  getAllDoctorSpec(): Observable<any> {
    const url = `${this.baseUrl}/getAllDoctorSpecializations`;
    const headers = new HttpHeaders().set('Authorization', 'Bearer ' + this.loginService.getToken());
    return this.http.get<any>(url, {headers});
  }


  getDoctorSpecializationByDoctorId(doctorId: number): Observable<any> {
    const url = `${this.baseUrl}/getSpecializationByDoctorId/${doctorId}`;
    const headers = new HttpHeaders().set('Authorization', 'Bearer ' + this.loginService.getToken());

    return this.http.get<any>(url, {headers});
  }

}
