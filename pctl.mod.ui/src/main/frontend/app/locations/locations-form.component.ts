import {
  Component,
  Input, 
  EventEmitter, 
  OnInit, 
  Output,
  AfterViewInit
	} from '@angular/core';
import {
  EnterpriseAddress,
  ContactInfo,
  SDWANLocationInfo,
  LocationsFormModel,
  ShoppingCart
	} from '../common/models/cart.model';
import { Observable } from 'rxjs/Observable';
import { Store, Action } from '@ngrx/store';
import { AppStore } from '../common/models/appstore.model';
import { ActivatedRoute } from '@angular/router';
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';
import { Location } from '../common/models/locations.model';
import { FingerPrintService } from '../common/service/fingerprint.service';
import { Validations } from '../common/validations/validations';
import { CountryStateService } from '../common/service/country-state.service';
import { LocationsService } from './locations.service';
import { Country } from '../common/models/country.model';
import { State } from '../common/models/state.model';

@Component({
  selector: 'locations-form',
  styleUrls: ['./locations-form.component.css'],
  templateUrl: './locations-form.component.html'
})

export class LocationsFormComponent implements OnInit {
  public myForm: FormGroup;
  locationInfo: SDWANLocationInfo;
  error: boolean;
  serviceValid: boolean;
  shippingValid: boolean;
  validation: Observable<ShoppingCart>;
  @Input() data: SDWANLocationInfo;
  @Output() locationUpdateEvent = new EventEmitter();
  @Output() locationAddEvent = new EventEmitter();
  submitted: boolean;
  countries:Country[];
  states: State[];
  selectedDefault=0;

  @Input() set formData(formData: SDWANLocationInfo) {
    // console.log(formData);
    this.data = formData;
    if (formData !== undefined) {
      console.log(formData);
      document.getElementById('email').focus();
      this.populateForm();
    }
  }

  constructor(private fb: FormBuilder,
                private countryStateService: CountryStateService,
                public store: Store<AppStore>,
                public locationService: LocationsService) {
      this.validation = <Observable<ShoppingCart>>store.select('cart');
      this.states = this.countryStateService.getStates();
      this.countries=this.countryStateService.getCountries();
  }

  // we have to keep country: 'USA', it's because of when reset country should be keep remain
  resetDataModel() {
      this.data = {
          id: '',
          serviceContact: {
              id: '',
              email: '',
              firstName: '',
              lastName: '',
              phoneNumber: '',
          },
          serviceAddress: {
              id: '',
              locationName: '',
              addressLine: '',
              street: '',
              city: '',
              country: this.countries[0].countryCode,
              state: '',
              zipCode: ''
          },
          shippingAddress: {
              id: '',
              locationName: '',
              addressLine: '',
              street: '',
              city: '',
              country: this.countries[0].countryCode,
              state: '',
              zipCode: '',
              checkAddress: ''
          }
      };
  }

  populateForm() {
      ( < FormGroup > this.myForm)
      .setValue(this.data, {
          onlySelf: true
      });
  }

  ngOnInit() {
      this.submitted = false;
      // prepopulate form
      this.resetDataModel();
      this.myForm = this.fb.group({
          id: [''],
          serviceContact: this.fb.group({
              id: [''],
              email: ['', [ < any > Validators.required, < any > Validations.emailValidator]],
              firstName: ['', [ < any > Validators.required, < any > Validators.minLength(3), <
                  any > Validations.nameValidator
              ]],
              lastName: ['', [ < any > Validators.required, < any > Validations.nameValidator]],
              phoneNumber: ['', [ < any > Validators.required, < any > Validations.phoneValidator]],
          }),
          serviceAddress: this.fb.group({
              id: [''],
              locationName: ['', [ < any > Validators.required, < any > Validators.minLength(3)]],
              addressLine: ['', < any > Validators.required],
              street: [''],
              city: ['', [ < any > Validators.required, < any > Validations.nameValidator]],
              country: ['', < any > Validators.required],
              state: ['', < any > Validators.required],
              zipCode: ['', < any > Validations.zipCodeValidator],
          }),
          shippingAddress: this.fb.group({
              id: [''],
              checkAddress: [''],
              locationName: ['', [ < any > Validators.required, < any > Validators.minLength(3)]],
              addressLine: ['', < any > Validators.required],
              street: [''],
              city: ['', [ < any > Validators.required, < any > Validations.nameValidator]],
              country: ['', < any > Validators.required],
              state: ['', < any > Validators.required],
              zipCode: ['', < any > Validations.zipCodeValidator],
          })
      });
      ( < FormGroup > this.myForm)
      .setValue(this.data, {
          onlySelf: true
      });
      this.populateForm();
  }

