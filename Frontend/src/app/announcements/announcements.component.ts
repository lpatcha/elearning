import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
<<<<<<< Updated upstream
=======
import { ActivatedRoute } from '@angular/router';
import { data } from 'jquery';
>>>>>>> Stashed changes

@Component({
  selector: 'app-announcements',
  templateUrl: './announcements.component.html',
  styleUrls: ['./announcements.component.css']
})
export class AnnouncementsComponent {


  announcement: any = {};

<<<<<<< Updated upstream
  constructor(private http: HttpClient, private dialogRef:MatDialogRef<AnnouncementsComponent>) {}
=======
  constructor(private http: HttpClient,  private activatedRoute: ActivatedRoute,private dialogRef:MatDialogRef<AnnouncementsComponent>) {}

  ngOnInit(): void {
    this.professorName = JSON.stringify(sessionStorage.getItem('loggedUser')|| '{}');
    this.professorName = this.professorName.replace(/"/g, '');

    this.currRole = JSON.stringify(sessionStorage.getItem('ROLE')|| '{}'); 
    this.currRole = this.currRole.replace(/"/g, '');

    //this.courseName = this.activatedRoute.snapshot.params['coursename'];
    //this.courseName = this.activatedRoute.snapshot.paramMap.get('coursename') || 'DefaultCourseName';
    this.announcement.courseName = sessionStorage.getItem('course');
    
    this.announcement.professorName = this.professorName;
  }
>>>>>>> Stashed changes
  closeDialog(): void {
    this.dialogRef.close();
  }
  submitForm() {
    console.log(this.announcement);
<<<<<<< Updated upstream
    this.http.post('http://localhost:8080/announcements', this.announcement).subscribe(
=======
    
    this.http.post('http://localhost:8080/announcements/add', this.announcement).subscribe(
>>>>>>> Stashed changes
      (response) => {
        console.log('Announcement submitted:', response);
        // Reset the form
        this.announcement = {};
      },
      (error) => {
        console.error('Error submitting announcement:', error);
      }
    );
  }
}
