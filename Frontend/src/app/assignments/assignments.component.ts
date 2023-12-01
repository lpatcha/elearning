import { Component } from '@angular/core';
import { MyServiceService } from '../my-service.service';
import { Assignment } from '../models/assignment';

@Component({
  selector: 'app-assignments',
  templateUrl: './assignments.component.html',
  styleUrls: ['./assignments.component.css']
})
export class AssignmentsComponent {

  assignment: Assignment = new Assignment();
  selectedFile: File | undefined;

  constructor(private assignmentService: MyServiceService) {}

  onSubmit() {
    if (this.selectedFile) {
      const formData = new FormData();
      formData.append('title', this.assignment.title);
      formData.append('description', this.assignment.description);
      formData.append('pdfFile', this.selectedFile);

      this.assignmentService.createAssignmentWithFileUpload(formData)
<<<<<<< Updated upstream
        .subscribe((result) => {
          // Handle the result, e.g., show a success message
=======
        .subscribe((result: any) => {
          if (result && result.message === 'success') {
            this.successMessage = 'Assignment created successfully';
            this.resetForm();
          } else {
            this.resetForm();
            this.successMessage = 'Assignment creation failed';
          }
>>>>>>> Stashed changes
        });
    }
  }

  onFileSelected(event: any) {
    this.selectedFile = event.target.files[0];
  }

}
