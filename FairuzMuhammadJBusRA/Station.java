package FairuzMuhammadJBusRA;

/**
 * Represents a Station with specified Details
 * The Station class extends the Serializable Class
 *
 * @author Fairuz Muhammad
 * @version CS3
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
     * Construct a new Station object with the specified details
     * 
     * @param id The ID of the station, inherited from the Serializable Class
     * @param stationName The name of the Station
     * @param city The City the Station is on, based on the City enum @see City
     */
    public Station(int id, String stationName, City city){
        super(id);
        this.stationName = stationName;
        this.city = city;
    }
    
    /**
     * Returns a string that shows all the Station details
     * 
     * @return A string containing the Station details
     */
    public String print(){
        return  "Station ID: " + id + 
                " Station: " + stationName + 
                " City: " + city; 
    }
}
