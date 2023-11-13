package com.FairuzMuhammadJBusRA;

import java.util.List;
import java.util.ArrayList;
import java.sql.Timestamp;
import com.FairuzMuhammadJBusRA.dbjson.Serializable;

/**
 * Represents a bus with specified details
 * The Bus class extends the Serializable Class
 * The Bus class also implements the FileParser interface
 *
 * @author Fairuz Muhammad
 * @version PT4
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
    public List<Facility> facilities;
    
    /**
     * Name of the bus
     */
    public String name;
    
    /**
     * Price details of the Bus
     */
    public Price price;
    
    /**
     * The type of bus according to the BusType enum @see BusType
     */
    public BusType busType;
    
    /**
     * The Station the bus is going to according to the Station class @see Station
     */
    public Station arrival;
    
    /**
     * The Station the bus is departing from according to the Station class @see Station
     */
    public Station departure;
    
    public List<Schedule> schedules;

    public int accountId;
    
    /**
     * Create a new Bus based on the specified details
     * 
     * @param name The name of the Bus
     * @param facilities The facilities of the Bus
     * @param price The price details of the Bus
     * @param capacity The seating capacity of the Bus
     * @param busType The type of Bus
     * @param arrival The station the bus is going to
     * @param departure The station the bus is departing from
     */
    public Bus(int accountId, String name, List<Facility> facilities, Price price, int capacity, BusType busType, Station departure, Station arrival){
        super();
        this.accountId = accountId;
        this.capacity = capacity;
        this.facilities = facilities;
        this.name = name;
        this.price = price;
        this.busType = busType;
        this.arrival = arrival;
        this.departure = departure;
        this.schedules = new ArrayList<>();
    }
    
    /**
     * Returns a string that shows all the Bus details
     * 
     * @return A string containing the Bus details
     */
    public String toString(){
        return  "Bus ID: " + super.id +
                ", Bus Name: " + name +
                ", Facilities: " + facilities +
                ", " + price + 
                ", Capacity: " + capacity +
                ", Bus Type: " + busType + "\n" +
                "Departure: " + "\n" + departure + "\n" +
                "Arrival: " + "\n" + arrival;
    }
    
    public void addSchedule(Timestamp calendar){
        try {
            for (Schedule schedule : this.schedules) {
                if (schedule.departureSchedule.equals(calendar)) {
                    throw new Exception("Jadwal dengan waktu yang sama sudah ada.");
                }
            }
            Schedule newSchedule = new Schedule(calendar, this.capacity);
            this.schedules.add(newSchedule);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Writes the object's data to a file
     *
     * @return An object representation of the written data
     */
    public Object write(){
        return null;
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
