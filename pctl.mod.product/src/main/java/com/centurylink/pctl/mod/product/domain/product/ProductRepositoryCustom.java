package com.centurylink.pctl.mod.product.domain.product;

import com.centurylink.pctl.mod.core.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * ProductRepositoryCustom is interface with
 * <br> - findProductByFields() method
 *
 * @author Begin Samuel
 */
public interface ProductRepositoryCustom {
    /**
     * findProductByFields()
     * <br>
     *
     * @param productId, product details
     * @param pageable
     * @param fields
     * @return
     */
    Page<Product> findProductByFields(String productId, Pageable pageable, String... fields);
}
