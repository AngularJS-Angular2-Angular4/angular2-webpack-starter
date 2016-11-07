
package com.centurylink.pctl.mod.address.domain.address;


import com.centurylink.pctl.mod.core.model.address.Address;
import com.centurylink.pctl.mod.core.utils.Response;
import com.centurylink.pctl.mod.core.utils.StatusCode;
import com.centurylink.pctl.mod.core.utils.ValidateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * This class AddressServiceImpl is a service implementation class for PctlAddressValidationController.
 * <br>
 *     This class AddressServiceImpl makes a call to the Soap end point.
 *     This class PctlAddressValidationController contains one methods
 * <br> - validate()
 * <br> - callAddressValidationSoapService()
 * @author Haribabu.ka
 */
@Component
public class AddressServiceImpl implements AddressService {

    private static final Logger log = LoggerFactory.getLogger(AddressServiceImpl.class);

    /**
     * This validate() method accepts address and addressType as input and returns respective address response from Soap.
     * This validate() method calls callAddressValidationSoapService() method.
     *
     * @param address     {@link com.centurylink.pctl.mod.core.model.address.Address}.
     * @param addressType {@link com.centurylink.pctl.mod.address.domain.address.AddressType}.
     * @return Address, respective address for the given address, addressType available from Soap
     */
    public Response<Address> validate(Address address, AddressType addressType) {
        ValidateUtils<Address> validator = new ValidateUtils<Address>();
        Response<Address> addressResponse = validator.validateBean(address);
        if (addressResponse != null) {
            return addressResponse;
        }
        return callAddressValidationSoapService(address, addressType);
    }

    /**
     * This callAddressValidationSoapService() method accepts address and addressType as input and returns respective address response from Soap.
     * @param address {@link com.centurylink.pctl.mod.core.model.address.Address}.
     * @param addressType {@link com.centurylink.pctl.mod.address.domain.address.AddressType}.
     * @return ResponseEntity<Response<Address>>, respective address for the given address, addressType available from Soap
     */
    private Response<Address> callAddressValidationSoapService(Address address, AddressType addressType) {
        Response<Address> addressResponse = new Response<>();
        addressResponse.setStatus(StatusCode.E200);
        // Implement the Soap Service call.
        // process the soap Service response.
        return addressResponse;
    }
}
