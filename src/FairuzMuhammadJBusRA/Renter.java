package FairuzMuhammadJBusRA;

/**
 * Represents a Renting Company with specified Details
 * The Renter class extends the Serializable Class
 *
 * @author Fairuz Muhammad
 * @version CS3
 * @see Serializable
 */

public class Renter extends Serializable{
    /**
     * Address of the Company
     */
    public String address;
    
    /**
     * Name of the Company
     */
    public String companyName;
    
    /**
     * Phone Number of the Company
     */
    public int phoneNumber;
    
    /**
     * Constructs a new Renter object with the specified details
     * 
     * @param id The ID of the Renting Company, inherited from the Serializable Class
     * @param companyName The name of the Renting Company
     */
    public Renter(int id, String companyName){
        super(id);
        this.companyName = companyName;
        this.address = "";
        this.phoneNumber = 0;
    }
    
    /**
     * Constructs a new Renter object with the specified details
     * 
     * @param id The ID of the Renting Company, inherited from the Serializable Class
     * @param companyName The name of the Renting Company
     * @param address The address of the Renting Company
     */
    public Renter(int id, String companyName, String address){
        super(id);
        this.companyName = companyName;
        this.address = address;
        this.phoneNumber = 0;
    }
    
    /**
     * Constructs a new Renter object with the specified details
     * 
     * @param id The ID of the Renting Company, inherited from the Serializable Class
     * @param companyName The name of the Renting Company
     * @param phoneNumber The phone number of the Renting Company
     */
    public Renter(int id, String companyName, int phoneNumber){
        super (id);
        this.companyName = companyName;
        this.phoneNumber = phoneNumber;
        this.address = "";
    }
    
    /**
     * Constructs a new Renter object with the specified details
     * 
     * @param id The ID of the Renting Company, inherited from the Serializable Class
     * @param companyName The name of the Renting Company
     * @param phoneNumber The phone number of the Renting Company
     * @param address The address of the Renting Company
     */
    public Renter(int id, String companyName, int phoneNumber, String address){
        super (id);
        this.companyName = companyName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}