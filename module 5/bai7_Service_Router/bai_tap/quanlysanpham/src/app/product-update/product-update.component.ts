import { Component, OnInit } from '@angular/core';
import {ProductServiceService} from "../service/product.service";
import {IProduct} from "../IProduct";
import {ActivatedRoute, Router} from "@angular/router";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Subscription} from "rxjs";
import {CategoryServiceService} from "../service/category-service.service";
import {ICategory} from "../ICategory";

@Component({
  selector: 'app-product-update',
  templateUrl: './product-update.component.html',
  styleUrls: ['./product-update.component.css']
})
export class ProductUpdateComponent implements OnInit {

  private subscription: Subscription |undefined;
  formCreateProduct!: IProduct;
  formCreateProduct1!:FormGroup;
  category:ICategory[] = [];

  constructor(
    private _service:ProductServiceService,
    private _activated: ActivatedRoute,
    private _router:Router,
    private _serviceCategory:CategoryServiceService
  ) { }

  ngOnInit(): void {
    let id = this._activated.snapshot.params['id'];

    this.subscription = this._service.findById(id).subscribe(data =>{
      this.formCreateProduct = data;
    },error => {
      console.log("errors");
      }
      );

    this.subscription = this._serviceCategory.getAll().subscribe(data=>{
      this.category = data;
    }, error => {
      console.log("errors");
    })

    this.formCreateProduct1 = new FormGroup(
      {
        id: new FormControl('',[Validators.required]),
        name: new FormControl('',[Validators.required]),
        price: new FormControl('',[Validators.required, Validators.min(0)] ),
        description: new FormControl('', [Validators.required]),
        category: new FormControl('')
      }
    )
  }

  update() {
    this._service.update(this.formCreateProduct1.value.id, this.formCreateProduct1.value).subscribe(()=>{
        this._router.navigateByUrl('/product');
      },
      error => {console.log("errors");}
      );
  }
}
