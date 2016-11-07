package com.centurylink.pctl.mod.product.domain.product;


import com.centurylink.pctl.mod.core.model.product.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * ProductRepository interface extends  MongoRepository
 * ProductRepository interface has details regarding database ,it's table name and it's column
 * value matches with data available in database
 * configured data in  database is:  price
 * ProductRepository interface contains two methods
 * <br>    - findProductsByUrnId
 * <br>    - findProductByProductId
 *
 * @author Begin Samuel
 */
@RepositoryRestResource(collectionResourceRel = "products", path = "products")
public interface ProductRepository extends MongoRepository<Product, String>, ProductRepositoryCustom {

    /**
     * findProductByProductId() is configured with productId data available in database
     *
     * @param productId, available productId from database
     * @return Product List, all available products as list
     */
    @Query(value = "{ 'productId' : ?0 }")
    public List<Product> findProductByProductId(String productId);

    /**
     * findProductsByUrnId() method is configured with urnId data available in database
     *
     * @param urnId, available urnId from database
     * @return Product List for the specific urnId.
     */
    @Query(value = "{ 'urnid' : ?0 }")
    List<Product> findProductsByUrnId(String urnId);


}

