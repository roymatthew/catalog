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

import junit.framework.Assert;

/**
 * ProductTest.
 *
 * @author rmathew
 */
public class ProductTest
{

    /**
     * Test method for {@link com.exercise.catalog.Product#toString()}.
     */
    @Test
    public void testToString()
    {
        final Product product = new Product(Integer.valueOf("1000"));
        assertNotNull(product.toString());
        assertNull(product.getDescription());
    }

}

