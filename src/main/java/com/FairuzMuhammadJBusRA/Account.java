package com.FairuzMuhammadJBusRA;

/**
 * Represents an Account with specified Details
 * The Account class extends the Serializable Class
 * The Account class also implements FileParser interface
 *
 * @author Fairuz Muhammad
 * @version CS4
 * @see Serializable
 */

public class Account extends Serializable{
    /**
     * Email of the account
     */
    public String email;
    
    /**
     * Name of the account
     */
    public String name;
    
    /**
     * Password of the Account
     */
    public String password;

    public static final String REGEX_EMAIL = "^[a-zA-Z0-9][a-zA-Z0-9]+@[a-zA-Z.]+?\\.[a-zA-Z]+?$";
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
    
    /**
     * Construct a new Account with the specified Details
     *
     * @param name The Name of the Account
     * @param email The Email of the Account
     * @param password The Password of the Account
     */
    public Account(String name, String email, String password){
        super();
        this.name = name;
        this.email = email;
        this.password = password;
    }
    
    /**
     * Returns a string that shows all the account details
     * 
     * @return A string containing the account details
     */
    public String toString() {
        return "Account ID: " + super.id +
                ", Name: " + name +
                ", Email: " + email +
                ", Password: " + password;
    }

    public boolean validate(){
        if (this.email.matches(REGEX_EMAIL) && this.password.matches(REGEX_PASSWORD)){
            return true;
        }
        return false;
    }
}