package com.exercise.catalog;

import java.util.Comparator;


/**
 * DTO class that maps a Product.
 *
 * @author rmathew
 */
public class Product implements Comparable<Product>
{
    private Integer partNumber;
    private String description;
    private String category;
    private String uom;
    private Double price;
    private Double discount;
    private Double finalPrice;
    private String formattedPrice;
    
    /**
     * Constructor using partNumber field.
     * @param partNumber
     */
    public Product(final Integer partNumber)
    {
        super();
        this.partNumber = partNumber;
    }
    /**
     * Getter for partNumber.
     *
     * @return the partNumber
     */
    public Integer getPartNumber()
    {
        return partNumber;
    }
    /**
     * Setter for partNumber.
     *
     * @param partNumber the partNumber to set
     */
    
    public void setPartNumber(Integer partNumber)
    {
        this.partNumber = partNumber;
    }
    /**
     * Getter for description.
     *
     * @return the description
     */
    public String getDescription()
    {
        return description;
    }
    /**
     * Setter for description.
     *
     * @param description the description to set
     */
    
    public void setDescription(String description)
    {
        this.description = description;
    }
    /**
     * Getter for category.
     *
     * @return the category
     */
    public String getCategory()
    {
        return category;
    }
    /**
     * Setter for category.
     *
     * @param category the category to set
     */
    
    public void setCategory(String category)
    {
        this.category = category;
    }
    /**
     * Getter for uom.
     *
     * @return the uom
     */
    public String getUom()
    {
        return uom;
    }
    /**
     * Setter for uom.
     *
     * @param uom the uom to set
     */
    
    public void setUom(String uom)
    {
        this.uom = uom;
    }
    /**
     * Getter for price.
     *
     * @return the price
     */
    public Double getPrice()
    {
        return price;
    }
    /**
     * Setter for price.
     *
     * @param price the price to set
     */
    
    public void setPrice(Double price)
    {
        this.price = price;
    }
    /**
     * Getter for discount.
     *
     * @return the discount
     */
    public Double getDiscount()
    {
        return discount;
    }
    /**
     * Setter for discount.
     *
     * @param discount the discount to set
     */
    
    public void setDiscount(Double discount)
    {
        this.discount = discount;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    @Override
    public String toString()
    {
        return "Product [partNumber=" + partNumber + ", description=" + description + ", category=" + category
            + ", uom=" + uom + ", price=" + price + ", discount=" + discount + ", finalPrice=" + finalPrice
            + ", formattedPrice=" + formattedPrice + "]";
    }
    
    /**
     * Generates an invoice row using select attributes.
     * @return String
     */
    public String toInvoiceRowString()
    {
        return partNumber +  ", " + category + ", " + UomEnum.getUom(uom).getDescription() + ", " + formattedPrice;
    }
    /**
     * Setter for final price.
     * @param finalPrice
     */    
    public void setFinalPrice(final Double finalPrice)
    {
        this.finalPrice = finalPrice;
        
    }
    /**
     * Getter for finalPrice.
     *
     * @return the finalPrice
     */
    public Double getFinalPrice()
    {
        return finalPrice;
    }
    /**
     * Getter for formattedPrice.
     *
     * @return the formattedPrice
     */
    public String getFormattedPrice()
    {
        return formattedPrice;
    }
    /**
     * Setter for formattedPrice.
     *
     * @param formattedPrice the formattedPrice to set
     */
    
    public void setFormattedPrice(String formattedPrice)
    {
        this.formattedPrice = formattedPrice;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */    
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((partNumber == null) ? 0 : partNumber.hashCode());
        return result;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */    
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (!(obj instanceof Product))
        {
            return false;
        }
        Product other = (Product) obj;
        if (partNumber == null)
        {
            if (other.partNumber != null)
            {
                return false;
            }
        }
        else if (!partNumber.equals(other.partNumber))
        {
            return false;
        }
        return true;
    }
    
    /**
     * Compares this object with another one for sorting.
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */    
    public int compareTo(final Product otherProduct)
    {
        return Comparator.comparing(Product::getFinalPrice)
            .compare(this, otherProduct);       
    }
    
}

