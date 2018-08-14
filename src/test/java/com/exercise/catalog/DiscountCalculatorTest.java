package com.exercise.catalog;

import org.junit.Test;

import static org.junit.Assert.*;

public class DiscountCalculatorTest
{
    
    final Double price1 = Double.valueOf("0.53");
    
    final Double price2 = Double.valueOf("89.99");    

    @Test
    public void testGetFinalPrice()
    {
        final DiscountCalculator calculator = new DiscountCalculator();
        Product product = new Product(2000);
        product.setPrice(Double.valueOf(".56"));
        product.setDiscount(Double.valueOf("5.00"));
        assertNotNull(calculator.getFinalPrice(product));
        assertTrue(price1.equals(calculator.getFinalPrice(product)));
        
        product = new Product(3000);
        product.setPrice(Double.valueOf("99.99"));
        product.setDiscount(Double.valueOf("10"));
        assertTrue(price2.equals(calculator.getFinalPrice(product)));
    }

}

