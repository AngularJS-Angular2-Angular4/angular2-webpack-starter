import {  inject,TestBed } from '@angular/core/testing';
import { Http, BaseRequestOptions,ConnectionBackend } from '@angular/http';
import { MockBackend } from '@angular/http/testing';
import { ProductsService } from '../service/products.service';
import {  Response, ResponseOptions, RequestMethod } from '@angular/http';
import { MockConnection } from '@angular/http/testing';
describe('Product service', () => {
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
      ProductsService
    ]}));

it('should send the product request to the server', (done) => {
  done();
});
});