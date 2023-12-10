package com.FairuzMuhammadJBusRA;

/**
 * Represents a rating system, tracking the total number of ratings and their cumulative score.
 * It allows for inserting new ratings and calculating the average rating.
 *
 * @author Fairuz Muhammad
 * @version FINAL
 */

public class Rating{
    /**
     * The count of ratings received.
     * This variable is private to ensure data encapsulation.
     */
    private long count;
    
    /**
     * The cumulative score of all ratings.
     * This variable is private to maintain the integrity of the rating system.
     */
    private long total;
    
    /**
     * Constructs a new Rating object with initial total and count set to 0.
     */
    public Rating(){
        this.total = 0;
        this.count = 0; 
    }
    
    /**
     * Adds a new rating to this rating system. It increases the total rating score and increments the count.
     *
     * @param rating The rating score to add. It should be a positive integer.
     */
    public void insert(int rating){
        this.total += rating;
        this.count++;
    }
    
    /**
     * Calculates the average rating.
     * If no ratings have been added, returns 0.
     *
     * @return The average rating as a double. Returns 0 if count is 0.
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
     * Retrieves the count of ratings received.
     *
     * @return The count of ratings.
     */
    public long getCount(){
        return this.count;
    }
    
    /**
     * Retrieves the total cumulative score of the ratings.
     *
     * @return The total cumulative score.
     */
    public long getTotal(){
        return this.total;
    }
    
    /**
     * Returns a string representation of the Rating object, including total and count of ratings.
     *
     * @return A string detailing the total and count of ratings.
     */
    public String toString(){
        return  "Count: " + count +
                ", Total: " + total;
    }
}
