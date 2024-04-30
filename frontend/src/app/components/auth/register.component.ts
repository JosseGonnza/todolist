import { Component, inject } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { Router, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {

  formData: any = {}

  constructor(private authService: AuthService) {}
  private router = inject( Router );

  register(formData: any) {
    this.authService.registerUser(this.formData).subscribe(
      response => {
        this.router.navigate(['http://localhost:8080/index'])
      },
      error => {
        console.error('Registro fallido', error);
      }
      );
  }
}
