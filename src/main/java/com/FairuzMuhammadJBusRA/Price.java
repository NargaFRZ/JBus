package com.FairuzMuhammadJBusRA;

/**
 * Represents the pricing details of an item, including its base price and any applicable rebate.
 *
 * @author Fairuz Muhammad
 * @version FINAL
 */

public class Price{
    /**
     * The base price of the item.
     */
    public double price;
    
    /**
     * The rebate amount deducted from the base price.
     */
    public double rebate;
    
    /**
     * Constructs a new Price object with the specified base price and a default rebate of 0.0.
     *
     * @param price The base price of the item.
     */
    public Price(double price){
        this.price = price;
        this.rebate = 0.0;
    }
    
    /**
     * Constructs a new Price object with a specified base price and rebate.
     *
     * @param price The base price of the item.
     * @param rebate The rebate amount to be deducted from the base price.
     */
    public Price(double price, double rebate){
        this.price = price;
        this.rebate = rebate;
    }
    
    /**
     * Provides a string representation of the pricing details, including the base price and rebate.
     *
     * @return A string containing the base price and rebate amount.
     */
    public String toString(){
        return  "Price: " + price +
                ", Rebate: " + rebate;
    }
}

