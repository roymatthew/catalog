
package com.exercise.catalog;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Service implementation for ProductListService.
 *
 * @author rmathew
 */
public class ProductListServiceImpl implements ProductListService
{

    /**
     * Returns list of products that match given criteria. 
     * @param criteria
     * @return filteredList List
     */
    public Set<Product> getSelectProducts(final String criteria)
    {

        final CatalogReader catalogReader = new CatalogReader();
        final List<Product> products = catalogReader.getProducts();        
        final Set<Product> filteredProducts = new TreeSet<>();
        final Map<String,Product> map = new HashMap<>();
        for (Product product : products)
        {
            if (product.getDescription().toLowerCase().contains(criteria) || product.getCategory().toLowerCase().contains(criteria))
            {
                String key = String.valueOf(product.getPartNumber());
                if (!map.containsKey(key))
                {
                    product.setFinalPrice(DiscountCalculator.getFinalPrice(product));
                    PriceFormatter.formatPrice(product);
                    map.put(key, product);
                    filteredProducts.add(product);
                }

            }
        }
        return filteredProducts;
    }

}
