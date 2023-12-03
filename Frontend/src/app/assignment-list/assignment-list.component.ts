import { Component, OnInit } from '@angular/core';
import { MyServiceService } from '../my-service.service';
import { Assignment } from '../models/assignment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
<<<<<<< Updated upstream
import { DomSanitizer, SafeResourceUrl } from '@angular/platform-browser';

=======
import { ActivatedRoute } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { ToastrService } from 'ngx-toastr';
import { AssignmentsComponent } from '../assignments/assignments.component';
import { AssignmentService } from '../assignment.service';
>>>>>>> Stashed changes
@Component({
  selector: 'app-assignment-list',
  templateUrl: './assignment-list.component.html',
  styleUrls: ['./assignment-list.component.css']
})
export class AssignmentListComponent implements OnInit {
<<<<<<< Updated upstream
  assignments: Assignment[] = [];
  pdfUrl: SafeResourceUrl = "";
  pdf: string = "";
  fileName: string = 'c91e8344-fd96-49db-a3c0-794416346bb3_Lab1 - part2-Fall2023.pdf';

  constructor(private assignmentService: MyServiceService, private http: HttpClient, private sanitizer: DomSanitizer) {
    this.pdfUrl = this.sanitizer.bypassSecurityTrustResourceUrl(
      `http://localhost:8080/files/download-pdf?fileName=${this.fileName}`
=======
  pdfUrls: SafeResourceUrl[] = [];
  fileNames: any; // Dynamically set from the API
  courseId: any | null = null;
  constructor(private assignmentService: AssignmentService, private sanitizer: DomSanitizer, private http: HttpClient,private route: ActivatedRoute,private myServiceService : MyServiceService,public dialog: MatDialog,private toastr:ToastrService) {}
  ngOnInit() {
    //const courseId = '20'; // Replace with the actual course ID
    this.route.params.subscribe(params => {
      this.courseId = params['coursename'];
    });
    const courseIdString = sessionStorage.getItem('course');
    this.courseId = courseIdString ? +courseIdString : null;
    // Fetch the file names from the API
    // this.assignmentService.getFileNamesByCourseId(this.courseId).subscribe(
    //   (fileNames: string[]) => {
    //     // Set the file names
    //     this.fileNames = fileNames;
    //     // Load PDFs based on the file names
    //     this.loadPdfs();
    //   },
    //   (error) => {
    //     console.error('API error:', error);
    //   }
    // );
    this.assignmentService.getFileNamesByCourseId(this.courseId).subscribe(
      (fileNames) => {
        // Set the file names
        this.fileNames = fileNames;
        for (let obj of this.fileNames) {
          obj.deadlinedate=this.dateRenderer(obj.deadlinedate);
        }
        // Load PDFs based on the file names
        // this.loadPdfs();
      },
      (error) => {
        console.error('API error:', error);
      }
>>>>>>> Stashed changes
    );
  }

  ngOnInit() {
    // Send the HTTP request in the ngOnInit lifecycle hook
    this.http
      .get(`http://localhost:8080/files/download-pdf?fileName=${this.fileName}` , { responseType: 'arraybuffer' }) // Specify 'arraybuffer' as the response type
      .subscribe(
        (response: ArrayBuffer) => {
          // Create a Blob from the array buffer
          const blob = new Blob([response], { type: 'application/pdf' });

          // Create a URL for the blob data
          const blobUrl = window.URL.createObjectURL(blob);
          
          // Sanitize the URL to make it safe for use in the template
          this.pdfUrl = this.sanitizer.bypassSecurityTrustResourceUrl(blobUrl);
        },
        (error) => {
          // Handle any errors here
          console.error('API error:', error);
        }
      );
  }
}
