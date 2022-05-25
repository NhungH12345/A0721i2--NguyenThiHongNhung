import { Component, OnInit } from '@angular/core';
import {IProduct} from "../model/IProduct";
import {Subscription} from 'rxjs';
import {ProductService} from "../service/product.service";
import {CategoryService} from "../service/category.service";
import {ICategory} from "../model/ICategory";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  /* pagination */
  page = 1;

  private subscription: Subscription|undefined;
  products: any =[];
  // @ts-ignore
  categorys: ICategory[]=[];

  /* Form search properties */
  // @ts-ignore
  formSearch: FormGroup;
  // @ts-ignore
  productsSearch: IProduct[];

  // /* check sort */
  // sorted = true;

  constructor(
    private _service : ProductService,
    private _CategoryService: CategoryService
  ) { }

  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    this._service.getAll(this.page).subscribe(productData => {
    // this._service.getAll().subscribe(productData => {
      this.products = productData;
    }, error => {
      console.log("ERRORS");
    });

    this._CategoryService.getAll().subscribe(categoryData=>{
      this.categorys = categoryData;
    }, error => {
      console.log("ERRORS");
    });
  }

  /* search */
  search() {
    // @ts-ignore
    const pSearch = this.formSearch.get('nameSearch').value;
    this._service.search(pSearch).subscribe(data=> {
      this.productsSearch = data;
    })
  }

  // sortPrice() {
  //   this.sorted = !this.sorted;
  //   console.log(this.sorted);
  //   this._service.sortPrice(this.sorted , this.page).subscribe(data=> {
  //     this.products = data;
  //   })
  // }
  //
  // /* pagination */
  prev() {
    this.page -= 1;
    this.getAll();
  }

  next() {
    this.page += 1;
    this.getAll();
  }

}
