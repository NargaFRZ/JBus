package FairuzMuhammadJBusRA;

/**
 * Represents a bus with specified details
 * The Bus class extends the Serializable Class
 *
 * @author Fairuz Muhammad
 * @version CS3
 * @see Serializable
 */

public class Bus extends Serializable{
    /**
     * Seat capacity of the bus
     */
    public int capacity;
    
    /**
     * Facility of the bus, calling another enum which is the Facility enum
     * @see Facility
     */
    public Facility facility;
    
    /**
     * Name of the bus
     */
    public String name;
    
    /**
     * Price details of the Bus
     */
    public Price price;
    
    /**
     * Create a new Bus based on the specified details
     * 
     * @param ID The ID number of the bus, inherited from Serializable class
     * @param name The name of the Bus
     * @param facility The facility of the Bus
     * @param price The price details of the Bus
     * @param capacity The seating capacity of the Bus
     */
    public Bus(int id, String name, Facility facility, Price price, int capacity){
        super(id);
        this.capacity = capacity;
        this.facility = facility;
        this.name = name;
        this.price = price;
    }
}
