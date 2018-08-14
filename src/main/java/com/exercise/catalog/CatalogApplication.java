package com.exercise.catalog;

import java.util.Set;

/**
 * Class used to produce output of requested products.
 *
 * @author rmathew
 */
public class CatalogApplication
{

    /**
     * Main method.
     * 
     * @param args
     */
    public static void main(String[] args)
    {
        final ProductListService productListService = new ProductListServiceImpl();
        final Set<Product> productList = productListService.getSelectProducts(CatalogConstants.paperCriteria);
        productList.stream().forEach(p -> {System.out.println(p.toInvoiceRowString());});

    }

}

