package FairuzMuhammadJBusRA;

import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.text.*;
import java.util.Map;
import java.sql.Timestamp;

/**
 * Represents a bus with specified details
 * The Bus class extends the Serializable Class
 * The Bus class also implements the FileParser interface
 *
 * @author Fairuz Muhammad
 * @version PT4
 * @see Serializable
 */

public class Bus extends Serializable implements FileParser{
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
     * The city the bus is going to
     */
    public City city;
    
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
    
    /**
     * Create a new Bus based on the specified details
     * 
     * @param ID The ID number of the bus, inherited from Serializable class
     * @param name The name of the Bus
     * @param facility The facility of the Bus
     * @param price The price details of the Bus
     * @param capacity The seating capacity of the Bus
     * @param busType The type of Bus
     * @param city The city the Bus is going to
     * @param arrival The station the bus is going to
     * @param departure The station the bus is departing from
     */
    public Bus(String name, Facility facility, Price price, int capacity, BusType busType, City city, Station departure, Station arrival){
        super();
        this.capacity = capacity;
        this.facility = facility;
        this.name = name;
        this.price = price;
        this.busType = busType;
        this.city = city;
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
                ", Facility: " + facility +
                ", " + price + 
                ", Capacity: " + capacity +
                ", Bus Type: " + busType +
                ", City: " + city + "\n" +
                "Departure: " + "\n" + departure + "\n" +
                "Arrival: " + "\n" + arrival;
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
    
    public void addSchedule(Timestamp calendar){
        Schedule newSchedule = new Schedule(calendar, this.capacity);
        this.schedules.add(newSchedule);
    }
    
    /*
    public void printSchedule(Schedule schedule){
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy HH:mm:ss");
        System.out.println("Tanggal keberangkatan: " +sdf.format(schedule.departureSchedule.getTime()));
        System.out.println("Daftar Kursi dan ketersediaan kursinya");
        
        for(Map.Entry<String,Boolean> entry : schedule.seatAvailability.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue() + " ");
        }
    }
    */
}
