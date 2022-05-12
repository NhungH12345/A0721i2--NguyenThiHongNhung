import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StudentDetailComponent } from './student-detail/student-detail.component';
import { StudentListComponent } from './student-list/student-list.component';
// @ts-ignore
import { ReactiveStudentComponent } from './reactive-student/reactive-student.component';

import {ReactiveFormsModule} from "@angular/forms";
import {RouterModule} from "@angular/router";
import { EditStudentComponent } from './edit-student/edit-student.component';
import {HttpClientModule} from "@angular/common/http";
// import {HttpClientModule} from '@angular/common/http';
// import { EditStudentComponent } from './edit-student/edit-student.component';

@NgModule({
  declarations: [
    AppComponent,
    StudentDetailComponent,
    StudentListComponent,
    ReactiveStudentComponent,
    EditStudentComponent,
    // HttpClientModule
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule,
    ReactiveFormsModule,
     HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
