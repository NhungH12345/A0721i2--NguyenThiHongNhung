import { Injectable } from '@angular/core';
import {IStudent} from "../app/models/IStudent";
import {StudentDAO} from "../app/dao/StudentDAO";
import {HttpClient} from "@angular/common/http";
// @ts-ignore
import {Observable} from 'rxjs/dist/types';
// import {HttpClient} from "@angular/common/http";
// import {environment} from "../environments/environment";
// const API_URL = `${environment.apiUrl}`;
@Injectable({
  providedIn: 'root'
})
export class StudentService {
  readonly URL_API = "http://localhost:3000/students"


  constructor(private httpClient: HttpClient) {
  }
  getAllStudent(): Observable<IStudent[]>{
    return this.httpClient.get<IStudent[]>(this.URL_API);
  }

  addNewStudent(student:IStudent): Observable<any>{
    return this.httpClient.post(this.URL_API, student);
  }

  findStudentById(id: number):IStudent {
    return <IStudent>StudentDAO.studentDao.find((student) => student.id == id);
  }
}
