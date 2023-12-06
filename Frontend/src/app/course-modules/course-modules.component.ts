import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable, distinctUntilChanged, filter, take } from 'rxjs';
import { Course } from '../models/course';

import { Module } from '../models/module';
import { MatDialog } from '@angular/material/dialog';
import { InputDialogComponent } from '../input-dialog/input-dialog.component';
import { VideoContent } from '../models/videocontent';
import { VideoaddComponent } from '../videoadd/videoadd.component';
import { UpdatevideocontentComponent } from '../updatevideocontent/updatevideocontent.component';
import { UpdatemoduleComponent } from '../updatemodule/updatemodule.component';
<<<<<<< Updated upstream
=======
import { ToastrService } from 'ngx-toastr';
import { ModuleService } from '../module.service';
import { VideoService } from '../video.service';
>>>>>>> Stashed changes

@Component({
  selector: 'app-course-modules',
  templateUrl: './course-modules.component.html',
  styleUrls: ['./course-modules.component.css']
})
export class CourseModulesComponent {
  selectedModuleId: any | null = null;
  selectedvideoId: any | null = null;
  moduleNames: Module[]=[];
  video = 'jpvZXcGkUMY';
  courseName = 'springboot';
  // chapterlist : Observable<Chapter[]> | undefined;
  chapter : any | undefined;
  // chapter = new Chapter();
  loggedUser = '';
  currRole = '';
  currentmodule="";
  coursedetails : any;
  createmodule: Module = new Module();
  videocontent:any;
  createvideo:VideoContent=new VideoContent();
  updatevideoreq:VideoContent=new VideoContent();

<<<<<<< Updated upstream
<<<<<<< Updated upstream
  constructor(private _router : Router, private activatedRoute: ActivatedRoute,private courseService : MyServiceService,public dialog: MatDialog) { }
=======
=======
>>>>>>> Stashed changes
  constructor(private _router : Router, private activatedRoute: ActivatedRoute,private moduleService : ModuleService,public dialog: MatDialog,private toastr:ToastrService,private videoService:VideoService) { }
>>>>>>> Stashed changes

