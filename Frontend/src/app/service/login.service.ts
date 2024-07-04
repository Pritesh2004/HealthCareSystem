import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  public loginStatusSubject = new Subject<boolean>();

  private baseUrl = 'https://healthcare-backend-jsrk.onrender.com'; // Spring Boot URL

  constructor(private http: HttpClient) { }

  public generateToken(userRequest: any) {
    return this.http.post(`${this.baseUrl}/generate-token`, userRequest);
  }

  public getLoggedInUser() {
    const headers = new HttpHeaders().set('Authorization', 'Bearer ' + this.getToken());
    return this.http.get(`${this.baseUrl}/current-user`, { headers });
  }

  public userLogin(token: any) {
    localStorage.setItem("token", token);
    return true;
  }

  public isLoggenIn() {
    let token = localStorage.getItem("token");
    return !!token; // Simplified check for token presence
  }

  public logout() {
    localStorage.removeItem("token");
    localStorage.removeItem("user");
    return true;
  }

  public getToken() {
    return localStorage.getItem("token") || '';
  }

  public setUser(user: any) {
    localStorage.setItem('user', JSON.stringify(user));
  }

  public getUser() {
    let user = localStorage.getItem("user");
    return user ? JSON.parse(user) : null;
  }

  public getUserRole() {
    let user = this.getUser();
    return user ? user.role : null; // Assuming user object has a 'role' property
  }

}
