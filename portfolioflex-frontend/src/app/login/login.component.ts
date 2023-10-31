import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  loginForm: FormGroup;
  error: boolean;
  loginMessage: string;

  get email() { return this.loginForm.get('email') }
  get password() { return this.loginForm.get('password') }

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private loginService: LoginService
  ) { }

  ngOnInit(): void {
    this.initLoginForm();
  }

  initLoginForm(): void {
    this.loginForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]]
    });
  }

  onSubmit(): void {
    if (this.loginForm.invalid) {
      this.loginMessage = "Login form is invalid.";
      console.error('Login form is invalid.');
      return;
    }

    const email = this.loginForm.value.email;
    const password = this.loginForm.value.password;
    const body = JSON.stringify({ email, password });

    // const loginUrl = 'https://productcatalogapps.azurewebsites.net/login';
    // const headers = new HttpHeaders({ 'Content-Type': 'application/json' });

    this.loginService.login(body).subscribe({
      next: (response: any) => {
        console.log("Login Response: ", response);
        if (response.message) {
          this.loginMessage = response.message;
        }
        localStorage.setItem('isLoggedIn', 'true');
        this.router.navigate(['portfolio']);
      },
      error: (error: any) => {
        if (error instanceof HttpErrorResponse) {
          if (error.status === 401) {
            this.error = true;
            // this.loginMessage = error.error.message;
            this.loginMessage = "Invalid email or password";
            // console.error(error.error);
            this.loginForm.reset();
          } else {
            console.warn('An error occurred during login:', error.error);
            this.router.navigateByUrl('/error');
          }
        }
      }
    });
    
  }
}