package com.centurylink.pctl.mod.product.domain.product;


import com.centurylink.pctl.mod.core.model.product.Product;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.stereotype.Component;

/**
 * ProductResource class has process() method
 * @author begin.samuel.
 */
@Component
public class ProductResource implements ResourceProcessor<Resource<Product>> {

    /**
     * process () is overridden and added link
     * @param resource
     * @return
     */
    @Override
    public Resource<Product> process(Resource<Product> resource) {
        resource.add(new Link("/products/" + resource.getContent().getName(), "comments"));
        return resource;
    }

}
