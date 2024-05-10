import { UserService } from './../../services/user.service';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, FormsModule } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [ReactiveFormsModule, RouterModule, FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit{

  username: string = "";
  password: string = "";

  constructor(private userService: UserService,
    private formBuilder: FormBuilder,
    private http: HttpClient,
    private router: Router) {}


  ngOnInit(): void {

  }


  onSubmit():void {
    this.userService.loginUser(
      this.username,
      this.password).subscribe;

    this.userService.register();
  }
}
