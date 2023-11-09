package com.FairuzMuhammadJBusRA;
import java.util.ArrayList;

/**
 * A utility class for filtering and processing Price objects based on specified criteria
 *
 * @author Fairuz Muhammad
 * @version CS4
 */
public class Validate{
    public Validate(){
    }
    
    /**
     * Filters an array of Price objects based on a specified value and criteria
     * 
     * @param list An array of Price objects
     * @param value The value to compare against each Price object's price
     * @param less Represent if price is less than or equal to the value
     * @return An ArrayList containing the filtered prices
     */
    public static ArrayList filter (Price[] list, int value, boolean less){
        ArrayList<Double> filteredPrices = new ArrayList<>();
        
        for (Price priceObj : list){
            if(less && priceObj.price <= value){
                filteredPrices.add(priceObj.price);
            }
            else if(!less && priceObj.price > value){
                filteredPrices.add(priceObj.price);
            }
        }
        return filteredPrices;
    }
}
