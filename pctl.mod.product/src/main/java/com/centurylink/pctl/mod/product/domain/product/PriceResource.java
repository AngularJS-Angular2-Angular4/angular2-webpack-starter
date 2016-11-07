package com.centurylink.pctl.mod.product.domain.product;


import com.centurylink.pctl.mod.core.model.product.Price;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.stereotype.Component;

/**
 * PriceResource class implementing ResourceProcessor
 * <br> - process() method
 *
 * @author Begin Samuel
 */


@Component
public class PriceResource implements ResourceProcessor<Resource<Price>> {

    /**
     * process() method
     * @param resource, Price Resource is passed
     * @return resource Price is returned
     */
    @Override
    public Resource<Price> process(Resource<Price> resource) {
        // resource.add(new Link("/products/price/" + resource.getContent().getName(), "comments"));
        return resource;
    }

}
