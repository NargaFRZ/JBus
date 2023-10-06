package FairuzMuhammadJBusRA;


/**
 * Represent the review given with the specified details
 * The Review class extends the Serializable Class
 *
 * @author Fairuz Muhammad
 * @version PT3
 */
public class Review extends Serializable{
    /**
     * The date the review was made
     */
    public String date;
    
    /**
     * The description of the review
     */
    public String desc;
    
    /**
     * Construct a new review based on the specified details
     * 
     * @param id The id of the review
     * @param date The date the review was made
     * @param desc The description of the review
     */
    public Review (int id, String date, String desc){
        super();
        this.date = date;
        this.desc = desc;
    }
    
    /**
     * Returns a string that shows all the Review details
     * 
     * @return A string containing the Review details
     */
    public String toString(){
        return  "Review ID: " + super.id +
                ", Date: " + this.date +
                ", Desc: " + this.desc;
    }
}
