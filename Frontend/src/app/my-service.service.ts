import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

<<<<<<< Updated upstream
import { Course } from './models/course';

=======
>>>>>>> Stashed changes
@Injectable({
  providedIn: 'root'
})
export class MyServiceService {

  constructor(private router: Router,private http: HttpClient) { }

  private baseUrl = 'http://localhost:8080';
  addCategory(category: any): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}/category`, category);
  }

  addSubcategory(parentCategoryId: any, subcategory: any): Observable<any> {
    const url = `${this.baseUrl}/category/${parentCategoryId}/subcategories`;
    return this.http.post<any>(url, subcategory);
    
  }
  getAllCategoriesWithSubcategories(): Observable<any[]> {
    const url = `${this.baseUrl}/category/getcategories`;
    return this.http.get<any[]>(url);
  }

  addCourse(course : Course) : Observable<any>
  {
    return this.http.post<any>(`${this.baseUrl}/addCourse`,course);
  }
<<<<<<< Updated upstream
|
=======
>>>>>>> Stashed changes
  getCourse() : Observable<any>
  {
    return this.http.get<any>(`${this.baseUrl}/getcourses`);
  }
  enablecourse(id:any):Observable<any>{
    return this.http.put((`${this.baseUrl}/enablecourse/${id}`),null);
  }
  addcategory(category:any):Observable<any>{
      return this.http.post<any>(`${this.baseUrl}/category/addcategory`,category);
  }

<<<<<<< Updated upstream
=======
  getCoursesByEmail(loggedUser : string) : Observable<any>
  {
    return this.http.get<any>(`${this.baseUrl}/getcoursebyemail/`+loggedUser);
  }
  
  
>>>>>>> Stashed changes
}
