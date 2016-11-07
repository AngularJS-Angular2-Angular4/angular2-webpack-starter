package com.centurylink.pctl.mod.product.domain.product;

import com.centurylink.pctl.mod.core.model.product.Price;
import com.centurylink.pctl.mod.core.model.product.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class PctlApiProductService is a service class for PctlProductRestController.
 * <br>This class PctlApiProductService makes a call to the ProductRepository class methods.
 *
 * @author Begin Samuel
 */
@Service
public class PctlApiProductService {

    private final Logger log = LoggerFactory.getLogger(PctlApiProductService.class);
    /**
     * ProductRepository is Autowired, fetches product related datas from database
     */
    @Autowired
    private ProductRepository productRepository;

    /**
     * PriceRepository is Autowired, fetches product related datas from database
     */
    @Autowired
    private PriceRepository priceRepository;

    /**
     * This findProductByProductId() method accepts productId as input and returns respective product from database.
     * This findProductByProductId() method calls  {@link com.centurylink.pctl.mod.product.domain.product.ProductRepository#findProductByProductId(String)} method
     *
     * @param productId, available productId from database
     * @return Product, returns respective Product for the given productid available in database
     */
    public Product findProductByProductId(String productId) {
        return productRepository.findProductByProductId(productId).get(0);
    }

    /**
     * This findProductsByUrnId() method accepts urnId as input and returns respective product Lists from database.
     * This findProductsByUrnId() method calls productRepository classes findProductsByUrnId () method
     *
     * @param urnId available {@code String} from database
     * @return Product list , returns respective List of Products for the given urnId available in database
     */
    public List<Product> findProductsByUrnId(String urnId) {
        return productRepository.findProductsByUrnId(urnId);
    }

    /**
     * This findAll() method calls productRepository classes findAll () method and fetches all available product from database
     *
     * @return {@linkplain Product} list, returns all available Products list from database.
     */
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    /**
     * findPriceByProductId() method accepts productId as parameter and returns respective Price Lists from database.
     * findPriceByProductId() method calls productRepository classes findPriceByProductId () method
     *
     * @param productId , available productid from database
     * @return Price  List of Price, returns respective List of Price for the given productId available in database
     */
    public List<Price> findPriceByProductId(String productId) {
        return priceRepository.findPriceByProductId(productId);
    }

    /**
     * findAllPrice() method internally uses findAll() method available in priceRepository.
     *
     * @return List of Price, returns all Product's Price list available in database
     */
    public List<Price> findAllPrice() {
        return priceRepository.findAll();
    }

    /**
     * findAllPriceByVariantId() method takes variantId as parameter and returns list of price for the given product variantId
     * findAllPriceByVariantId() method internally calls PriceRepository class findPriceByVarintId() method.
     *
     * @param variantId, available variantId from database
     * @return Price List, List of Price belongs to specified product variantId.
     */
    public List<Price> findAllPriceByVariantId(String variantId) {
        return priceRepository.findPriceByVarintId(variantId);
    }

}
