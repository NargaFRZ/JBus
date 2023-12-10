package com.FairuzMuhammadJBusRA;

import com.FairuzMuhammadJBusRA.dbjson.Serializable;

/**
 * Represents a voucher with specified details. This class extends the Serializable class
 * and provides functionality to manage and apply vouchers to prices.
 *
 * @author Fairuz Muhammad
 * @version FINAL
 * @see Serializable
 */

public class Voucher extends Serializable{
    /**
     * The Name of the person who uses the voucher
     */
    public String name;
    
    /**
     * Indicates whether the voucher has been used.
     */
    private boolean used;
    
    /**
     * The minimum price required to use the voucher.
     */
    public double minimum;
    
    /**
     * The amount by which the price is reduced when the voucher is applied.
     */
    public double cut;
    
    /**
     * The code of the voucher.
     */
    public int code;
    
    /**
     * The type of the voucher, as defined in the Type enumeration.
     */
    public Type type;
    
    /**
     * Constructs a new Voucher object with the specified details.
     *
     * @param id       The ID of the voucher, inherited from the Serializable class.
     * @param name     The name of the person using the voucher.
     * @param code     The code of the voucher.
     * @param type     The type of the voucher, as defined in the Type enumeration.
     * @param minimum  The minimum price required to use the voucher.
     * @param cut      The amount by which the price is reduced when the voucher is applied.
     */
    public Voucher(int id, String name, int code, Type type, double minimum, double cut){
        super();
        this.name = name;
        this.code = code;
        this.type = type;
        this.minimum = minimum;
        this.cut = cut;
        this.used = false;
    }
    
    /**
     * Checks if the voucher has been used.
     *
     * @return True if the voucher has been used, false otherwise.
     */
    public boolean isUsed(){
        return used;
    }
    
    /**
     * Checks if the voucher can be applied to a given price.
     *
     * @param price The price to which the voucher might be applied.
     * @return True if the voucher can be applied, false otherwise.
     */
    public boolean canApply(Price price){
        if(price.price > this.minimum && !this.used){
            return true;
        }
        return false;
    }
    
    /**
     * Applies the voucher to a given price.
     * The method of application depends on the type of the voucher.
     * For discount-type vouchers, the cut is treated as a percentage.
     * For rebate-type vouchers, the cut is a fixed amount subtracted from the price.
     *
     * @param price The price to which the voucher is applied.
     * @return The new price after applying the voucher.
     */
    public double apply(Price price){
        if(!canApply(price)){
            return price.price;
        }
        
        this.used = true;
        
        if(this.type == Type.DISCOUNT){
            if(this.cut>100){
                this.cut = 100.0;
            }
            price.price -= (price.price * this.cut / 100.0);
        }
        
        else if(this.type == Type.REBATE){
            if(price.price<this.cut){
                this.cut = price.price;
            }
            price.price -= this.cut;
        }
        
        return price.price;
    }
}
