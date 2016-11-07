package com.centurylink.pctl.mod.product.controllers.rest;


import com.centurylink.pctl.mod.core.model.product.Price;
import com.centurylink.pctl.mod.core.model.product.Product;
import com.centurylink.pctl.mod.product.domain.product.PctlApiProductService;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class PctlProductRestController is a RestController using springMVC
 * <br>
 * This class PctlProductRestController contains three methods
 * <br> - getProducts()
 * <br> - getAllProductPrice()
 * <br> - getPriceByVariantId()
 *
 * @author Begin Samuel
 */

@Transactional
@RestController
@RequestMapping("/products")
public class PctlProductRestController {

    private static final Logger log = LoggerFactory.getLogger(PctlProductRestController.class);
    /**
     * PctlApiProductService is autowired for PctlProductRestController to make service call
     * to PriceRepository
     */
    @Autowired
    private PctlApiProductService pctlApiProductService;

    /**
     * getProducts() method returns one single Product details if it's available in database
     *
     * @return Product, if given product is available in database
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    // @PreAuthorize("hasRole('ADMIN')")
    public Product getProducts() {
        log.info("Getting Products");
        //   log.info(" Products count {} ",pctlApiProductService.findProductByProductId("sdwan1000").size());
        return pctlApiProductService.findProductByProductId("sdwan1000");
    }

    /**
     * This getAllProductPrice() method uses pctlApiProductService finaAll() internally and fetches the price list of all products
     * available in database.
     *
     * @return Price List, All available Product's price list will be returned
     */
    @RequestMapping(value = "/price/", method = RequestMethod.GET)
    public List<Price> getAllProductPrice() {
        log.info("Getting Price");
        log.info(" Price count {} ", pctlApiProductService.findAllPrice().size());
        return Lists.newArrayList(pctlApiProductService.findAllPrice());
    }

    /**
     * <p>
     * This getPriceByVariantId() gets parameter as variantId, which is  one among different products
     * This method intenally calls PctlApiProductService findAllPriceByVariantId() method
     * and returns list of price for that product
     * </p>
     *
     * @param variantId, one of the available product's variant id
     * @return Price List, List of product price for the given product's variant id
     */
    @RequestMapping(value = "/price/{variantId}", method = RequestMethod.GET)
    public List<Price> getPriceByVariantId(@PathVariable("variantId") String variantId) {
        log.info("Getting Price");
        log.info(" Price count {} ", pctlApiProductService.findAllPriceByVariantId(variantId));
        return Lists.newArrayList(pctlApiProductService.findAllPriceByVariantId(variantId));
    }


}