  ngOnInit(): void {
    this.loggedUser = JSON.stringify(sessionStorage.getItem('loggedUser')|| '{}');
    this.loggedUser = this.loggedUser.replace(/"/g, '');

    this.currRole = JSON.stringify(sessionStorage.getItem('ROLE')|| '{}'); 
    this.currRole = this.currRole.replace(/"/g, '');
    console.log(this.currRole);
    // const coursename = +this.activatedRoute.snapshot.paramMap.get('id');
    // this.activatedRoute.params.subscribe((data1) => {
    //   const coursename = data1['id'];

<<<<<<< Updated upstream
    //   this.courseService.getCoursesByEmailandcoursename(this.loggedUser,coursename).subscribe((data) => {
=======
    //   this.moduleService.getCoursesByEmailandcoursename(this.loggedUser,coursename).subscribe((data) => {
>>>>>>> Stashed changes
    //     this.coursedetails = data;
    //   });
    //   console.log(this.coursedetails);
    // });
  
<<<<<<< Updated upstream
    // this.course = this.courseService.getCourseById(courseId);
=======
    // this.course = this.moduleService.getCourseById(courseId);
>>>>>>> Stashed changes

    $("#overview").show();
    $("#qa, #notes, #announcements, #questions, #notestxt, #downloads").hide();
    $("#downloadalert").css("display","none");
    this.courseName = this.activatedRoute.snapshot.params['coursename'];
    sessionStorage.setItem('course',this.courseName);
<<<<<<< Updated upstream
<<<<<<< Updated upstream
    // this.courseService.getCoursesByEmailandcoursename(this.loggedUser,this.courseName).subscribe((data) => {
    //   this.coursedetails = data;
    //   console.log(this.coursedetails);
    // });
    this.courseService.getCourseDetailsbyid(this.courseName).subscribe((data) => {
=======
=======
>>>>>>> Stashed changes
    // this.moduleService.getCoursesByEmailandcoursename(this.loggedUser,this.courseName).subscribe((data) => {
    //   this.coursedetails = data;
    //   console.log(this.coursedetails);
    // });
    this.videoService.getCourseDetailsbyid(this.courseName).subscribe((data) => {
>>>>>>> Stashed changes
      this.coursedetails = data;
      console.log(this.coursedetails);
    });

    this.getmodulename();
  

    const target = 'https://www.youtube.com/iframe_api'

    if (!this.isScriptLoaded(target)) {
      const tag = document.createElement('script')
      tag.src = target
      document.body.appendChild(tag)
    }
    this.chapter=
    

    { coursename   : 'maths',
    chapter1name  : 'chapter1',
    chapter1id : 'jpvZXcGkUMY',
    chapter2name : 'chapter2',
    chapter2id: "C2M48s_EE9I",
    chapter3name: 'chapter3',
    chapter3id: 'jpvZXcGkUMY',
    chapter4name: 'chapter4',
    chapter4id: 'jpvZXcGkUMY',
    chapter5name: 'chapter5',
    chapter5id: 'jpvZXcGkUMY',
    chapter6name: 'chapter6',
    chapter6id: 'jpvZXcGkUMY',
    chapter7name: 'chapter7',
    chapter7id: 'jpvZXcGkUMY',
    chapter8name: 'chapter8',
    chapter8id: 'jpvZXcGkUMY',
 }
    // this.chapterlist = this._service.getChappterListByCourseName(this.courseName);
    // this.courselist = this._service.getCourseListByName(this.courseName);

  }
  selectmodule(moduleid:any){
    this.selectedModuleId =moduleid;
  }
  selectvideo(videoid:any){
    this.selectedvideoId =videoid;
  }
  getvideocourse(moduleid:any){
    this.currentmodule=moduleid;
<<<<<<< Updated upstream
    // this.courseService.getvideocontent(this.loggedUser,this.courseName,module).subscribe((data) => {
    //   this.videocontent = data;
    //   console.log(this.videocontent);
    // });
    this.courseService.getvideocontentbyid(moduleid).subscribe((data) => {
=======
    // this.moduleService.getvideocontent(this.loggedUser,this.courseName,module).subscribe((data) => {
    //   this.videocontent = data;
    //   console.log(this.videocontent);
    // });
    this.videoService.getvideocontentbyid(moduleid).subscribe((data) => {
>>>>>>> Stashed changes
      this.videocontent = data;
      console.log(this.videocontent);
    });
  }
  addmodule() {
    let moduleName = prompt('Enter a new module name:');
    this.createmodule.coursename=this.courseName;
    if(moduleName!==null){
         this.createmodule.modulename=moduleName;
    }
    this.createmodule.instructorname=this.loggedUser;

    if (moduleName) {
<<<<<<< Updated upstream
      this.courseService.addmodule(this.createmodule).subscribe((data)=>
=======
      this.moduleService.addmodule(this.createmodule).subscribe((data)=>
>>>>>>> Stashed changes
      {
        this.getmodulename();
        console.log(data);
      });
      // this.users = this.userService.getUsers();
    }
  }
  deletemodule(id:any){
<<<<<<< Updated upstream
    this.courseService.deletemodule(id).subscribe((id)=>
    {
      console.log(id+"deleted");
=======
    this.moduleService.deletemodule(id).subscribe((id)=>
    {
      console.log(id+"deleted");
      this.toastr.error("Module deleted successfully")
>>>>>>> Stashed changes
      this.getmodulename();
    });
  }
  updatemodule(id:any,modulename:any){
    const dialogRef = this.dialog.open(UpdatemoduleComponent, {
      width: '400px', // Set the width as per your design
      data: { content: modulename },
    });

    dialogRef.afterClosed().subscribe((moduleName) => {
      if (moduleName) {
        // Do something with the result (input value) received from the dialog
        console.log('You entered: ' + moduleName);
        // this.createmodule.coursename=this.courseName;
        // if(moduleName!==null){
        //      this.createmodule.modulename=moduleName;
        // }
        // this.createmodule.instructorname=this.loggedUser;
    
        if (moduleName) {
<<<<<<< Updated upstream
          this.courseService.updatemodule(id,moduleName).subscribe((data)=>
          {
            this.getmodulename();
=======
          this.moduleService.updatemodule(id,moduleName).subscribe((data)=>
          {
            this.getmodulename();
            this.toastr.success("Module updated successfully")
>>>>>>> Stashed changes
            console.log(data);
          });
          // this.users = this.userService.getUsers();
        }
      }
    });

  }
  // getmodulename(){
<<<<<<< Updated upstream
  //   this.courseService.getmoduleByEmailandcoursename(this.loggedUser,this.courseName)
=======
  //   this.moduleService.getmoduleByEmailandcoursename(this.loggedUser,this.courseName)
>>>>>>> Stashed changes
  //   //  .pipe(
  //   //   filter(data => !!data), // Ensure that data is available
  //   //   distinctUntilChanged((prev, current) => this.getModuleName(prev) === this.getModuleName(current)), // Prevent redundant calls
  //   //   take(1), // Ensure the API call is made only once
  //   // )
  //   // .subscribe((data) => {
  //   //   this.moduleNames = data;
  //   //   console.log(this.moduleNames);
  //   //   console.log(this.moduleNames);
  //   //   const moduleName = this.getModuleName(data);
  //   //   this.getvideocourse(this.moduleNames[0].modulename);
  //   // });
  //   .subscribe((data) => {
  //     this.moduleNames = data;
  //     this.getvideocourse(this.moduleNames[0].modulename);
  //     console.log(this.moduleNames);
  //   });
  // }
  getmodulename(){
<<<<<<< Updated upstream
    this.courseService.getmoduleById(this.courseName)
=======
    this.moduleService.getmoduleById(this.courseName)
>>>>>>> Stashed changes
    //  .pipe(
    //   filter(data => !!data), // Ensure that data is available
    //   distinctUntilChanged((prev, current) => this.getModuleName(prev) === this.getModuleName(current)), // Prevent redundant calls
    //   take(1), // Ensure the API call is made only once
    // )
    // .subscribe((data) => {
    //   this.moduleNames = data;
    //   console.log(this.moduleNames);
    //   console.log(this.moduleNames);
    //   const moduleName = this.getModuleName(data);
    //   this.getvideocourse(this.moduleNames[0].modulename);
    // });
    .subscribe((data) => {
      this.moduleNames = data;
<<<<<<< Updated upstream
<<<<<<< Updated upstream
      this.getvideocourse(this.moduleNames[0].id);
      this.selectmodule(this.moduleNames[0].id)
=======
=======
>>>>>>> Stashed changes
      if(this.selectedModuleId==null){
      this.getvideocourse(this.moduleNames[0].id);
      this.selectmodule(this.moduleNames[0].id);
      }
      else{
        this.getvideocourse(this.selectedModuleId);
      this.selectmodule(this.selectedModuleId);
      }
      console.log(this.moduleNames);
    });
  }

  private getModuleName(data: any): string {
    return data ? data.map((module:any) => module.modulename).join('') : '';
  }
  openInputDialog(): void {
    const dialogRef = this.dialog.open(InputDialogComponent, {
      width: '400px', // Set the width as per your design
      data: {},
    });

    dialogRef.afterClosed().subscribe((moduleName) => {
      if (moduleName) {
        // Do something with the result (input value) received from the dialog
        console.log('You entered: ' + moduleName);
        this.createmodule.id=this.courseName;
        if(moduleName!==null){
             this.createmodule.modulename=moduleName;
        }
        this.createmodule.instructorname=this.loggedUser;
    
        if (moduleName) {
<<<<<<< Updated upstream
          this.courseService.addmodule(this.createmodule).subscribe((data)=>
          {
=======
          this.moduleService.addmodule(this.createmodule).subscribe((data)=>
          {
            this.toastr.success("Module created successfully")
>>>>>>> Stashed changes
            this.getmodulename();
            console.log(data);
          });
          // this.users = this.userService.getUsers();
        }
      }
    });
  }
  videoadd(){
    const dialogRef = this.dialog.open(VideoaddComponent, {
      width: '400px', // Set the width as per your design
      data: {},
    });

    dialogRef.afterClosed().subscribe((videoName) => {
      if (videoName.videoname) {
  
        // Do something with the result (input value) received from the dialog
        console.log('You entered: ' + videoName);
        this.createvideo.contentName=videoName.videoname;
        this.createvideo.videoUrl=videoName.videourl;
<<<<<<< Updated upstream
=======
        this.createvideo.videodescription=videoName.videodescription;
>>>>>>> Stashed changes
        this.createvideo.courseName=this.courseName;
             this.createvideo.moduleName=this.currentmodule;
        this.createvideo.instructorName=this.loggedUser;
    
        if (videoName) {
<<<<<<< Updated upstream
          this.courseService.addvideo(this.createvideo).subscribe((data)=>
          {
=======
          this.videoService.addvideo(this.createvideo).subscribe((data)=>
          {
            this.toastr.success("Video added successfully")
>>>>>>> Stashed changes
            this.getmodulename();
            console.log(data);
          });
          // this.users = this.userService.getUsers();
        }
      }
    });
  }
  deletevideo(id:any){
<<<<<<< Updated upstream
    this.courseService.deletevideo(id).subscribe((id)=>
=======
    this.videoService.deletevideo(id).subscribe((id)=>
>>>>>>> Stashed changes
    {
      console.log(id+"deleted");
      this.getmodulename();
    })
  }
<<<<<<< Updated upstream
  updatevideo(videoname:any,url:any,id:any){
    let content={
      videoname:videoname,
      videourl:url
=======
  updatevideo(videoname:any,url:any,id:any,videodescription:any){
    let content={
      videoname:videoname,
      videourl:url,
      videodescription:videodescription
>>>>>>> Stashed changes
    }
    const dialogRef = this.dialog.open(UpdatevideocontentComponent, {
      width: '400px',
      data: { content: { ...content } }, // Pass a copy of the data to the dialog
    });
  
    dialogRef.afterClosed().subscribe((updatedData) => {
      if (updatedData) {
        // Handle the updated data here
        this.updatevideoreq.contentName=updatedData.videoname;
        this.updatevideoreq.videoUrl=updatedData.videourl;
<<<<<<< Updated upstream

=======
        this.updatevideoreq.videodescription=updatedData.videodescription;
>>>>>>> Stashed changes
        console.log('Updated Video Name:', updatedData.videoname);
        console.log('Updated Video URL:', updatedData.videourl);
        // You can update your main component's data with the updatedData
        if (updatedData) {
<<<<<<< Updated upstream
          this.courseService.updatevideo(id,this.updatevideoreq).subscribe((data)=>
          {
            this.getmodulename();
=======
          this.videoService.updatevideo(id,this.updatevideoreq).subscribe((data)=>
          {
            this.getmodulename();
            this.selectvideo(id);
>>>>>>> Stashed changes
            console.log(data);
          });
          // this.users = this.userService.getUsers();
        }
      }
    });
      
  }

  openOverview()
  {
    $("#overview").show();
    $("#qa,#announcements,#notes,#downloads").hide();
    $("#downloadalert").css("display","none");
  }
  openQandA()
  {
    $("#qa").show();
    $("#overview,#announcements,#notes,#downloads").hide();
    $("#downloadalert").css("display","none");
  }
  openNotes()
  {
    $("#notes").show();
    $("#overview,#announcements,#qa,#downloads").hide();
    $("#downloadalert").css("display","none");
  }
  openAnnouncements()
  {
    $("#announcements").show();
    $("#overview,#qa,#notes,#downloads").hide();
    $("#downloadalert").css("display","none");
  }
  openDownloads()
  {
    $("#downloads").show();
    $("#overview,#qa,#notes,#announcements").hide();
    $("#downloadalert").css("display","block");
  }
  newQuestion()
  {
    $("#questions").toggle();
  }
  newNotes()
  {
    $("#notestxt").toggle();
  }

  set1()
  {
    $(".box1").css("background-color","green");
    $(".chapter1").addClass("selected");
    $(".box2,.box3,.box4,.box5,.box6,.box7,.box8").css("background-color","white");
    $(".chapter2,.chapter3,.chapter4,.chapter5,.chapter6,.chapter7,.chapter8").removeClass("selected");
  }
  set2()
  {
    $(".box2").css("background-color","green");
    $(".chapter2").addClass("selected");
    $(".box1,.box3,.box4,.box5,.box6,.box7,.box8").css("background-color","white");
    $(".chapter1,.chapter3,.chapter4,.chapter5,.chapter6,.chapter7,.chapter8").removeClass("selected");
  }
  set3()
  {
    $(".box3").css("background-color","green");
    $(".chapter3").addClass("selected");
    $(".box1,.box2,.box4,.box5,.box6,.box7,.box8").css("background-color","white");
    $(".chapter1,.chapter2,.chapter4,.chapter5,.chapter6,.chapter7,.chapter8").removeClass("selected");
  }
  set4()
  {
    $(".box4").css("background-color","green");
    $(".chapter4").addClass("selected");
    $(".box1,.box2,.box3,.box5,.box6,.box7,.box8").css("background-color","white");
    $(".chapter1,.chapter2,.chapter3,.chapter5,.chapter6,.chapter7,.chapter8").removeClass("selected");
  }
  set5()
  {
    $(".box5").css("background-color","green");
    $(".chapter5").addClass("selected");
    $(".box1,.box2,.box3,.box4,.box6,.box7,.box8").css("background-color","white");
    $(".chapter1,.chapter2,.chapter3,.chapter4,.chapter6,.chapter7,.chapter8").removeClass("selected");
  }
  set6()
  {
    $(".box6").css("background-color","green");
    $(".chapter6").addClass("selected");
    $(".box1,.box2,.box3,.box4,.box5,.box7,.box8").css("background-color","white");
    $(".chapter1,.chapter2,.chapter3,.chapter4,.chapter5,.chapter7,.chapter8").removeClass("selected");
  }
  set7()
  {
    $(".box7").css("background-color","green");
    $(".chapter7").addClass("selected");
    $(".box1,.box2,.box3,.box4,.box5,.box6,.box8").css("background-color","white");
    $(".chapter1,.chapter2,.chapter3,.chapter4,.chapter5,.chapter6,.chapter8").removeClass("selected");
  }
  set8()
  {
    $(".box8").css("background-color","green");
    $(".chapter8").addClass("selected");
    $(".box1,.box2,.box3,.box4,.box5,.box6,.box7").css("background-color","white");
    $(".chapter1,.chapter2,.chapter3,.chapter4,.chapter5,.chapter6,.chapter7").removeClass("selected");
  }

  openChapter(chapterid : string)
  {
    this.video = chapterid;
  }

  isScriptLoaded(target: string): boolean
  {
    return document.querySelector('script[src="' + target + '"]') ? true : false
  }

}
