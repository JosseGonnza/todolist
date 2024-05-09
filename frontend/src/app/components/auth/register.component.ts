import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { catchError, last, of, tap } from 'rxjs';

@Component({
  selector: 'app-register',
  imports: [ReactiveFormsModule],
  standalone: true,
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent implements OnInit{

  registerForm!: FormGroup;
  nameControl!: FormControl;
  lastnameControl!: FormControl;
  usernameControl!: FormControl;
  emailControl!: FormControl;
  passwordControl!: FormControl;

  constructor(private formBuilder: FormBuilder, private http: HttpClient) {}


  ngOnInit(): void {
      this.nameControl = new FormControl('', Validators.required);
      this.lastnameControl = new FormControl('', Validators.required);
      this.usernameControl = new FormControl('', Validators.required);
      this.emailControl = new FormControl('', Validators.required);
      this.passwordControl = new FormControl('', Validators.required);

      this.registerForm = this.formBuilder.group({
        name: this.nameControl,
        lastname: this.lastnameControl,
        username: this.usernameControl,
        email: this.emailControl,
        password: this.passwordControl
      })
  }


  onSubmit():void {
    if (this.registerForm.valid) {
      this.http.post("http://localhost:8080/register", this.registerForm.value)
      .pipe(tap(response =>
        {console.log(response)}),
        catchError(error => {return of(error)})
      ).subscribe()
    }



/*    this.authService.registerUser(
      this.formData.username,
      this.formData.name,
      this.formData.lastname,
      this.formData.email,
      this.formData.password
    ).subscribe(
      response => {
        this.router.navigate(['http://localhost:4200/'])
      },
      error => {
        console.error('Registro fallido', error);
      }
      );
*/
    }
}
