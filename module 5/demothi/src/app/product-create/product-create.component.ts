import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {ProductService} from "../service/product.service";
import {Router} from "@angular/router";
import {Subscription} from "rxjs";
import {CategoryService} from "../service/category.service";
import {ICategory} from "../model/ICategory";

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {
  private subscription: Subscription = new Subscription;
  // @ts-ignore
  formCreateProduct: FormGroup;
  category: ICategory[] = [];

  constructor(
    private _service: ProductService,
    private _router: Router,
    private _serviceCategory: CategoryService
  ) {
  }

  ngOnInit(): void {
    this._serviceCategory.getAll().subscribe(data => {
      this.category = data;
      console.log(data);
    }, error => {
      console.log("errors");
    })
    this.formCreateProduct = new FormGroup(
      {
        name: new FormControl('', [Validators.required]),
        price: new FormControl('', [Validators.required, Validators.min(0)]),
        description: new FormControl('', [Validators.required]),
        category: new FormControl('')
      }
    )
  }

  save() {
    this._service.save(this.formCreateProduct.value).subscribe(() => {
        this._router.navigateByUrl('/product');
      },
    );
  }
}
