package com.exercise.catalog;

/**
 * Enum to store UOM codes.
 *
 * @author rmathew
 */
public enum UomEnum
{

    BOX("Box", "BX"),
    DOZEN("Dozen", "DZ"),
    PACK("Pack", "PK"),
    EACH("Each", "EA");    

    private String description;


    private String code;
    

    private UomEnum(final String description, final String code)
    {
        this.description = description;
        this.code = code;
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
     * Getter for code.
     *
     * @return the code
     */
    public String getCode()
    {
        return code;
    }


    /**
     * Setter for code.
     *
     * @param code the code to set
     */
    
    public void setCode(String code)
    {
        this.code = code;
    }
    
    /**
     * Returns UOM by looking up code.
     * @param code
     * @return
     */
    public static UomEnum getUom(final String code)
    {
        UomEnum uom = null;
        if (code.equals(EACH.getCode()))
        {
            uom = EACH;
        }
        else if (code.equals(DOZEN.getCode()))
        {
            uom = DOZEN;
        }
        else if (code.equals(PACK.getCode()))
        {
            uom = PACK;
        }
        else if (code.equals(BOX.getCode()))
        {
            uom = BOX;
        }
        return uom;
    }
}

