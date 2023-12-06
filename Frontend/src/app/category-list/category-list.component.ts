import { Component, EventEmitter, Input, Output } from '@angular/core';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
<<<<<<< Updated upstream
<<<<<<< Updated upstream
=======
=======
>>>>>>> Stashed changes

import { HttpClient } from '@angular/common/http';
import { ToastrService } from 'ngx-toastr';
>>>>>>> Stashed changes

@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrls: ['./category-list.component.css']
})
export class CategoryListComponent {

  //  @Input() categories!: any[];
  // @Output() addCategory = new EventEmitter<string>();

  // onAddCategory(categoryName: string) {
  //   this.addCategory.emit(categoryName);
  // }
  // @Input() categories!: any[];
  // @Output() addCategory = new EventEmitter<{ categoryName: string, parentCategory: string }>();

  // isAddingSubcategory: boolean = false;
  // newSubcategoryName: string = '';

  // toggleInputBox() {
  //   this.isAddingSubcategory = !this.isAddingSubcategory;
  //   this.newSubcategoryName = '';
  // }

  // onSaveSubcategory(categoryName: string) {
  //   this.addCategory.emit({ categoryName, parentCategory: this.newSubcategoryName });
  //   this.toggleInputBox();
  // }

  // onAddCategory(categoryName: string) {
  //   this.toggleInputBox(); // Call toggleInputBox when clicking the "+" button
  // }
<<<<<<< Updated upstream
<<<<<<< Updated upstream
=======
=======
>>>>>>> Stashed changes
  constructor(private http: HttpClient,private cdr: ChangeDetectorRef,private toastr:ToastrService){};
>>>>>>> Stashed changes
  @Input() categories!: any[];
@Output() addCategory = new EventEmitter<{ categoryName: string, parentCategory: string }>();

isAddingSubcategory: boolean = false;
newSubcategoryName: string = '';
parentname: string = '';
toggleInputBox() {
  this.isAddingSubcategory = !this.isAddingSubcategory;
  this.newSubcategoryName = '';
}

onSaveSubcategory(categoryName: string) {
  this.addCategory.emit({ categoryName, parentCategory: this.parentname });
  this.toggleInputBox();
}

onAddCategory(categoryName: string) {
  this.parentname=categoryName;
  this.toggleInputBox(); 
}

onAddCategoryInChild(eventData: { categoryName: string, parentCategory: string }) {
  this.addCategory.emit(eventData); 
}

}
