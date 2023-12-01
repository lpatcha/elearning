import { ChangeDetectorRef, Component, EventEmitter, Input, Output } from '@angular/core';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MyServiceService } from '../my-service.service';
import { HttpClient } from '@angular/common/http';

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
  constructor(private myService: MyServiceService,private http: HttpClient,private cdr: ChangeDetectorRef){};
  @Input() categories!: any[];
@Output() addCategory = new EventEmitter<{ categoryName: string, parentCategory: string }>();
@Output() updateCategory = new EventEmitter<{ categoryid: string, Categoryname: string }>();
isAddingSubcategory: boolean = false;
isupdateSubcategory: boolean = false;
newSubcategoryName: string = '';
parentname: string = '';
updateName:string='';
updateId:string='';
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
updatecategory(id:any,name:any){
  this.isupdateSubcategory=true;
  this.updateName=name;
  this.updateId=id;
}
onUpdateCategory(name:any){
  console.log(name);

  this.updateCategory.emit({ categoryid:this.updateId, Categoryname: name });
  console.log("hu");
  // this.myService.updateCategory(this.updateId,name).subscribe((response)=>
  // {
  //      console.log("successfully updated");

  //     //  this.fetchCategoriesWithSubcategories();
  // },
  // )
  this.updateName='';
  this.isupdateSubcategory=false;
  this.updateId="";

// }

}
onUpdateCategorySubcategory(eventData: { categoryid: string, Categoryname: string }){

  this.updateCategory.emit(eventData);

}
}
