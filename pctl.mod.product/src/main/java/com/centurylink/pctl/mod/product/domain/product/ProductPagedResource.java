package com.centurylink.pctl.mod.product.domain.product;

import com.centurylink.pctl.mod.core.model.product.Product;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.stereotype.Component;

/**
 * ProductPagedResource class implementing ResourceProcessor
 * <br> - process
 *
 * @author Begin Samuel
 */
@Component
public class ProductPagedResource implements ResourceProcessor<PagedResources<Resource<Product>>> {

    /**
     * process() method
     *
     * @param productResources, Product Resource is passed
     * @return productResources Product is returned
     */
    @Override
    public PagedResources<Resource<Product>> process(PagedResources<Resource<Product>> productResources) {

       /*final Link priceLink = ControllerLinkBuilder.linkTo(methodOn(BlogPostRestController.class).deletePost(1L)).withRel("product-review");
       productResources.add(priceLink);*/
        return productResources;
    }


}

