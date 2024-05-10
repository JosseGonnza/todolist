import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Router } from '@angular/router';
import { catchError, of, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private urlLogin: string = 'http://localhost:8080/login';

  private http = inject(HttpClient);

  private router = inject(Router)

  loginUser(username: string, password: string) {
    return this.http.post(this.urlLogin, {
      username : username,
      password : password
    }).pipe(tap(response =>
      this.router.navigate(['/categories/home'])
    ),catchError(error => {return of(error)}));
  }

  register() {
    this.router.navigate(['/categories/home']);
  }
}
