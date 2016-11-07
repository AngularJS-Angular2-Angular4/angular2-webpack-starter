import {Injectable} from '@angular/core';
import { Observable } from 'rxjs/Observable';
import 'rxjs/Rx';
import {CITIES} from '../db-static/cities';

@Injectable()
export class CityService{

    fetchCities():any{
      return CITIES.map((cities)=> cities.City.charAt(0).toUpperCase()+cities.City.slice(1).toLowerCase());
    }

}