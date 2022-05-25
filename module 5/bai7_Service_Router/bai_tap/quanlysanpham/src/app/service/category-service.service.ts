import {Injectable} from '@angular/core';
import {Observable, Subscription} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {ICategory} from "../ICategory";
import {IProduct} from "../IProduct";

const API_URL = "http://localhost:3000";

@Injectable({
  providedIn: 'root'
})
export class CategoryServiceService {
  constructor(private _httpClient: HttpClient) {
  }

  getAll(): Observable<ICategory[]> {
    return this._httpClient.get<ICategory[]>(API_URL + '/category');

  }
  saveCategory(value: any): Observable<IProduct> {
    return this._httpClient.post<ICategory>(API_URL + '/category', value);
  }


  findById(id: string): Observable<ICategory> {
    return this._httpClient.get<ICategory>(API_URL + '/category' + '/' + id);
  }


  // saveCategory(category: any) {

}
