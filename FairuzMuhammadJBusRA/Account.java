package FairuzMuhammadJBusRA;

/**
 * Represents an Account with specified Details
 * The Account class extends the Serializable Class
 * The Account class also implements FileParser interface
 *
 * @author Fairuz Muhammad
 * @version CS4
 * @see Serializable
 */

public class Account extends Serializable implements FileParser{
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
    
    /**
     * Returns a string that shows all the account details
     * 
     * @return A string containing the account details
     */
    public String toString(){
        return  "Account ID: " + super.id +
                ", Name: " + name +
                ", Email: " + email +
                ", Password: " + password;
    }
    
    /**
     * Writes the object's data to a file
     * 
     * @return An object representation of the written data
     */
    public Object write(){
        return this;
    }
    
    /**
     * Reads data from a specified file and updates the object's state accordingly
     * 
     * @param filename The name or path of the file to read from
     * @return true if the read operation was successful, otherwise false
     */
    public boolean read(String filename){
        return false;
    }
}