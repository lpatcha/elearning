import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OwlOptions } from 'ngx-owl-carousel-o';
import { Observable } from 'rxjs';
import { AllCourses } from 'src/app/models/allcourses';
import { Course } from '../models/course';
import { MyServiceService } from '../my-service.service';
import { MatDialog } from '@angular/material/dialog';
import { UpdateCourseComponent } from '../update-course/update-course.component';


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
<<<<<<< Updated upstream:Frontend/src/app/all-courses/all-courses.component.ts
  courses : Observable<Course[]> | undefined;
  constructor( private _router : Router,private courseService : MyServiceService, private dialog : MatDialog) { }
=======
=======
>>>>>>> Stashed changes:Frontend/src/app/studentcourses/studentcourses.component.ts
  courses : any;
  constructor( private _router : Router,private courseService : CourseService, private dialog : MatDialog) { }
>>>>>>> Stashed changes:Frontend/src/app/studentcourses/studentcourses.component.ts

  ngOnInit(): void 
  {
    this.loggedUser = JSON.stringify(sessionStorage.getItem('loggedUser')|| '{}');
    this.loggedUser = this.loggedUser.replace(/"/g, '');

    this.currRole = JSON.stringify(sessionStorage.getItem('ROLE')|| '{}'); 
    this.currRole = this.currRole.replace(/"/g, '');

<<<<<<< Updated upstream:Frontend/src/app/all-courses/all-courses.component.ts
<<<<<<< Updated upstream:Frontend/src/app/all-courses/all-courses.component.ts
    this.courses = this.courseService.getCoursesByEmail(this.loggedUser);

=======
=======
>>>>>>> Stashed changes:Frontend/src/app/studentcourses/studentcourses.component.ts
    this.courseService.getstudentCoursesByEmail(this.loggedUser).subscribe((data)=>
    {
      this.courses =data;
      console.log(this.courses);
    });
   console.log(this.courses);
<<<<<<< Updated upstream:Frontend/src/app/all-courses/all-courses.component.ts
>>>>>>> Stashed changes:Frontend/src/app/studentcourses/studentcourses.component.ts
=======
>>>>>>> Stashed changes:Frontend/src/app/studentcourses/studentcourses.component.ts
    const target = 'https://www.youtube.com/iframe_api'

  if (!this.isScriptLoaded(target)) {
    const tag = document.createElement('script')
    tag.src = target
    document.body.appendChild(tag)
  }
  }


  updateCourse(courseId : any): void {
    this.dialog.open(UpdateCourseComponent, {
      data: { courseId: courseId },
      width: '500px',
      height:'500px'
    });
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
