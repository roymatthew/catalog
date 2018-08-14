package com.exercise.catalog;

import java.text.DecimalFormat;

/**
 * Utility class to calculate final price of a product.
 *
 * @author rmathew
 */
public class DiscountCalculator
{
    
    /**
     * Returns the final price of a product after discount if any.
     * @param product
     * @return finalPrice Double
     */
    public static Double getFinalPrice(final Product product)
    {
        Double finalPrice = product.getPrice();
        
        if (product.getDiscount() != null)
        {
            Double markDownPercentage = Double.sum(CatalogConstants.DOUBLE_HUNDRED, product.getDiscount() * -1);
            finalPrice = product.getPrice() * markDownPercentage / CatalogConstants.DOUBLE_HUNDRED;
            DecimalFormat df = new DecimalFormat(CatalogConstants.STR_ZERO);
            final String formattedValue = df.format(finalPrice);
            finalPrice = Double.valueOf(formattedValue);
        }
        return finalPrice;
    }

}

