export class Assignment {
  id: number; // You may have an ID property if assignments have unique identifiers
  title: string;
  description: string;
  pdfFilePath: string;
  pdfFileName: string; // Include this property if you want to display the file name in the UI
<<<<<<< Updated upstream

=======
  marks:string;
  weightage:string;
  deadlinedate:string;
>>>>>>> Stashed changes
  constructor() {
    this.id = 0;
    this.title = '';
    this.description = '';
    this.pdfFilePath = '';
    this.pdfFileName = '';
<<<<<<< Updated upstream
=======
    this.marks='';
    this.weightage='';
    this.deadlinedate='';
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
  }
>>>>>>> Stashed changes
  }
  }
  