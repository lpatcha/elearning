import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { ChangePasswordComponent } from '../change-password/change-password.component';
import { MatDialog } from '@angular/material/dialog';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})



export class HeaderComponent implements OnInit {

  loggedUser = '';
  currRole = '';
  title = '';

  constructor(private activatedRoute: ActivatedRoute, private router: Router,private toastr: ToastrService,public dialog: MatDialog) { }

  ngOnInit(): void 
  {
    this.loggedUser = JSON.stringify(sessionStorage.getItem('loggedUser')|| '{}');
    this.loggedUser = this.loggedUser.replace(/"/g, '');

    this.currRole = JSON.stringify(sessionStorage.getItem('ROLE')|| '{}'); 
    this.currRole = this.currRole.replace(/"/g, '');

    if(this.currRole === "admin"){
      this.title = "Admin Dashboard";
    }
    else if(this.currRole === "teacher"){
      this.title = "Teacher Dashboard";
    }
    else if(this.currRole === "student"){
      this.title = "Student Dashboard";
    }
  }

  // params: any;

  // agInit(params: any): void {
  //   this.params = params;
  // }
  onClick(): void {
    // if (this.params.onClick) {
      console.log("hii");
      this.router.navigate(['update-details', this.loggedUser]);
     // this.params.onClick(this.params.data);
    // }
  }
  logout()
  {
    // sessionStorage.clear();
    // this._router.navigate(['/login']);
    this.toastr.success("Logout Successfull")
    localStorage.removeItem('isAuthenticated');
    // Redirect to the login page after logout
    this.router.navigate(['/login']);
  }

  navigateHome()
  {
    if(this.currRole === "admin"){
      console.log("admin")
      this.router.navigate(['/admin']);
    }
    else if(this.currRole === "teacher"){
      this.router.navigate(['/teacherdashboard']);
    }
    else if(this.currRole === "student"){
      this.router.navigate(['/student']);
    }
  }

  viewDetails()
  {

  }

  changePassword(): void {
    this.dialog.open(ChangePasswordComponent, {
      
      width: '400px',
      height:'400px',
      data:{
        userId: this.loggedUser
      }
    });
    
  }


}
