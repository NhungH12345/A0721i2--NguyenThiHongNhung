import {Component, OnInit} from '@angular/core';
import {IStudent} from "../models/IStudent";
import {StudentDAO} from "../dao/StudentDAO";
import {StudentService} from "../../service/student.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {
  students: IStudent[] | undefined;
  studentDetail: IStudent | undefined;

  constructor(private studentService : StudentService,
              private router : Router) {

  }

  ngOnInit(): void {
    this.studentService.getAllStudent().subscribe(data => {this.students=data})
  }

}
