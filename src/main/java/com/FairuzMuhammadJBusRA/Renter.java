package com.FairuzMuhammadJBusRA;

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
    public String phoneNumber;

    private static final String REGEX_NAME = "^[A-Z][a-zA-Z0-9_]{4,20}$";

    private static final String REGEX_PHONE_NUMBER = "^[0-9]{9,12}$";
    
    /**
     * Constructs a new Renter object with the specified details
     *
     * @param companyName The name of the Renting Company
     */
    public Renter(String companyName){
        super();
        this.companyName = companyName;
        this.address = "";
        this.phoneNumber = "";
    }

    /**
     * Constructs a new Renter object with the specified details
     *
     * @param companyName The name of the Renting Company
     * @param phoneNumber The phone number of the Renting Company
     */
    public Renter(String companyName, String phoneNumber){
        super();
        this.companyName = companyName;
        this.phoneNumber = phoneNumber;
        this.address = "";
    }

    /**
     * Constructs a new Renter object with the specified details
     *
     * @param companyName The name of the Renting Company
     * @param phoneNumber The phone number of the Renting Company
     * @param address The address of the Renting Company
     */
    public Renter(String companyName, String phoneNumber, String address){
        super ();
        this.companyName = companyName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public boolean validate(){
        if (this.companyName.matches(REGEX_NAME) && this.phoneNumber.matches(REGEX_PHONE_NUMBER)){
            return true;
        }
        return false;
    }
}