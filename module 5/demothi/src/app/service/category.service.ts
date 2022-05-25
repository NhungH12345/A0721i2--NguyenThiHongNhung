import {Injectable} from '@angular/core';
import {Observable, Subscription} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {IProduct} from "../model/IProduct";
import {ICategory} from "../model/ICategory";


const API_URL = "http://localhost:3000/category";

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  constructor(private _httpClient: HttpClient) {
  }

  getAll(): Observable<ICategory[]> {
    return this._httpClient.get<ICategory[]>(API_URL + '/');

  }
  saveCategory(value: any): Observable<ICategory> {
    return this._httpClient.post<ICategory>(API_URL + '/', value);
  }


  findById(id: string): Observable<ICategory> {
    return this._httpClient.get<ICategory>(API_URL + '/' + '/' + id);
  }


  // saveCategory(category: any) {

}
