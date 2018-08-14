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

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * PriceFormatterTest.
 *
 * @author rmathew
 */
public class PriceFormatterTest
{
    
    private static final String formattedPrice1 = "$200.85/Box";

    /**
     * Test method for {@link com.exercise.catalog.PriceFormatter#formatPrice(com.exercise.catalog.Product)}.
     */
    @Test
    public void testFormatPrice()
    {
        final PriceFormatter formatter = new PriceFormatter();
        final Product product = new Product(100);
        product.setUom("BX");
        product.setFinalPrice(Double.valueOf("200.85"));
        formatter.formatPrice(product);
        assertTrue(formattedPrice1.equals(product.getFormattedPrice()));
        
    }

}

