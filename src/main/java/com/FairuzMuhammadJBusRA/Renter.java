package com.FairuzMuhammadJBusRA;

import com.FairuzMuhammadJBusRA.dbjson.Serializable;

/**
 * Represents a renting company with specific details.
 * The Renter class extends the Serializable class to allow serialization.
 *
 * @author Fairuz Muhammad
 * @version FINAL
 * @see Serializable
 */

public class Renter extends Serializable{
    /**
     * Address of the renting company.
     */
    public String address;
    
    /**
     * Name of the renting company.
     */
    public String companyName;
    
    /**
     * Phone number of the renting company.
     */
    public String phoneNumber;

    /**
     * Regular expression pattern for validating the name of the renting company.
     * The pattern requires the name to start with an uppercase letter followed by
     * 4 to 20 alphanumeric characters or underscores.
     */
    private static final String REGEX_NAME = "^[A-Z][a-zA-Z0-9_]{4,20}$";

    /**
     * Regular expression pattern for validating the phone number of the renting company.
     * The pattern requires the phone number to consist of 9 to 12 numeric digits.
     */
    private static final String REGEX_PHONE_NUMBER = "^[0-9]{9,12}$";
    
    /**
     * Constructs a new Renter object with the specified company name.
     * The address and phone number are initialized to empty strings.
     *
     * @param companyName The name of the renting company.
     */
    public Renter(String companyName){
        super();
        this.companyName = companyName;
        this.address = "";
        this.phoneNumber = "";
    }

    /**
     * Constructs a new Renter object with the specified company name and phone number.
     * The address is initialized to an empty string.
     *
     * @param companyName The name of the renting company.
     * @param phoneNumber The phone number of the renting company.
     */
    public Renter(String companyName, String phoneNumber){
        super();
        this.companyName = companyName;
        this.phoneNumber = phoneNumber;
        this.address = "";
    }

    /**
     * Constructs a new Renter object with specified company name, address, and phone number.
     *
     * @param companyName The name of the renting company.
     * @param address     The address of the renting company.
     * @param phoneNumber The phone number of the renting company.
     */
    public Renter(String companyName, String address, String phoneNumber){
        super ();
        this.companyName = companyName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    /**
     * Validates the company name and phone number against specified regular expressions.
     *
     * @return true if both the company name and phone number are valid, false otherwise.
     */
    public boolean validate(){
        if (this.companyName.matches(REGEX_NAME) && this.phoneNumber.matches(REGEX_PHONE_NUMBER)){
            return true;
        }
        return false;
    }
}