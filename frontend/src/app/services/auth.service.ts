import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private baseUrl = 'http://localhost:8080';

  private http = inject( HttpClient );

  registerUser(username: string, name : string, lastname : string, email : string, password : string) {
    return this.http.post(`${this.baseUrl}/register`, {username : username, name : name, lastname : lastname, email : email, password : password});
  }
}
