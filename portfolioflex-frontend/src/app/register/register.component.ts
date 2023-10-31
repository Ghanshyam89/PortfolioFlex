import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { RegistrationService } from '../services/registration.service';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private registrationService: RegistrationService,
    private loginService: LoginService
  ) { }

  registrationForm!: FormGroup;
  error = false;
  errorMessage = '';

  get email() { return this.registrationForm.get('email'); }
  get firstname() { return this.registrationForm.get('firstName'); }
  get lastname() { return this.registrationForm.get('lastName'); }
  get password() { return this.registrationForm.get('password'); }
  get confirmPassword() { return this.registrationForm.get('confirmPassword'); }

  ngOnInit(): void {
    this.registrationForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      firstName: ['', [Validators.required, Validators.pattern(/^[A-Za-z]+$/)]],
      lastName: ['', [Validators.required, Validators.pattern(/^[A-Za-z]+$/)]],
      password: ['', [Validators.required, Validators.minLength(6), Validators.pattern(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{6,}$/)]],
      confirmPassword: ['', [Validators.required, this.matchValidator('password')]]
    });
  }

  matchValidator(controlName: string) {
    return (control: AbstractControl) => {
      const formGroup = control.parent as FormGroup;
      if (formGroup && control.value !== formGroup.controls[controlName].value) {
        return { mismatch: true };
      }
      return null;
    };
  }

  onSubmit() {
    if (this.registrationForm.valid) {

      const formData = {
        email: this.email.value,
        name: this.firstname.value + " " + this.lastname.value,
        password: this.password.value
      };

      // const headers = new HttpHeaders({ 'Content-Type': 'application/json' });

      this.registrationService.register(formData).subscribe({
        next: (response: any) => {
          // console.log('Successfully registered! \nRedirecting to Login Page ...');
          // alert('Successfully registered! \nRedirecting to Login Page ...');
          console.log('Successfully registered! \Automatically Logging in ...');
          
          this.login(formData);
        },
        error: (error: any) => {
          if (error instanceof HttpErrorResponse) {
            if (error.status === 400) {
              this.error = true;
              this.errorMessage = 'Conflict: User already exists';
            } else {
              console.warn('Response:', error);
            }
          }
        }
      });

    } else {
      this.errorMessage = "Warning: The form is Invalid.";
    }
  }           // onSubmit() ends here

  login(data){
    this.loginService.login(data).subscribe({
      next: (response: any) => {
        console.log("Login Response: ", response);
        if (response.message) {
          this.errorMessage = response.message;
        }
        // localStorage.setItem('isLoggedIn', 'true');
        this.router.navigate(['onboarding']);
      },
      error: (error: any) => {
        if (error instanceof HttpErrorResponse) {
          if (error.status === 401) {
            this.error = true;
            // this.loginMessage = error.error.message;
            this.errorMessage = "Invalid email or password";
          } else {
            console.warn('An error occurred during login:', error.error);
            this.router.navigateByUrl('/error');
          }
        }
      }
    });
  }
}
