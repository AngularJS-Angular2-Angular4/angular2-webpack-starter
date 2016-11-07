import {  inject,TestBed } from '@angular/core/testing';
import { Http, BaseRequestOptions,ConnectionBackend ,RequestOptions} from '@angular/http';
import { MockBackend } from '@angular/http/testing';
import { CartService } from '../service/cart.service';
import {  Response, ResponseOptions, RequestMethod } from '@angular/http';
import { MockConnection } from '@angular/http/testing';
import { ShoppingCart, LineItem, SDWANLocationInfo, LocationInfo } from '../models/cart.model';
import { Store } from '@ngrx/store';
import { AppStore } from '../models/appstore.model';
import { Observable } from 'rxjs/Rx';
import { Observer } from 'rxjs/Observer';

describe('Cart service', () => {
     let subject;
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
      CartService
    ]}));

it('should send the cart request to the server', (done) => {
  done();
  });
});

// describe('UserServiceTest', () => {
//   let subject: CartService = null;
//   let backend: MockBackend = null;

//   beforeEach(inject([CartService, MockBackend], (userService: CartService, mockBackend: MockBackend) => {
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
//   //     .addLocation({productTemplateId: '10';
//   //   location: [{
//   //         id: '',
//   //   serviceContact: {



//   //   }
//   //   serviceAddress: {



//   //   }
//   //   shippingAddress: {


      
//   //   }



//   //   }]
//   // })
//       .subscribe((response) => {
//         expect(response.json()).toEqual({ success: true });
//         done();
//       });
//   });
// });