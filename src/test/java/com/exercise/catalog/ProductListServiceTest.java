/*
 *    Copyright &copy; Flagstar Bank 2018.
 *
 *    Copyright in the application source code, and in the information and
 *    material therein and in their arrangement, is owned by Flagstar Bank, FSB
 *    unless otherwise indicated.
 *
 *    You shall not remove or obscure any copyright, trademark or other notices.
 *    You may not copy, republish, redistribute, transmit, participate in the
 *    transmission of, create derivatives of, alter edit or exploit in any
 *    manner any material including by storage on retrieval systems, without the
 *    express written permission of Flagstar Bank.
 */
package com.exercise.catalog;

import java.util.List;
import java.util.Set;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * ProductListServiceTest.
 *
 * @author rmathew
 */
public class ProductListServiceTest
{

    @Test
    public void test()
    {
        ProductListServiceImpl service = new ProductListServiceImpl();
        assertNotNull(service.getSelectProducts(CatalogConstants.paperCriteria));
    }
    
    @Test
    public void testListProducts()
    {
        ProductListServiceImpl service = new ProductListServiceImpl();
        Set<Product> productList = service.getSelectProducts(CatalogConstants.paperCriteria);
        
        for(Product product : productList)
        {
            System.out.println(product.toDisplayString());
        }
    }    

}

