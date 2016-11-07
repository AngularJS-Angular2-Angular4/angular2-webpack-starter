
package com.centurylink.pctl.mod.address.domain.address;


import com.centurylink.pctl.mod.core.model.address.Address;
import com.centurylink.pctl.mod.core.utils.Response;

/**
 * This class AddressService is a service interface for AddressServiceImpl class.
 * <br>
 *     This interface AddressService contains one methods
 * <br> - validate()
 * @author Haribabu.ka
 */
public interface AddressService {

    /**
     * configured with "address","addressType" data from Soap.
     *
     * @param address     is input parameter.
     * @param addressType is input parameter.
     * @return Address.
     */
    public Response<Address> validate(Address address, AddressType addressType);
}




