import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, map } from 'rxjs';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root'
})
export class NormalUserService {

  private baseUrl = 'http://localhost:8181'; //Spring boot url

  constructor(private http: HttpClient, private loginService: LoginService) { }

  
  registerUser(user: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/user/`, user);
  }

 
  sendOTP(email: string, otp: string): Observable<any> {
    const body = { email, otp };
    const headers = { 'Content-Type': 'application/json' };
    return this.http.post(`${this.baseUrl}/user/verify-otp`, body, { responseType: 'text', headers, observe: 'response' })
      .pipe(map(response => response.body)); // Assuming the response body contains the OTP verification status
  }

  postQueries(query: any): Observable<any> {
    const headers = new HttpHeaders().set('Authorization', 'Bearer ' + this.loginService.getToken());
    return this.http.post(`${this.baseUrl}/user/query`, query, {headers});
  }

  getUser(userId:any): Observable<any> {
    const url = `${this.baseUrl}/user/getUser/${userId}`;
    const headers = new HttpHeaders().set('Authorization', 'Bearer ' + this.loginService.getToken());
    return this.http.get<any>(url, {headers});
  }

  updateUser(email: string, user: any): Observable<any> {
    const url = `${this.baseUrl}/user/updateUser/${email}`;
    const headers = new HttpHeaders().set('Authorization', 'Bearer ' + this.loginService.getToken());
    return this.http.put(url, user, {headers});
  }
}


