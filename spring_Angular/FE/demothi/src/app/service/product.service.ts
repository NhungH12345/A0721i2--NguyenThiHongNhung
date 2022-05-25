import { Injectable } from '@angular/core';
import {IProduct} from "../model/IProduct";
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

const API_URL = "http://localhost:8080/product";

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  products: IProduct[] = [];

  constructor(private _httpClient:HttpClient) {
  }

  getAll(page: number): Observable<IProduct[]> {
    return this._httpClient.get<IProduct[]>(API_URL + '?_page=' + page + '&_limit=2');
  }

  save(value: IProduct): Observable<IProduct> {
    return this._httpClient.post<IProduct>(API_URL, value);
  }

  findById(id: string): Observable<IProduct> {
    return this._httpClient.get<IProduct>(API_URL + '/' + id);
  }

  update(id: string, product1: any): Observable<IProduct> {
    return this._httpClient.patch<IProduct>(API_URL + "/" + id, product1);
  }

  delete(id: number): Observable<IProduct> {
    return this._httpClient.delete<IProduct>(API_URL + '/' + id);
  }

  search(name: any): Observable<IProduct[]> {
    return this._httpClient.get<IProduct[]>(API_URL + '?name=' + name);
  }

  // /* sort */
  // sortPrice(sorted: boolean , page: number): Observable<IProduct[]> {
  //   if(sorted) {
  //     // return this._httpClient.get<IProduct[]>(API_URL + '?_sort=price&_order=asc');
  //     return this._httpClient.get<IProduct[]>(API_URL + '?' + '?_page=' + page + '&_limit=2&_sort=price&_order=asc');
  //   }
  //   return this._httpClient.get<IProduct[]>(API_URL + '?' + '?_page=' + page + '&_limit=2&_sort=price&_order=desc');
  // }
}
