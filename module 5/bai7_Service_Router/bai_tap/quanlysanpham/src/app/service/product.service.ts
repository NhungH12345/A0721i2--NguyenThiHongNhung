import {Injectable} from '@angular/core';
import {IProduct} from "../IProduct";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

const
  API_URL = "http://localhost:3000";

@Injectable({
  providedIn: 'root'
})
export class ProductServiceService {
  products: IProduct[] = [];

  constructor(private _httpClient: HttpClient) {
  }

  getAll(): Observable<IProduct[]> {
    return this._httpClient.get<IProduct[]>(API_URL + '/product');
  }

  save(value: any): Observable<IProduct> {
    return this._httpClient.post<IProduct>(API_URL + '/product', value);
  }

  findById(id: string): Observable<IProduct> {
    return this._httpClient.get<IProduct>(API_URL + '/product' + '/' + id);
  }

  update(id: string, product1: any): Observable<IProduct> {
    return this._httpClient.put<IProduct>(API_URL + '/product' + '/' + id, product1);
  }

  delete(id: number): Observable<IProduct> {
    return this._httpClient.delete<IProduct>(API_URL + '/product/' + id);
  }
  searchByName(name: string): Observable<IProduct> {
    // @ts-ignore
    return this._httpClient.get<IProduct>(API_URL + '/product' + '/' + name);
  }

}
