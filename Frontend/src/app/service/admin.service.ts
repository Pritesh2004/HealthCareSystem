import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  private baseUrl = 'http://localhost:8181/admin'; // Spring Boot URL


  constructor(private http: HttpClient, private loginService : LoginService) { }

  getAdmin(userId:any): Observable<any> {
    const url = `${this.baseUrl}/getAdmin/${userId}`;
    const headers = new HttpHeaders().set('Authorization', 'Bearer ' + this.loginService.getToken());
    return this.http.get<any>(url, {headers});
  }

  addSpecialization(spec: any): Observable<any> {
    const url = `${this.baseUrl}/addSpec`;
    const headers = new HttpHeaders().set('Authorization', 'Bearer ' + this.loginService.getToken());
    return this.http.post<any>(url, spec, {headers});
  }

  getAllSpecializations(): Observable<any> {
    const url = `${this.baseUrl}/getAllSpec`;
    const headers = new HttpHeaders().set('Authorization', 'Bearer ' + this.loginService.getToken());
    return this.http.get<any>(url, {headers});
  }

  saveDoctor(doctorDto: any): Observable<any> {
    const url = `${this.baseUrl}/saveDoctor`;
    const headers = new HttpHeaders().set('Authorization', 'Bearer ' + this.loginService.getToken());
    return this.http.post<any>(url, doctorDto, {headers});
  }
}
