import { Component } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { Store } from '@ngrx/store';

import { AppStore } from '../common/models/appstore.model';
import { Product } from '../common/models/product.model';
import { ProductsService } from '../common/service/products.service';

@Component({
  selector: 'product-features',
  templateUrl: './product-features.template.html'
})
export class ProductFeaturesComponent {
   products: Observable<Array<Product>>;

   constructor(public prodService: ProductsService,
              public store: Store<AppStore>) {
      this.products = prodService.products;
      prodService.loadProducts();
     // this.products.subscribe(v => console.log(v));
  }

}
