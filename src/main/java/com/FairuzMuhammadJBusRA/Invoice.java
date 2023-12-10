package com.FairuzMuhammadJBusRA;

import java.sql.Timestamp;
import com.FairuzMuhammadJBusRA.dbjson.Serializable;

/**
 * Represents an Invoice with specified Details
 * The Invoice class extends the Serializable Class
 *
 * @author Fairuz Muhammad
 * @version FINAL
 * @see Serializable
 */

public class Invoice extends Serializable{
    /**
     * The time the invoice was made
     */
    public Timestamp time;
    
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
     * Creates a new Invoice object with the specified buyer and renter IDs.
     * Initializes the invoice with the current timestamp, default rating as NONE, and default status as WAITING.
     * 
     * @param buyerId The ID of the buyer.
     * @param renterId The ID of the renter.
     */
    protected Invoice(int buyerId, int renterId){
        super();
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.time = new Timestamp(System.currentTimeMillis());
        this.rating = rating.NONE;
        this.status = status.WAITING;
    }
    
    /**
     * Creates a new Invoice object with specified buyer and renter.
     * Initializes the invoice with the current timestamp, default rating as NONE, and default status as WAITING.
     * 
     * @param buyer The Account object representing the buyer.
     * @param renter The Renter object representing the renter.
     * @see Account
     * @see Renter
     */
    public Invoice(Account buyer, Renter renter){
        super();
        this.buyerId = buyer.id;
        this.renterId = renter.id;
        this.time = new Timestamp(System.currentTimeMillis());
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
