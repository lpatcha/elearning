import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Course } from 'src/app/models/course';

import * as $ from 'jquery';
import { MyServiceService } from '../my-service.service';
import { HttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { CategoryService } from '../category.service';
<<<<<<< Updated upstream
<<<<<<< Updated upstream
>>>>>>> Stashed changes

=======
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
@Component({
  selector: 'app-addcourse',
  templateUrl: './addcourse.component.html',
  styleUrls: ['./addcourse.component.css']
})
export class AddcourseComponent implements OnInit {

  course = new Course();
  msg = ' ';
  subcategories: any;
  categories:any;
  startdatemsg:any;
  constructor(private courseService : CategoryService, private _router : Router, private http : HttpClient, private toastr: ToastrService) { }

  ngOnInit(): void 
  {
    this.http.get<string[]>('http://localhost:8080/category/leaf').subscribe((response) => {
      this.categories = response;
    });
    $("#websitelink, #youtubelink").css("display","none");
    $("#websitelink").hide();
    const p=sessionStorage.getItem('loggedUser');
    this.course.professorName=p;
<<<<<<< Updated upstream
<<<<<<< Updated upstream
    $("select").on('change', function() {
      $(this).find("option:selected").each(function() {
          var option = $(this).attr("value");
          if(option === "Website") {
            $("#websitelink").css("display","block");
            $("#youtubelink").css("display","none");
          } 
          else if(option === "Youtube")
          {
            $("#youtubelink").css("display","block");
            $("#websitelink").css("display","none");
          }
      });
    }).change();
=======
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
  }

  checkDateValidity() {
    const startDate = new Date(this.course.startDate);
    const endDate = new Date(this.course.endDate);

    if (endDate < startDate) {
      this.msg = 'End date should be greater than or equal to start date';
    } else {
<<<<<<< Updated upstream
      this.msg = ''; // Reset the message if the dates are valid
    }
=======
      this.msg = ''; 
    }
  }
  checkstartDateValidity(){
    const selectedDate = new Date(this.course.startDate);
    const currentDate = new Date();
        if (selectedDate < currentDate) {
          this.startdatemsg = 'Start date should be greater than current date';
        } else {
          this.startdatemsg = ''; 
        }
  }

  addCourse()
  {
    this.courseService.addCourse(this.course).subscribe(
      data => {
        console.log("Course added Successfully !!!");
<<<<<<< Updated upstream
<<<<<<< Updated upstream
        this._router.navigate(['/addchapter']);
=======
=======
>>>>>>> Stashed changes
        this._router.navigate(['/teacherdashboard']);
        this.toastr.success("Course approve request sent to admin")
        this.course.department='';
>>>>>>> Stashed changes
      },
      error => {
        console.log("Process Failed");
        console.log(error.error);
        this.msg = "Course with "+this.course.courseName+" already exists !!!";
      }
    )
  }

}
