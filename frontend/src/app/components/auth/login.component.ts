import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit {

  username: string = '';
  password: string = '';

  ngOnInit(): void { }

  onSubmit() {
    // Call the login service here (to be created)
    console.log("Login attempted with username:", this.username, "and password:", this.password);
    // Handle successful login or error
  }
}
