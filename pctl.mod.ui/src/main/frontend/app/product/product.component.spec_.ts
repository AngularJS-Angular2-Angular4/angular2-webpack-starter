import {
  inject,
  TestBed
} from '@angular/core/testing';
import { Component } from '@angular/core';
import {
  BaseRequestOptions,
  ConnectionBackend,
  Http
} from '@angular/http';
import { MockBackend } from '@angular/http/testing';

// Load the implementations that should be tested
import { ProductDescriptionComponent } from './product-desc.component';
import { ProductDetailsComponent } from './product-details.component';
import { ProductFeaturesComponent } from './product-features.component';
import { ProductPricingComponent } from './product-pricing.component';
import { ProductTermSelectionComponent } from './product-term-selection.component';

describe('Products', () => {
  // provide our implementations or mocks to the dependency injector
  beforeEach(() => TestBed.configureTestingModule({
    providers: [
      BaseRequestOptions,
      MockBackend,
      {
        provide: Http,
        useFactory: function(backend: ConnectionBackend, defaultOptions: BaseRequestOptions) {
          return new Http(backend, defaultOptions);
        },
        deps: [MockBackend, BaseRequestOptions]
      },
      ProductDescriptionComponent,
      ProductDetailsComponent,
      ProductFeaturesComponent,
      ProductPricingComponent,
      ProductTermSelectionComponent
    ]
  }));

  it('should have default data: ProductDescription', inject([ ProductDescriptionComponent ], (productDescription: ProductDescriptionComponent) => {
    expect(productDescription.product).toEqual(!null);//{ value: '' });
  }));

  it('should have ProductDetails', inject([ ProductDetailsComponent ], (productDetails: ProductDetailsComponent) => {
    spyOn(console, 'log');
    expect(console.log).not.toHaveBeenCalled();
    expect(productDetails.product).toEqual(!null);//{ value: '' });

  /*it('should have a title', inject([ HomeComponent ], (home: HomeComponent) => {
    expect(!!home.title).toEqual(true);
  })); */

    //productDetails.ngOnInit();
    //expect(console.log).toHaveBeenCalled();
  }));

});
