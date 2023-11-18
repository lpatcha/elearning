import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { AuthGuardService } from '../auth-guard.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  // email: any;
  // password: any;
  myForm: FormGroup;

  // constructor(private http: HttpClient, private router: Router, private authService: AuthGuardService) {}
  // constructor(private http: HttpClient, private router: Router) {}
  constructor(private http: HttpClient, private router: Router,private formBuilder: FormBuilder, private authService: AuthGuardService) {
    this.myForm = this.formBuilder.group({
      // name: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(8)]],
      // phone: ['', [Validators.required, Validators.pattern(/^\d{3}-\d{3}-\d{4}$/)]]
    });
  }
  get email() {
    return this.myForm.get('email');
  }

  goToForgotPassword() {
    this.router.navigate(['/forgot-password']);
  }

  get password() {
    return this.myForm.get('password');
  }

  login() {
    
    const authUrl = 'http://localhost:8080/login';
<<<<<<< Updated upstream

    
    if (this.myForm.valid) {
      const formData = this.myForm.value;


    
    this.http.post(authUrl, formData).subscribe(
      (response: any) => {
        let role = response.role;
        let email = response.email;
        let status = response.status;
        sessionStorage.setItem('loggedUser', email);
        sessionStorage.setItem('ROLE', role);
        sessionStorage.setItem('name', email);
        sessionStorage.setItem('gender', "male");
        this.authService.setAuthenticated(true);

    
        if (role === 'admin') {
          this.router.navigate(['/admin']); // Redirect to admin page
        } else if (role === 'student') {
          this.router.navigate(['/upload-excel']); // Redirect to student page
        } else {
          console.error('Invalid role:', role);
=======
  
    if (this.myForm.valid) {
      const formData = this.myForm.value;
  
      this.http.post(authUrl, formData).subscribe(
        (response: any) => {
          let role = response.role;
          let email = response.email;
          sessionStorage.setItem('loggedUser', email);
          sessionStorage.setItem('ROLE', role);
          sessionStorage.setItem('name', email);
          sessionStorage.setItem('gender', 'male');
          this.authService.setAuthenticated(true);
  
          if (role === 'admin') {
            
            this.toastr.success('Login Successful', '');
            this.router.navigate(['/admin']);
          } else if (role === 'student') {
            this.toastr.success('Login Successful', '');
            this.router.navigate(['/student']);
          } else if (role === 'teacher') {
            this.toastr.success('Login Successful', '');
            this.router.navigate(['/teacherdashboard']);
          } else {
            this.showErrorMessage = true;
            this.toastr.error('Login Failed', '');
            this.errorMessage = 'Invalid role or login credentials.';
            console.error('Invalid role:', role);
          }
        },
        (error) => {
          this.showErrorMessage = true;
  
          if (error.status === 401 || error.status === 403) {
            // Unauthorized or Forbidden status code (authentication failure)
            this.router.navigate(['/login']);
            this.errorMessage = 'Invalid username or password.';
            this.toastr.error('Invalid username or password.', '');
          } else {
            this.errorMessage = 'An error occurred. Please try again later.';
          }
  
          console.error('Login failed:', error);
>>>>>>> Stashed changes
        }
      },
      (error) => {
        console.error('Login failed:', error);
      }
    );
    }
  }
<<<<<<< Updated upstream


=======
>>>>>>> Stashed changes
  
}
