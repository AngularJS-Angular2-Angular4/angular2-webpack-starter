import {
  inject,
  TestBed
} from '@angular/core/testing';

import { ActionReducer, Action } from '@ngrx/store';
import { Product } from '../models/product.model';
import { pricesReducer } from './prices.reducer';

describe ('The price reducer', () => {
    beforeEach(() => TestBed.configureTestingModule({

    }));

    it('should return current state when no valid actions have been made', ()  => {
        const state = {
       "variantId":"string",
       "productId":"string",
       "name":"string",
       "sku" :"string",
       "descriptionHtml":"string",
       "displayImage" :"string",
       "displayPosition": 0,
       "servicePlan" :"string" ,
       "serviceVendor":"string",
       "serviceTransport":"string",
       "securityPkg":"string",
       "standardCpe" :"string",
       "haServicePlan":"string",
       "haServiceVendor":"string",
       "haServiceTransport":"string",
       "haSecurityPkg":"string",
        "haCpe":"string",
       "tier1Support" :"string",
       "currency" : "string",
        "priceList" : [{
        "term":" string",
       "own": 0,
       "ctl": 0



        }

        ]
        

        }; 
        const actual = pricesReducer (state,{ type: 'INVALID_ACTION', payload: {} });
        const expected = state;
        expect(actual).toBe(expected);
    });

    it('should return price payload ', ()=>{
      const state = {
        "variantId":"string",
       "productId":"string",
       "name":"string",
       "sku" :"string",
       "descriptionHtml":"string",
       "displayImage" :"string",
       "displayPosition": 0,
       "servicePlan" :"string" ,
       "serviceVendor":"string",
       "serviceTransport":"string",
       "securityPkg":"string",
       "standardCpe" :"string",
       "haServicePlan":"string",
       "haServiceVendor":"string",
       "haServiceTransport":"string",
       "haSecurityPkg":"string",
        "haCpe":"string",
       "tier1Support" :"string",
       "currency" : "string",
        "priceList" : [{
        "term":" string",
       "own": 0,
       "ctl": 0

        }

        ]
        }; 
        const payload_to_send = state;
        const actual = pricesReducer (state, { type: 'ADD_PRICES', payload: payload_to_send });
        const expected = state;
        expect(actual).toBe(expected);

    });
});