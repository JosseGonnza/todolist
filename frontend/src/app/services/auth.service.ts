import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, map } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  // ... los métodos de autenticación irán aquí
  login(username: string, password: string): Observable<any> {
    // Reemplazar con la URL real del punto final de la API de tu backend
    const loginUrl = 'http://localhost:8080/index';
    const loginData = { username, password };

    // Enviar solicitud POST al punto final de la API de inicio de sesión
    return this.http.post<any>(loginUrl, loginData)
      // Manejar la respuesta exitosa del inicio de sesión
      .pipe(
        map((response) => {
          // Almacenar el token de autenticación o los datos del usuario si es necesario
          console.log('¡Inicio de sesión exitoso!', response);
          return response;
        })
      );
  }

}
