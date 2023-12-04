import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OwlOptions } from 'ngx-owl-carousel-o';
import { Observable } from 'rxjs';
import { AllCourses } from 'src/app/models/allcourses';
<<<<<<< Updated upstream:Frontend/src/app/all-courses/all-courses.component.ts
import { Course } from '../models/course';
import { MyServiceService } from '../my-service.service';
=======


import { MatDialog } from '@angular/material/dialog';
import { UpdateCourseComponent } from '../update-course/update-course.component';
import { CourseService } from '../course-service.service';
import { Course } from 'src/app/models/course';
>>>>>>> Stashed changes:Frontend/src/app/courses/all-courses/all-courses.component.ts


@Component({
  selector: 'app-all-courses',
  templateUrl: './all-courses.component.html',
  styleUrls: ['./all-courses.component.css']
})
export class AllCoursesComponent {

  myenrollments : Observable<AllCourses[]> | undefined;
  loggedUser = '';
  currRole = '';
<<<<<<< Updated upstream:Frontend/src/app/all-courses/all-courses.component.ts
  courses : Observable<Course[]> | undefined;
  constructor( private _router : Router,private courseService : MyServiceService) { }
=======
  courses : any;
  approvedcourses:any;
  unapprovedcourses:any;
  constructor( private _router : Router,private courseService : CourseService, private dialog : MatDialog) { }
>>>>>>> Stashed changes:Frontend/src/app/courses/all-courses/all-courses.component.ts

  ngOnInit(): void 
  {
    this.loggedUser = JSON.stringify(sessionStorage.getItem('loggedUser')|| '{}');
    this.loggedUser = this.loggedUser.replace(/"/g, '');

    this.currRole = JSON.stringify(sessionStorage.getItem('ROLE')|| '{}'); 
    this.currRole = this.currRole.replace(/"/g, '');

    this.courseService.getCoursesByEmail(this.loggedUser).subscribe((data)=>
    {
      this.courses=data;
      // this.approvedcourses=this.courses.forEach((value)=>{ value.courseStatus});
      this.approvedcourses = this.courses.filter((course: Course) => course.courseStatus === 'active');
      this.unapprovedcourses = this.courses.filter((course: Course) => course.courseStatus === 'inactive');
    });
   

    const target = 'https://www.youtube.com/iframe_api'

  if (!this.isScriptLoaded(target)) {
    const tag = document.createElement('script')
    tag.src = target
    document.body.appendChild(tag)
  }
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
