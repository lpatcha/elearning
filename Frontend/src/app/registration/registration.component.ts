// import { Component } from '@angular/core';

// @Component({
//   selector: 'app-registration',
//   templateUrl: './registration.component.html',
//   styleUrls: ['./registration.component.css']
// })
// export class RegistrationComponent {

// }



import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
<<<<<<< Updated upstream
<<<<<<< Updated upstream
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
<<<<<<< Updated upstream
=======
import { MyServiceService } from '../my-service.service';
=======
=======
>>>>>>> Stashed changes
import { AbstractControl, FormBuilder, FormGroup, ValidatorFn, Validators } from '@angular/forms';

>>>>>>> Stashed changes
import { ToastrService } from 'ngx-toastr';
import { CategoryService } from '../category.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  // email: string = '';
  // name: string = '';
  // deptName: any;
  // password:any;
  myForm:FormGroup;

<<<<<<< Updated upstream
<<<<<<< Updated upstream
<<<<<<< Updated upstream
  constructor(private route: ActivatedRoute, private router: Router, private http: HttpClient,private formBuilder: FormBuilder) { 
=======
=======
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
  constructor(private route: ActivatedRoute, private router: Router, private http: HttpClient,private formBuilder: FormBuilder,private toastr: ToastrService,private myService:CategoryService) { 
    this.myForm = this.formBuilder.group({
      name: ['', [Validators.required]],
      dept: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(8)]],
      phoneno: ['', [Validators.required, Validators.pattern(/^\d{3}-\d{3}-\d{4}$/)]],
      dob: [null, [Validators.required,this.dateNotInFutureValidator()]]
    });
<<<<<<< Updated upstream
=======

    // this.myForm.get('dept')?.valueChanges.subscribe(deptValue => {
    //   // Do something with the selected department, e.g., log it
    //   this.myForm?.get('dept')?.setValue(this.myForm?.get('dept'));
    //   console.log('Selected department:', deptValue);
    // });
>>>>>>> Stashed changes
  }
  dateNotInFutureValidator(): ValidatorFn {
    return (control: AbstractControl): { [key: string]: any } | null => {
      if (control.value) {
        const selectedDate = new Date(control.value);
        const currentDate = new Date();
  
        if (selectedDate > currentDate) {
          return { 'futureDate': true }; // Return an error object if the date is in the future
        }
      }
      return null; // Return null if the date is valid
    };
  }
  get email() {
    return this.myForm.get('email');
  }

  get password() {
    return this.myForm.get('password');
  }
  get name() {
    return this.myForm.get('name');
  }

  get dept() {
    return this.myForm.get('dept');
  }
  get phoneno() {
    return this.myForm.get('phoneno');
  }

  get dob() {
    return this.myForm.get('dob');
  }
  // set email(a:any){
  //   this.myForm[]);
  // }

  ngOnInit(): void {
    // Retrieve the email and token from the query parameters
    this.route.queryParams.subscribe(params => {
      //  this.myForm.value.email = params['email'];
       this.myForm?.get('email')?.setValue(params['email']);
       this.myForm.get('email')?.disable();
     
    });
<<<<<<< Updated upstream
<<<<<<< Updated upstream
  }
=======
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes

  submitRegistrationForm(): void {
    // const adminData = { email: this.email, name: this.name, deptName:this.deptName ,password:this.password};
    if (this.myForm.valid) {
      const formData = this.myForm.value;
      const formData1={email:this.myForm.get('email')?.value,name:this.myForm.get('name')?.value,
      password:this.myForm.get('password')?.value,dept:this.myForm.get('dept')?.value,
      phoneno:this.myForm.get('phoneno')?.value,dob:this.myForm.get('dob')?.value}
      console.log( formData1);
    
    this.http.post('http://localhost:8080/api/student/registration', formData1).subscribe(
      (response: any) => {
        if (response.message === 'Student registration initiated successfully.') {
          // Send an email to the admin with the registration link
          // this.sendRegistrationEmail(this.email);
          this.router.navigate(['/admin']);
          console.log('Registration email sent to successful');
        } else {
          console.error('Admin creation failed.');
        }
      },
      (error: any) => {
        console.error('An error occurred while creating the admin:', error);
      }
    );
    }
  }
}
