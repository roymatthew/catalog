package com.exercise.catalog;

import java.util.Set;

/**
 * Interface for Product processing.
 *
 * @author rmathew
 */
public interface ProductListService
{
    /**
     * Returns list of products that match given criteria. 
     * @param criteria
     * @return filteredList List
     */
    Set<Product> getSelectProducts(final String criteria);
}

