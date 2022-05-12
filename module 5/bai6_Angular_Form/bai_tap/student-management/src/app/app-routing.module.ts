import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {StudentListComponent} from "./student-list/student-list.component";
import {ReactiveStudentComponent} from "./reactive-student/reactive-student.component";
import {StudentDetailComponent} from "./student-detail/student-detail.component";


const routes: Routes = [{
  path :"home", component :StudentListComponent},
{path:"create",component :ReactiveStudentComponent},
{path:"detail/:id",component : StudentDetailComponent},
// {path:"edit/:id",component : EditStudentComponent}
 ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
