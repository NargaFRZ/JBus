package com.FairuzMuhammadJBusRA;

import com.FairuzMuhammadJBusRA.dbjson.Serializable;

/**
 * Represents an Account with specified details.
 * The Account class extends the Serializable class and implements FileParser interface.
 * It includes details such as name, email, and password of the account.
 * 
 * @author Fairuz Muhammad
 * @version FINAL
 * @see Serializable
 */

public class Account extends Serializable{
    /**
     * Email of the account
     */
    public String email;
    
    /**
     * Name of the account holder.
     */
    public String name;
    
    /**
     * Company associated with the account, if any.
     */
    public String password;

    /**
     * Balance of the account.
     */
    public Renter company;

    /**
     * Regular expression for validating email addresses.
     */
    public double balance;

    /**
     * Regular expression for validating email addresses.
     */
    public static final String REGEX_EMAIL = "^[a-zA-Z0-9]+@[a-zA-Z_]+?\\.[a-zA-Z.]+[a-zA-Z]+$";

     /**
     * Regular expression for validating passwords.
     * Passwords must contain at least one lowercase letter, one uppercase letter, and one digit,
     * and must be at least 8 characters long.
     */
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
    
    /**
     * Constructs a new Account with the specified details.
     *
     * @param name     The name of the account holder.
     * @param email    The email address of the account.
     * @param password The password for the account.
     */
    public Account(String name, String email, String password){
        super();
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = 0;
        this.company = null;
    }
    
    /**
     * Returns a string representation of the account details.
     *
     * @return A string containing the account details including ID, name, email, and password.
     */
    public String toString() {
        return "Account ID: " + super.id +
                ", Name: " + name +
                ", Email: " + email +
                ", Password: " + password;
    }

    /**
     * Validates the email and password of the account against specified regular expressions.
     *
     * @return True if both email and password are valid as per their respective regular expressions.
     */
    public boolean validate(){
        if (this.email.matches(REGEX_EMAIL) && this.password.matches(REGEX_PASSWORD)){
            return true;
        }
        return false;
    }

    /**
     * Increases the account balance by the specified amount.
     * 
     * @param amount The amount to add to the account balance. Must be a positive number.
     * @return True if the top-up operation is successful (amount is positive), false otherwise.
     */
    public boolean topUp(double amount){
        if(amount <= 0){
            return false;
        }
        this.balance += amount;
        return true;
    }
}