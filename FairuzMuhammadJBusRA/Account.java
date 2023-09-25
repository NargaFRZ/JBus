package FairuzMuhammadJBusRA;

/**
 * Represents an Account with specified Details
 * The Account class extends the Serializable Class
 *
 * @author Fairuz Muhammad
 * @version PT3
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
    
    /**
     * Construct a new Account with the specified Details
     * 
     * @param id The ID of the Account, inherited from class Serializable
     * @param name The Name of the Account
     * @param email The Email of the Account
     * @param password The Password of the Account
     */
    public Account(int id, String name, String email, String password){
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
    }
    
    public String toString(){
        return  "Account Id: " + super.id +
                " Name: " + name +
                " Email: " + email +
                " Password: " + password;
    }
}