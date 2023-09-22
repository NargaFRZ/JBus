package FairuzMuhammadJBusRA;

/**
 * Represents an Invoice with specified Details
 * The Invoice class extends the Serializable Class
 *
 * @author Fairuz Muhammad
 * @version CS3
 * @see Serializable
 */

public class Invoice extends Serializable{
    /**
     * The time the invoice was made
     */
    public String time;
    
    /**
     * The ID of the buyer
     */
    public int buyerId;
    
    /**
     * The ID of the renter
     */
    public int renterId;
    
    /**
     * Construct a new Invoice object with the specified details
     * This constructor is Protected which means it can only be accessed by the same package or by subclasses
     * 
     * @param id The ID of the invoice, inherited from the Serializable Class
     * @param buyerID The ID of the buyer
     * @param renterId The ID of the renter
     * @param time The time the invoice was made
     */
    protected Invoice(int id, int buyerId, int renterId, String time){
        super(id);
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.time = time;
    }
    
    /**
     * Construct a new Invoice object with the specified details
     * 
     * @param id The ID of the invoice, inherited from the Serializable Class
     * @param buyer The ID of the buyer, from the class Account @see Account
     * @param renter The ID of the renter, from the class Renter @see Renter
     * @param time The time the invoice was made
     */
    public Invoice(int id, Account buyer, Renter renter, String time){
        super(id);
        this.buyerId = buyer.id;
        this.renterId = renter.id;
        this.time = time;
    }
    
    /**
     * Returns a string that shows all the invoice details
     * 
     * @return A string containing the invoice details
     */
    public String print(){
        return "Invoice Id: " + super.id +
                " Buyer Id: " + buyerId +
                " Renter Id: " + renterId +
                " time: " + time;
    }
}