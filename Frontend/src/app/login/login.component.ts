import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  email: any;
  password: any;

<<<<<<< Updated upstream

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

  get password() {
    return this.myForm.get('password');
  }
=======
  constructor(private http: HttpClient, private router: Router) {}
>>>>>>> Stashed changes


  login() {
    
    const authUrl = 'http://localhost:8080/login';

<<<<<<< Updated upstream

    if (this.myForm.valid) {
      const formData = this.myForm.value;


    
    this.http.post(authUrl, formData, { responseType: 'text' }).subscribe(
      (response: any) => {
        const role = response;
        this.authService.setAuthenticated(true);

    
        if (role === '') {

          this.router.navigate(['/admin']); // Redirect to admin page
=======
    // Create an object to hold the user's credentials
    const credentials = {
      email: this.email,
      password: this.password,
    };

    // Make an HTTP POST request to authenticate the user
    this.http.post<any>(authUrl, credentials).subscribe(
      (response) => {
        const role = response.message;
        if (role === 'IT') {
          this.router.navigate(['/upload-excel']); // Redirect to admin page
>>>>>>> Stashed changes
        } else if (role === 'student') {
          this.router.navigate(['/upload-excel']); // Redirect to student page
        }
      },
      (error) => {
        console.error('Login failed:', error);
      }
    );
  }
}
