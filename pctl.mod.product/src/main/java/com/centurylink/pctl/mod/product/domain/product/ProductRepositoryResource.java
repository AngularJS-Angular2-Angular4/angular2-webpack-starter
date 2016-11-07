package com.centurylink.pctl.mod.product.domain.product;

import com.centurylink.pctl.mod.core.model.product.Product;
import com.centurylink.pctl.mod.product.controllers.rest.PctlProductRestController;
import org.springframework.data.rest.webmvc.RepositoryLinksResource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.stereotype.Component;

/**
 * ProductRepositoryResource class
 * <br> methods available
 * <br> - process()
 * <br> - addActionLinks()
 * @author  begin.samuel.
 */

@Component
public class ProductRepositoryResource implements ResourceProcessor<RepositoryLinksResource> {

    /**
     * process() adds action link to Resources
     * <br>
     * @param resource is an input given
     * @return resource returned with added action links
     */
    @Override
    public RepositoryLinksResource process(RepositoryLinksResource resource) {
        resource.add(ControllerLinkBuilder.linkTo(PctlProductRestController.class).withRel("Sam"));

        addActionLinks(resource, null);

        return resource;
    }

    /**
     * addActionLinks() method makes the argument as input
     * @param resource given input
     * @param entity, Product entity is given input
     */
    private void addActionLinks(final RepositoryLinksResource resource, final Product entity) {
        //final Link priceLink = ControllerLinkBuilder.linkTo(methodOn(BlogPostRestController.class).getPosts()).withRel("add-posts");
        // resource.add(priceLink);
    }


}
