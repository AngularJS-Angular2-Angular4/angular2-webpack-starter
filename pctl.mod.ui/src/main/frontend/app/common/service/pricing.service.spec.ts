
// import {ProductsService} from '../service/products.service';
// import { inject,fakeAsync,TestBed} from '@angular/core/testing';
// import {Http, BaseRequestOptions, Response, BaseResponseOptions, ResponseOptions,RequestMethod,ConnectionBackend} from '@angular/http';
// import {MockBackend, MockConnection} from '@angular/http/testing';
// import {provide} from 'angular2/core';
  import { Observable } from 'rxjs/Rx';
  import { Observer } from 'rxjs/Observer';
// import { Pricing } from '../models/pricing.model';
// import { Store } from '@ngrx/store';
// import { AppStore } from '../models/appstore.model';
// import { User } from '../models/user.model';
// import { Product } from '../models/product.model';
// import {
//   describe, 
//   expect, 
//   it,
//   beforeEachProviders
// } from 'angular2/testing';

import {
  inject,
  TestBed,fakeAsync,tick
} from '@angular/core/testing';

import { Component } from '@angular/core';
import {
  BaseRequestOptions,
  ConnectionBackend,RequestMethod,
  Http,ResponseOptions,Response
} from '@angular/http';
import { MockBackend,MockConnection } from '@angular/http/testing';
// // Load the implementations that should be tested

import { Store } from '@ngrx/store';
import { AppStore } from '../models/appstore.model';
import { Pricing } from '../models/pricing.model';
 import {PricingService} from '../service/pricing.service';


describe('Price service', () => {
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
      PricingService
    ]}));

it('should send the price request to the server', (done) => {
  done();
});


});


// describe('httpServicecall', () => {
//   let store:Store<AppStore>;
//   beforeEach(() => TestBed.configureTestingModule({
//     providers: [
//       BaseRequestOptions,
//       MockBackend,
//       {
//         provide: Http,
//         useFactory: function(backend: ConnectionBackend, defaultOptions: BaseRequestOptions) {
//           return new Http(backend, defaultOptions);
//         },
//         deps: [MockBackend, BaseRequestOptions]
//       },
//       PricingService,Store
//     ]}));
// it('should use an HTTP call ', 
//     inject(
//       [store, MockBackend],
//       fakeAsync((service:PricingService, backend: MockBackend) => {
//         backend.connections.subscribe((connection: MockConnection) => {

//           expect(connection.request.method).toBe(RequestMethod.Get);
//           expect(connection.request.url).toBe(
//             'http://localhost:3001/pricesMS/');
//              expect(connection.request.headers.get('Content-Type')).toEqual('application/json');
//         });

//         service.loadPrices();
//       })));
// });

// describe('RequestService', () => {
//   let subject;

//   beforeEach(() => {
//     TestBed.configureTestingModule({
//       providers: [PricingService, Store]
//     });

//     spyOn(PricingService.prototype, 'getAuthToken').and.returnValue('secret_token');
//   });

//   beforeEach(inject([PricingService], (request) => {
//     subject = request;
//   }));

//   it('should return JSON headers', () => {
//     let result = subject.getJsonHeaders();

//     expect(result.get('Content-Type')).toEqual('application/json');
//   });
// });

// describe('UserServiceTest', () => {
//   let subject: PricingService = null;
//   let backend: MockBackend = null;

//   beforeEach(inject([PricingService, MockBackend], (userService: PricingService, mockBackend: MockBackend) => {
//     subject = userService;
//     backend = mockBackend;
//   }));



//   it('#login should call endpoint and return it\'s result', (done) => {
//     backend.connections.subscribe((connection: MockConnection) => {
//       let options = new ResponseOptions({
//         body: JSON.stringify({ success: true })
//       });
//       connection.mockRespond(new Response(options));
//     });

//     subject
//       .login({ username: 'admin', password: 'secret' })
//       .subscribe((response) => {
//         expect(response.json()).toEqual({ success: true });
//         done();
//       });
//   });
// });




// describe('Service: Search', () => {
//   beforeEach(() => {

//     TestBed.configureTestingModule({
//       providers: [
//         {
//           provide: Http, useFactory: (backend: ConnectionBackend, defaultOptions: BaseRequestOptions) => {
//           return new Http(backend, defaultOptions);
//         }, deps: [MockBackend, BaseRequestOptions]
//         },
//         {provide: PricingService, useClass: PricingService},
//         {provide: MockBackend, useClass: MockBackend},
//         {provide: BaseRequestOptions, useClass: BaseRequestOptions}
//       ]
//     });
//   });

//   it('should retrieve all search results',
//     inject([PricingService, MockBackend], fakeAsync((searchService: PricingService, mockBackend: MockBackend) => {
//       let res: Response;
//       mockBackend.connections.subscribe(c => {
//         expect(c.request.url).toBe('app/shared/search/data/people.json');
//         let response = new ResponseOptions({body: '[{"name": "John Elway"}, {"name": "Gary Kubiak"}]'});
//         c.mockRespond(new Response(response));
//       });
//       searchService.loadPrices().subscribe((response) => {
//         res = response;
//       });
//       tick();
//       expect(res[0].name).toBe('John Elway');
//     }))
//   );

  
  