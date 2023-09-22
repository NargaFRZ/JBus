package FairuzMuhammadJBusRA;

/**
 * Represents a voucher with specified Details
 * The Voucher class extends the Serializable Class
 *
 * @author Fairuz Muhammad
 * @version CS3
 * @see Serializable
 */

public class Voucher extends Serializable{
    /**
     * The Name of the person who uses the voucher
     */
    public String name;
    
    /**
     * To identify if the voucher is used or not
     * This variable is private
     */
    private boolean used;
    
    /**
     * The minimum Price to be able to use a voucher
     */
    public double minimum;
    
    /**
     * The cut of the price that is applied after using a voucher
     */
    public double cut;
    
    /**
     * The code of the voucher
     */
    public int code;
    
    /**
     * The type of the Voucher according to the Voucher enum @see Type
     */
    public Type type;
    
    /**
     * Construct a new Voucher object with the specified details
     * 
     * @param id The ID of the Voucher, inherited from the Serializable class
     * @param name The Name of the person who is using the Voucher
     * @param code The Code of the Voucher
     * @param type The type of the Voucher according to the Voucher enum @see Type
     * @param minimum The minimum price to be able to use a voucher
     * @param cut The cut of the price that is applied after using a voucher
     */
    public Voucher(int id, String name, int code, Type type, double minimum, double cut){
        super(id);
        this.name = name;
        this.code = code;
        this.type = type;
        this.minimum = minimum;
        this.cut = cut;
        this.used = false;
    }
    
    /**
     * Check if the Voucher is used or not
     * 
     * @return True or False based on the used boolean value)
     */
    public boolean isUsed(){
        return used;
    }
    
    /**
     * Check if the voucher can be applied or not
     * 
     * @param price The price of the ticket, from the Price class @see Price
     * 
     * @return Returns true if price is more than the minimum and the used value is false, else Returns false
     */
    public boolean canApply(Price price){
        if(price.price > this.minimum && !this.used){
            return true;
        }
        return false;
    }
    
    /**
     * Apply the voucher
     * Based on the voucher type the cut will be different
     * If the voucher type is Discount, cut will be treated as percentage
     * If the voucher type is Rebate, cut will be treated as normal value
     * On type Discount, if cut is bigger than 100, cut will be set to 100
     * On type Rebate, if cut is bigger than the price, cut will be set to the same as price
     * 
     * @return Returns the original price if the voucher cannot be applied, else Returns the Price after applying discount or rebate
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