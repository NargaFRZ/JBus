package FairuzMuhammadJBusRA;

import java.util.Calendar;

/**
 * Represents an Invoice with specified Details
 * The Invoice class extends the Serializable Class
 *
 * @author Fairuz Muhammad
 * @version CS4
 * @see Serializable
 */

public class Invoice extends Serializable{
    /**
     * The time the invoice was made
     */
    public Calendar time;
    
    /**
     * The ID of the buyer
     */
    public int buyerId;
    
    /**
     * The ID of the renter
     */
    public int renterId;
    
    /**
     * The rating given to the Bus
     */
    public BusRating rating;
    
    /**
     * The status of the Payment
     */
    public PaymentStatus status;
    
    /**
     * Construct a new Invoice object with the specified details
     * This constructor is Protected which means it can only be accessed by the same package or by subclasses
     * 
     * @param id The ID of the invoice, inherited from the Serializable Class
     * @param buyerId The ID of the buyer
     * @param renterId The ID of the renter
     * @param time The time the invoice was made
     */
    protected Invoice(int id, int buyerId, int renterId){
        super(id);
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.time = Calendar.getInstance();
        this.rating = rating.NONE;
        this.status = status.WAITING;
    }
    
    /**
     * Construct a new Invoice object with the specified details
     * 
     * @param id The ID of the invoice, inherited from the Serializable Class
     * @param buyer The ID of the buyer, from the class Account @see Account
     * @param renter The ID of the renter, from the class Renter @see Renter
     * @param time The time the invoice was made
     */
    public Invoice(int id, Account buyer, Renter renter){
        super(id);
        this.buyerId = buyer.id;
        this.renterId = renter.id;
        this.time = Calendar.getInstance();
        this.rating = rating.NONE;
        this.status = status.WAITING;
    }
    
    /**
     * Returns a string that shows all the invoice details
     * 
     * @return A string containing the invoice details
     */
    public String toString(){
        return "Invoice Id: " + super.id +
                ", Buyer Id: " + buyerId +
                ", Renter Id: " + renterId +
                ", Rating: " + rating +
                ", Status: " + status;
    }
    
    /**
     * An Enum representing the rating given to the Bus
     */
    public enum BusRating{
        /**
         * No Rating
         */
        NONE,
        
        /**
         * Neutral Rating
         */
        NEUTRAL,
        
        /**
         * Good Rating
         */
        GOOD,
        
        /**
         * Bad Rating
         */
        BAD;
    }
    
    /**
     * An Enum representing the status of the Payment
     */
    public enum PaymentStatus{
        /**
         * Payment failed
         */
        FAILED,
        
        /**
         * Payment is pending
         */
        WAITING,
        
        /**
         * Payment successful
         */
        SUCCESS;
    }
}
