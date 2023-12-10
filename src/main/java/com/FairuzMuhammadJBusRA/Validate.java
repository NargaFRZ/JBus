package com.FairuzMuhammadJBusRA;
import java.util.ArrayList;

/**
 * A utility class for filtering and processing Price objects based on specified criteria.
 * This class provides static methods to filter Price objects based on specific conditions like price value.
 * 
 * @author Fairuz Muhammad
 * @version FINAL
 */
public class Validate{
    /**
     * Default constructor.
     */
    public Validate(){
    }
    
    /**
     * Filters an array of Price objects based on a specified value and criteria. 
     * This method returns a list of prices that either less than or equal to, 
     * or greater than a specified value, based on the 'less' parameter.
     *
     * @param list An array of Price objects to filter.
     * @param value The value to compare against each Price object's price.
     * @param less A boolean flag that determines the filter criteria:
     *             - If true, the method includes prices less than or equal to the specified value.
     *             - If false, the method includes prices greater than the specified value.
     * @return An ArrayList containing the filtered prices based on the specified criteria.
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
