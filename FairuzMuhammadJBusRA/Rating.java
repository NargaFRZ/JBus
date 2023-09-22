package FairuzMuhammadJBusRA;

/**
 * Represents the Rating given by the Customer
 *
 * @author Fairuz Muhammad
 * @version CS1
 */

public class Rating{
    /**
     * How many person have given a rating
     * This is a private variable
     */
    private long count;
    
    /**
     * The total of the rating score given
     * This is a private variable
     */
    private long total;
    
    /**
     * Construct a Rating with the total and count set to 0
     */
    public Rating(){
        this.total = 0;
        this.count = 0; 
    }
    
    /**
     * Insert a rating, which adds to the total and also add to the count
     * 
     * @param rating The rating that was given
     */
    public void insert(int rating){
        this.total += rating;
        this.count++;
    }
    
    /**
     * Get the average of the rating
     * 
     * @return Returns 0 if the count is 0 else Returns The average from the rating with the formula Total/Rating
     */
    public double getAverage(){
        double rating;
        
        if(this.count == 0){
            return 0;
        }
        
        rating = this.total / this.count;
        return rating;
    }
    
    /**
     * Makes the Count variable to be able to be accessed
     */
    public long getCount(){
        return this.count;
    }
    
    /**
     * Makes the Total variable to be able to be accessed
     */
    public long getTotal(){
        return this.total;
    }
}
