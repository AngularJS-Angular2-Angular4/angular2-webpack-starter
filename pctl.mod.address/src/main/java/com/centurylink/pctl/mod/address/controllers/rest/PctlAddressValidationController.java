
package com.centurylink.pctl.mod.address.controllers.rest;

import com.centurylink.pctl.mod.address.domain.address.AddressService;
import com.centurylink.pctl.mod.address.domain.address.AddressType;
import com.centurylink.pctl.mod.core.model.address.Address;
import com.centurylink.pctl.mod.core.utils.Response;
import com.centurylink.pctl.mod.core.utils.StatusCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This class PctlAddressValidationController is a RestController using springMVC
 * <br>
 * This class PctlAddressValidationController contains one methods
 * <br> - validateAddress()
 *
 * @author Haribabu.ka
 */

@RequestMapping("/address")
@Controller
public class PctlAddressValidationController {

    private static final Logger log = LoggerFactory.getLogger(PctlAddressValidationController.class);

    /**
     * {@link com.centurylink.pctl.mod.address.domain.address.AddressService}.
    */
    @Autowired
    public AddressService addressService;

    /**
     * Post method which does the Address validation calling the Soap end point.
     *
     * @param address {@link  com.centurylink.pctl.mod.core.model.address.Address}
     * @param type {@link com.centurylink.pctl.mod.address.domain.address.AddressType}.
     * @return Address.
     */
    @RequestMapping(method = RequestMethod.POST, value = "/validation/{type}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Response<Address>> validateAddress(@RequestBody Address address, @PathVariable String type) {
        Response<Address> response = new Response<Address>();
        AddressType addressType = AddressType.getValueOf(type);
        if (addressType == null || address == null) {
            response.setStatus(StatusCode.C400);
            return new ResponseEntity<Response<Address>>(response, HttpStatus.BAD_REQUEST);
        } else {
            response = addressService.validate(address, addressType);
            return new ResponseEntity<Response<Address>>(response, response.getHttpStatus());
        }
    }
}


