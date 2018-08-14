package com.exercise.catalog;

import java.text.DecimalFormat;

/**
 * Utility class to format product price for invoice creation.
 *
 * @author rmathew
 */
public class PriceFormatter
{
    
    private static final String PRICE_FORMAT = "$###,###.##/";
    private static final DecimalFormat df = new DecimalFormat(PRICE_FORMAT);
    
    /**
     * Sets the formatted price using decimal format.
     * @param product Product
     */
    public static void formatPrice(final Product product)
    {
        String formattedPrice = df.format(product.getFinalPrice());
        formattedPrice += getUom(product);        
        product.setFormattedPrice(formattedPrice);
        
    }

    /**
     * Returns UOM description.
     * @param product
     * @return String
     */    
    private static String getUom(final Product product)
    {
        return UomEnum.getUom(product.getUom()).getDescription();
        
    }

}

