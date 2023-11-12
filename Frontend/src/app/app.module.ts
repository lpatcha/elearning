import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'; 
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegistrationComponent } from './registration/registration.component';
import { CreateAdminComponent } from './create-admin/create-admin.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { ExcelUploadComponent } from './excel-upload/excel-upload.component';
import { AgGridModule } from 'ag-grid-angular';
import { CarouselModule } from 'ngx-owl-carousel-o';
import { LoginComponent } from './login/login.component';
import { AdminComponent } from './admin/admin.component';
import { ActionCellRendererComponent } from './action-cell-renderer/action-cell-renderer.component';
import { UsernameLinkRendererComponent } from './username-link-renderer/username-link-renderer.component';
import { ButtonRendererComponent } from './button-renderer/button-renderer.component';
import { UserDetailsComponent } from './user-details/user-details.component';
import { TableComponent } from './table/table.component';
import { MatCardModule } from '@angular/material/card';
import { MatNativeDateModule } from '@angular/material/core';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { AdminNavHeaderComponent } from './admin-nav-header/admin-nav-header.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HeaderComponent } from './header/header.component';
import { CategoryListComponent } from './category-list/category-list.component';
import { CategoryCreateComponent } from './category-create/category-create.component';
import { ToastrModule } from 'ngx-toastr';
<<<<<<< Updated upstream

import { timeout } from 'rxjs';

=======
>>>>>>> Stashed changes
import { TeacherdashboardComponent } from './teacherdashboard/teacherdashboard.component';
import { AdduserComponent } from './adduser/adduser.component';
import { AddcourseComponent } from './addcourse/addcourse.component';
import { CoursestableComponent } from './coursestable/coursestable.component';
import { ApprovecourseComponent } from './approvecourse/approvecourse.component';
import { CourseListComponent } from './course-list/course-list.component';
<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
import { AllCoursesComponent } from './all-courses/all-courses.component';
import { CourseModulesComponent } from './course-modules/course-modules.component';
import { CourseContentComponent } from './course-content/course-content.component';




@NgModule({
  declarations: [
    AppComponent,
    RegistrationComponent,
    CreateAdminComponent,
    ExcelUploadComponent,
    LoginComponent,
    AdminComponent,
    ActionCellRendererComponent,
    UsernameLinkRendererComponent,
    ButtonRendererComponent,
    
    UserDetailsComponent,
    TableComponent,
    AdminNavHeaderComponent,
    HeaderComponent,
    CategoryListComponent,
    CategoryCreateComponent,
    TeacherdashboardComponent,
    AdduserComponent,
    AddcourseComponent,
    CoursestableComponent,
    ApprovecourseComponent,
    CourseListComponent,
    AllCoursesComponent,
    CourseModulesComponent,
    CourseContentComponent
  
<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
  ],

  

  imports: [
    ReactiveFormsModule,
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatInputModule,
    MatButtonModule,
    MatFormFieldModule,
    AgGridModule,
    MatCardModule,
    CarouselModule,
<<<<<<< Updated upstream
=======
    YouTubePlayerModule,
>>>>>>> Stashed changes
    ToastrModule.forRoot({
      timeOut: 15000,
      extendedTimeOut: 3000,
      positionClass: 'toast-top-right',
      progressBar: true,
      progressAnimation : 'decreasing',
      closeButton: true,

    }

    ),  
    MatDatepickerModule,
    MatNativeDateModule,
    NgbModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