  onSubmit() {
      this.submitted = true;
      this.locationInfo = this.myForm.value;
      let addEvent: boolean = false;
      
      if (this.locationInfo.id === '') {
          addEvent = true;
          this.locationInfo = Object.assign({},
              this.locationInfo, {
                  id: FingerPrintService.UUID()
              }
          );
      }
     
      this.resetDataModel();
      this.populateForm();
      this.myForm.markAsUntouched();
      
      if (addEvent) {
          this.locationAddEvent.emit(this.locationInfo);
      } else { // Update Event
          this.locationUpdateEvent.emit(this.locationInfo);
      }
  }

  serviceMethod() {
    if (this.myForm.value.serviceAddress.addressLine && this.myForm.value.serviceAddress.city
      && this.myForm.value.serviceAddress.country && this.myForm.value.serviceAddress.state
      && this.myForm.value.serviceAddress.zipCode) {
          this.serviceValid = true;
      this.valiationCall(this.myForm.value.serviceAddress,'Service')
      .map(payload => ({ type: 'SERVICE_ADDRESS_VALIDATION', payload }))
      .subscribe(
      data => {
        this.store.dispatch(data);
        },
        err => { this.error = true;
          });
    } else {
        this.serviceValid = false;
    }
  }

  shippingMethod() {
    if (this.myForm.value.shippingAddress.addressLine && this.myForm.value.shippingAddress.city
      && this.myForm.value.shippingAddress.country && this.myForm.value.shippingAddress.state
      && this.myForm.value.shippingAddress.zipCode) {
          this.shippingValid = true;
      this.valiationCall(this.myForm.value.shippingAddress,'Postal')
      .map(payload => ({ type: 'SHIPPING_ADDRESS_VALIDATION', payload }))
      .subscribe(
      data => {
        this.store.dispatch(data);
        },
        err => { this.error = true;
          });
    } else {
        this.shippingValid = false;
    }
  }

  private valiationCall(address: EnterpriseAddress, call: String) {
    return this.locationService.validLocation(address,call);
    }

//removed country as it is only static
  onClickCheckAddress(checked) {
      if (checked) {
          this.myForm.value.shippingAddress.locationName = this.myForm.value.serviceAddress.locationName;
          this.myForm.value.shippingAddress.addressLine = this.myForm.value.serviceAddress.addressLine;
          this.myForm.value.shippingAddress.street = this.myForm.value.serviceAddress.street;
          this.myForm.value.shippingAddress.city = this.myForm.value.serviceAddress.city;
          this.myForm.value.shippingAddress.state = this.myForm.value.serviceAddress.state;
          this.myForm.value.shippingAddress.zipCode = this.myForm.value.serviceAddress.zipCode;

          this.myForm.patchValue({
              shippingAddress: {
                  locationName: this.myForm.value.shippingAddress.locationName,
                  addressLine: this.myForm.value.shippingAddress.addressLine,
                  street: this.myForm.value.shippingAddress.street,
                  city: this.myForm.value.shippingAddress.city,
                  state: this.myForm.value.shippingAddress.state,
                  zipCode: this.myForm.value.shippingAddress.zipCode,
              }
          });
          this.shippingMethod();
      } else {
          this.myForm.patchValue({
              shippingAddress: {
                  locationName: '',
                  addressLine: '',
                  street: '',
                  city: '',
                  state: '',
                  zipCode: '',
              }
          });
          this.shippingValid = false;
      }
  }

//if checkbox is checked and we are changing service input, so it should reflect to shipping address
//city concept not implemented because of city should be autopopulate(after auto populate bug fix) and on select we have to implement that
  changeInputOnKeyUp(temp) {
      if (this.myForm.value.shippingAddress.checkAddress) {
          if (temp == 'locationName') {
              this.myForm.value.shippingAddress.locationName = this.myForm.value.serviceAddress.locationName;
              this.myForm.patchValue({
                  shippingAddress: {
                      locationName: this.myForm.value.shippingAddress.locationName
                  }
              });
          } else if (temp == 'addressLine') {
              this.myForm.value.shippingAddress.addressLine = this.myForm.value.serviceAddress.addressLine;
              this.myForm.patchValue({
                  shippingAddress: {
                      addressLine: this.myForm.value.shippingAddress.addressLine
                  }
              });
          } else if (temp == 'street') {
              this.myForm.value.shippingAddress.street = this.myForm.value.serviceAddress.street;
              this.myForm.patchValue({
                  shippingAddress: {
                      street: this.myForm.value.shippingAddress.street
                  }
              });
          } else if (temp == 'zipCode') {
              this.myForm.value.shippingAddress.zipCode = this.myForm.value.serviceAddress.zipCode;
              this.myForm.patchValue({
                  shippingAddress: {
                      zipCode: this.myForm.value.shippingAddress.zipCode
                  }
              });
          }
      }
  }

  changeInputOnChange(temp){
     if (this.myForm.value.shippingAddress.checkAddress) {
         if (temp == 'state') {
              this.myForm.value.shippingAddress.state = this.myForm.value.serviceAddress.state;
              this.myForm.patchValue({
                  shippingAddress: {
                      state: this.myForm.value.shippingAddress.state
                  }
              });
          }
     }
  }
}