import { AuthService } from './../../services/auth.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { User } from '../user/user';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-register',
  imports: [ReactiveFormsModule, RouterModule, FormsModule],
  standalone: true,
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {

  name: string = "";
  lastname: string = "";
  username: string = "";
  email: string = "";
  password: string = "";


  constructor(private authService: AuthService ,private formBuilder: FormBuilder, private http: HttpClient) {}



  onSubmit() {
        let user = new User (this.name, this.lastname, this.username, this.email, this.password);
        console.log(user);
        this.authService.registerUser(
          this.name,
          this.lastname,
          this.username,
          this.email,
          this.password).subscribe(
          res => console.log(res)
        );
    }
}



