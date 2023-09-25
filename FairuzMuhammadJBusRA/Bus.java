package FairuzMuhammadJBusRA;

/**
 * Represents a bus with specified details
 * The Bus class extends the Serializable Class
 *
 * @author Fairuz Muhammad
 * @version PT3
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
    
    public City city;
    
    public BusType busType;
    
    public Station arrival;
    
    public Station departure;
    
    /**
     * Create a new Bus based on the specified details
     * 
     * @param ID The ID number of the bus, inherited from Serializable class
     * @param name The name of the Bus
     * @param facility The facility of the Bus
     * @param price The price details of the Bus
     * @param capacity The seating capacity of the Bus
     */
    public Bus(int id, String name, Facility facility, Price price, int capacity, BusType busType, City city, Station departure, Station arrival){
        super(id);
        this.capacity = capacity;
        this.facility = facility;
        this.name = name;
        this.price = price;
        this.busType = busType;
        this.city = city;
        this.arrival = arrival;
        this.departure = departure;
    }
    
    public String toString(){
        return  "Bus Id: " + super.id +
                " Bus Name: " + name +
                " Facility: " + facility +
                " Price: " + price +
                " Capacity: " + capacity +
                " Bus Type: " + busType +
                " City: " + city +
                " Departure: " + departure.stationName +
                " Arrival: " + arrival.stationName;
    }
}
