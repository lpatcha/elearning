<<<<<<< Updated upstream
// assignment-list.component.ts

import { Component, OnInit } from '@angular/core';
import { MyServiceService } from '../my-service.service';
import { Assignment } from '../models/assignment';
=======
import { Component, OnInit } from '@angular/core';
<<<<<<< Updated upstream
<<<<<<< Updated upstream
import { MyServiceService } from '../my-service.service';
import { Assignment } from '../models/assignment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { DomSanitizer, SafeResourceUrl } from '@angular/platform-browser';

>>>>>>> Stashed changes
=======
=======
>>>>>>> Stashed changes

import { DomSanitizer, SafeResourceUrl } from '@angular/platform-browser';
import { HttpClient, HttpHeaders } from '@angular/common/http';
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
<<<<<<< Updated upstream
  assignments: Assignment[] = [];
<<<<<<< Updated upstream

  constructor(private assignmentService: MyServiceService) {}

  ngOnInit() {
    this.assignmentService.getAllAssignments().subscribe((assignments) => {
      this.assignments = assignments;
  
      // Debugging: Log the pdfFilePath and pdfFileName for each assignment
      this.assignments.forEach(assignment => {
        console.log('PDF File Path:', assignment.pdfFilePath);
        console.log('PDF File Name:', assignment.pdfFileName);
      });
    });
  }

  downloadFile(pdfFilePath: string) {
    // Create a link element to trigger the download
    const link = document.createElement('a');
    link.href = pdfFilePath;
    link.target = '_blank';
    link.download = pdfFilePath.substring(pdfFilePath.lastIndexOf('/') + 1); // Extract the filename from the path
    link.click();
  }
  
=======
  pdfUrl: SafeResourceUrl = "";
  pdf: string = "";
  fileName: string = 'c91e8344-fd96-49db-a3c0-794416346bb3_Lab1 - part2-Fall2023.pdf';

  constructor(private assignmentService: MyServiceService, private http: HttpClient, private sanitizer: DomSanitizer) {
    this.pdfUrl = this.sanitizer.bypassSecurityTrustResourceUrl(
      `http://localhost:8080/files/download-pdf?fileName=${this.fileName}`
=======
=======
>>>>>>> Stashed changes
  pdfUrls: SafeResourceUrl[] = [];
  fileNames: any; // Dynamically set from the API
  courseId: any | null = null;
  constructor(private assignmentService: AssignmentService, private sanitizer: DomSanitizer, private http: HttpClient,private route: ActivatedRoute,public dialog: MatDialog,private toastr:ToastrService) {}
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

  // loadPdfs() {
  //   // Iterate through the file names and load the corresponding PDFs
  //   this.fileNames.forEach((fileName) => {
  //     this.http
  //       .get(`http://localhost:8080/files/download-pdf?fileName=${fileName}`, { responseType: 'arraybuffer' })
  //       .subscribe(
  //         (response: ArrayBuffer) => {
  //           const blob = new Blob([response], { type: 'application/pdf' });
  //           const blobUrl = window.URL.createObjectURL(blob);
  //           const pdfUrl = this.sanitizer.bypassSecurityTrustResourceUrl(blobUrl);
  //           console.log(pdfUrl)
  //           this.pdfUrls.push(pdfUrl);
  //         },
  //         (error) => {
  //           console.error('API error:', error);
  //         }
  //       );
  //   });
  // }
  openAssignments(): void {
    this.dialog.open(AssignmentsComponent, {
      
      width: '400px',
      height:'400px'
    });
  }

  download(filename:string){
    this.assignmentService.getdownload(filename).subscribe((response:ArrayBuffer)=>
    {
      this.handleFileDownload(response,filename);
       console.log("successfullydownloaded")
    })
  }
 handleFileDownload(data: ArrayBuffer,filename:string) {
    const blob = new Blob([data], { type: 'application/octet-stream' });

    // Create a URL for the Blob
    const url = window.URL.createObjectURL(blob);

    // Create a link element and click on it to trigger the download
    const a = document.createElement('a');
    a.href = url;
    a.download = filename; // Set the desired filename
    document.body.appendChild(a);
    a.click();

    // Clean up: remove the link and revoke the URL
    document.body.removeChild(a);
    window.URL.revokeObjectURL(url);
  }
  dateRenderer(params: any) {
    const epochTime = params;
    const date = new Date(epochTime);
    const day = date.getDate();
    const month = date.getMonth() + 1; // Months are 0-based, so add 1
    const year = date.getFullYear();
  
    // Format the date as "dd/mm/yyyy"
    const formattedDate = `${day}/${month}/${year}`;
    return formattedDate;
  }
}
