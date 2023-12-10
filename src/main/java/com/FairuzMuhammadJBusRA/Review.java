package com.FairuzMuhammadJBusRA;

import com.FairuzMuhammadJBusRA.dbjson.Serializable;

/**
 * Represents a review with specified details.
 * The Review class extends the Serializable Class for data persistence.
 *
 * @author Fairuz Muhammad
 * @version FINAL
 * @see Serializable
 */
public class Review extends Serializable{
    /**
     * The date when the review was written.
     */
    public String date;
    
    /**
     * The text description of the review.
     */
    public String desc;
    
    /**
     * Constructs a new Review object with the specified details.
     *
     * @param id   The identifier of the review.
     * @param date The date when the review was written.
     * @param desc The text description of the review.
     */
    public Review (int id, String date, String desc){
        super();
        this.date = date;
        this.desc = desc;
    }
    
    /**
     * Returns a string representation of the Review object, including its ID, date, and description.
     *
     * @return A string containing the details of the Review.
     */
    public String toString(){
        return  "Review ID: " + super.id +
                ", Date: " + this.date +
                ", Desc: " + this.desc;
    }
}
