<<<<<<< Updated upstream
// assignment-list.component.ts

import { Component, OnInit } from '@angular/core';
import { MyServiceService } from '../my-service.service';
import { Assignment } from '../models/assignment';
=======
import { Component, OnInit } from '@angular/core';
import { MyServiceService } from '../my-service.service';
import { Assignment } from '../models/assignment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { DomSanitizer, SafeResourceUrl } from '@angular/platform-browser';

>>>>>>> Stashed changes
@Component({
  selector: 'app-assignment-list',
  templateUrl: './assignment-list.component.html',
  styleUrls: ['./assignment-list.component.css']
})
export class AssignmentListComponent implements OnInit {
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
>>>>>>> Stashed changes
}
