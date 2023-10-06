package FairuzMuhammadJBusRA;

/**
 * Represents a Station with specified Details
 * The Station class extends the Serializable Class
 *
 * @author Fairuz Muhammad
 * @version PT3
 * @see Serializable
 */

public class Station extends Serializable{
    /**
     * The City the Station is on, based on the City enum @see City
     */
    public City city;
    
    /**
     * The Name of the Station
     */
    public String stationName;
    
    /**
     * The address of the Station
     */
    public String address;
    
    /**
     * Construct a new Station object with the specified details
     * 
     * @param id The ID of the station, inherited from the Serializable Class
     * @param stationName The name of the Station
     * @param city The City the Station is on, based on the City enum @see City
     * @param address The address of the Station
     */
    public Station(int id, String stationName, City city, String address){
        super();
        this.stationName = stationName;
        this.city = city;
        this.address = address;
    }
    
    /**
     * Returns a string that shows all the Station details
     * 
     * @return A string containing the Station details
     */
    public String toString(){
        return  "Station ID: " + id + 
                ", Station: " + stationName + 
                ", City: " + city +
                ", Address: " + address;
    }
}
