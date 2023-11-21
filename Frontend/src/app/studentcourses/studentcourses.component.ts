import { Component } from '@angular/core';
import { OwlOptions } from 'ngx-owl-carousel-o';
import { Observable } from 'rxjs';
import { AllCourses } from '../models/allcourses';
import { Course } from '../models/course';
<<<<<<< Updated upstream:Frontend/src/app/studentcourses/studentcourses.component.ts
import { Router } from '@angular/router';
=======
import { MyServiceService } from '../my-service.service';
import { MatDialog } from '@angular/material/dialog';
import { UpdateCourseComponent } from '../update-course/update-course.component';
>>>>>>> Stashed changes:Frontend/src/app/all-courses/all-courses.component.ts

import { MatDialog } from '@angular/material/dialog';
import { CourseService } from '../courses/course-service.service';

@Component({
  selector: 'app-studentcourses',
  templateUrl: './studentcourses.component.html',
  styleUrls: ['./studentcourses.component.css']
})
export class StudentcoursesComponent {
  
  myenrollments : Observable<AllCourses[]> | undefined;
  loggedUser = '';
  currRole = '';
<<<<<<< Updated upstream:Frontend/src/app/studentcourses/studentcourses.component.ts
  courses : any;
  constructor( private _router : Router,private courseService : CourseService, private dialog : MatDialog) { }
=======
  courses : Observable<Course[]> | undefined;
  constructor( private _router : Router,private courseService : MyServiceService, private dialog : MatDialog) { }
>>>>>>> Stashed changes:Frontend/src/app/all-courses/all-courses.component.ts

  ngOnInit(): void 
  {
    this.loggedUser = JSON.stringify(sessionStorage.getItem('loggedUser')|| '{}');
    this.loggedUser = this.loggedUser.replace(/"/g, '');

    this.currRole = JSON.stringify(sessionStorage.getItem('ROLE')|| '{}'); 
    this.currRole = this.currRole.replace(/"/g, '');

    this.courseService.getstudentCoursesByEmail(this.loggedUser).subscribe((data)=>
    {
      this.courses =data;
      console.log(this.courses);
    });
   console.log(this.courses);
    const target = 'https://www.youtube.com/iframe_api'

  if (!this.isScriptLoaded(target)) {
    const tag = document.createElement('script')
    tag.src = target
    document.body.appendChild(tag)
  }
  }


  updateCourse(courseId : any): void {
<<<<<<< Updated upstream:Frontend/src/app/studentcourses/studentcourses.component.ts
    // this.dialog.open(UpdateCourseComponent, {
    //   data: { courseId: courseId },
    //   width: '500px',
    //   height:'500px'
    // });
=======
    this.dialog.open(UpdateCourseComponent, {
      data: { courseId: courseId },
      width: '500px',
      height:'500px'
    });
>>>>>>> Stashed changes:Frontend/src/app/all-courses/all-courses.component.ts
  }



  isScriptLoaded(target: string): boolean
  {
    return document.querySelector('script[src="' + target + '"]') ? true : false
  }

  visitCourse(coursename : string)
  {
    this._router.navigate(['/allcourses', coursename]);
  }

  

  owlDragging(e: any){
    console.log(e);
  }
  
   owlOptions: OwlOptions = {
     loop: true,
     mouseDrag: true,
     touchDrag: true,
     margin: 50,
     stagePadding: 20,
     pullDrag: true,
     dots: false,
     navSpeed: 1000,
     autoplay: true,
     navText: ['Previous', 'Next'],
     responsive: {
       0: {
         items: 1 
       },
       400: {
         items: 2
       },
       767: {
         items: 2
       },
       1024: {
         items: 3
       }
     },
     nav: true
   }


}
