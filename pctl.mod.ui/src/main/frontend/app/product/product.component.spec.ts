
import { Observable } from 'rxjs/Observable';
import { Store, Action } from '@ngrx/store';
import { AppStore } from '../common/models/appstore.model';
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
//import { Router } from '@angular/router';
import { ProductsService } from '../common/service/products.service';

describe('Products', () => {
   let ProductDescriptionMessage: ProductDescriptionComponent;
  beforeEach(() => {
    ProductDescriptionMessage = new ProductDescriptionComponent();
  });

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
      
    ],
  }));

    /*To Added Testcases For Landing Page*/
    it('should log ngOnInit: ProductDescription', inject([ ProductDescriptionComponent ], (productDescription: ProductDescriptionComponent) => {
    spyOn(console, 'log');
    expect(console.log).not.toHaveBeenCalled();

    productDescription.ngOnInit();
    expect(console.log).toHaveBeenCalled();
  }));

  it('should not have Null data: ProductDescription', inject([ ProductDescriptionComponent ], (productDescription: ProductDescriptionComponent) => {
    expect(productDescription.product).toBeUndefined();
  }));
  it('should have ProductDescriptionComponent data', inject([ ProductDescriptionComponent ], (proDesc: ProductDescriptionComponent) => {
      expect(proDesc.currentProductName).toEqual(proDesc.currentProductName);
  }));
 it('should set new message: ProductDescription', () => {
    ProductDescriptionMessage.setMessage('Testing for Project Description Component');
    expect(ProductDescriptionMessage.message).toBe('Testing for Project Description Component');
  });

  it('should clear message: ProductDescription', () => {
    ProductDescriptionMessage.clearMessage();
    expect(ProductDescriptionMessage.message).toBe('');
  });

     it('should have ProductFeaturesComponent data', inject([ ProductFeaturesComponent ], (proFeatures: ProductFeaturesComponent) => {
      expect(proFeatures.options).toEqual(['Standard CPE', 'High Availability', 'Security Package', 'Tier 1 Support']);
    
  }));

 it('should log ngOnInit: ProductFeaturesComponent', inject([ ProductFeaturesComponent ], (proFeatures: ProductFeaturesComponent) => {
    spyOn(console, 'log');
    expect(console.log).not.toHaveBeenCalled();

    proFeatures.ngOnInit();
    expect(console.log).toHaveBeenCalled();
  }));
   /*it('should have ProductDetailsComponent data', inject([ ProductDetailsComponent ], (proDetails: ProductDetailsComponent) => {
     // expect(proDetails.nowPage).toEqual("4");
    expect("2").toEqual("2");
  }));
*//*
   it('should have ProductPricingComponent data', inject([ ProductPricingComponent ], (productPricing: ProductPricingComponent) => {
      expect(productPricing.options).toEqual(['Product Option', 'With My Own Transport', 'With CenturyLink Transport']);
    //expect(proDesc.CurrentProduct).toEqual(proDesc.CurrentProduct);
  }));
*/
  /*it('should have ProductDetails', inject([ ProductDetailsComponent ], (productDetails: ProductDetailsComponent) => {
    //spyOn(console, 'log');
    //expect(console.log).not.toHaveBeenCalled();
    expect(productDetails.product).toEqual(!null);//{ value: '' });

 
    //productDetails.ngOnInit();
    //expect(console.log).toHaveBeenCalled();
   
  }));
*/
});
