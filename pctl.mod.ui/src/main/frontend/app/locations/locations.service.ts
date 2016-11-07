import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions } from '@angular/http';
import { EnterpriseAddress, AddressError } from '../common/models/cart.model';
import { Observable } from 'rxjs/Rx';

const BASE_URL = 'http://localhost:8080/api/address-service/address/validation/';
const HEADER = { headers: new Headers({ 'Content-Type': 'application/json' }) };
@Injectable()
export class LocationsService {

    constructor(private http: Http) {
    }

    validLocation(item: EnterpriseAddress,call: String): Observable<AddressError> {
        console.log(BASE_URL+call);
        return this.http.post(BASE_URL+call, JSON.stringify(item), this.jwt())
        .map((res: any) => res.json());
    }

        private jwt() {
        // create authorization header with jwt token
        let jwtTok = 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhcGljbGllbnRAY3RsLmNvbSIsImlzcyI6IkN0bCIsImlhdCI6MTQ3ODA5MjA4MCwiZXhwIjoxNjMzNjEyMDgwfQ.FaZ0waUad6kISV07sytinAUpKinuz0j5znqACDnfiYTrptVTyhHP9lF-gFQinawfeUosZXDjpRvCYJ90MdgDUQ';
        if (jwtTok) {
            let headers = new Headers({'X-Authorization':'Bearer ' + jwtTok,'Content-Type': 'application/json'});
            return new RequestOptions({ headers: headers});

        }

    }

}
