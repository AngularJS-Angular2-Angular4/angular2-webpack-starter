export interface Cart {
    inventoryItems: InventoryItems[];
}

export interface InventoryItems {
    lineItem: string;
    itemName: string;
    quantity: number;
}

export enum CartState {
    'LandingPage',
    'Locations',
    'Terms And Conditions'
}

export interface ShoppingCart {
    id?: string;
    state?: CartState;
    lineItems?: LineItem[];
    serviceValidation?: AddressError;
    shippingValidation?: AddressError;
}

export interface LineItem {
    id?: string;
    productName: string;
    productId: string;
    productTemplateName: string;
    productTemplateId: string;
    unitPrice?: number;
    locations?: SDWANLocationInfo[];
}

export interface LocationInfo {
    productTemplateId: string;
    location: SDWANLocationInfo;
}

export interface ContactInfo {
    id?: string;
    email: string;
    firstName: string;
    lastName: string;
    phoneNumber: string;
}

export interface EnterpriseAddress {
    id?: string;
    locationName: string;
    addressLine: string;
    street: string;
    city: string;
    country: string;
    state: string;
    zipCode: string;
    checkAddress?: string;
}

export interface SDWANLocationInfo {
    id?: string;
    serviceContact: ContactInfo;
    serviceAddress: EnterpriseAddress;
    shippingAddress: EnterpriseAddress;
}

export interface LocationDisplay {
    id?: string;
    name: string;
    contact: string;
    address: string;
}

export interface LocationsFormModel {
    id?: string;
    contactid?: string;
    email: string;
    firstName: string;
    lastName: string;
    primaryPhone: string;
    contactAddressid: string;
    locationName: string;
    address: string;
    street: string;
    country: string;
    city: string;
    state: string;
    zipCode: string;
    checkAddress: string;
    shippingAddressid: string;
    shippingLocationName: string;
    shippingAddress: string;
    shippingStreet: string;
    shippingCountry: string;
    shippingCity: string;
    shippingState: string;
    shippingZipCode: string;
}

export interface AddressError {
   content?: EnterpriseAddress,
   message: string,
   fieldStatus?: Array<String>,
   code: string
}
