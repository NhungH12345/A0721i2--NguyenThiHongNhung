import { Component, OnInit } from '@angular/core';
import {Subscription} from 'rxjs';
import {IProduct} from '../model/IProduct';
import {ActivatedRoute, Router} from '@angular/router';
import {ProductService} from '../service/product.service';

@Component({
  selector: 'app-product-delete',
  templateUrl: './product-delete.component.html',
  styleUrls: ['./product-delete.component.css']
})
export class ProductDeleteComponent implements OnInit {
  // @ts-ignore
  products:IProduct;

  constructor(
    private _router: Router,
    private _activated: ActivatedRoute,
    private _service: ProductService
  ) { }

  ngOnInit(): void {
    let id =this._activated.snapshot.params['id'];
    this._service.findById(id).subscribe(data =>{
      this.products = data;
    })
  }
  close() {
    this._router.navigateByUrl('product');
  }
  delete(){
    // @ts-ignore
    this._service.delete(this.products.id).subscribe(()=>{
      alert("Xóa thành công"+this.products.name);
      this._router.navigateByUrl('product');
    })
  }

}
