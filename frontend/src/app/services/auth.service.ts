import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { catchError, of, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private urlRegister: string = 'http://localhost:8080/register';

  constructor(private http: HttpClient) {};

  registerUser(username: string, name : string, lastname : string, email : string, password : string) {
    return this.http.post(this.urlRegister, {
      username : username,
      name : name,
      lastname : lastname,
      email : email,
      password : password})
      .pipe(tap(response =>
        {console.log(response)}),
        catchError(error => {return of(error)})
      );
  }
}
