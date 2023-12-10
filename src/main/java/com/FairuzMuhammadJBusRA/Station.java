package com.FairuzMuhammadJBusRA;

import com.FairuzMuhammadJBusRA.dbjson.Serializable;

/**
 * Represents a Station with specific details, including its name, city, and address.
 * This class extends the Serializable class, allowing it to be serialized for data storage and retrieval.
 *
 * @author Fairuz Muhammad
 * @version FINAL
 * @see Serializable
 */

public class Station extends Serializable{
    /**
     * The city where the station is located. The city is represented by an enum value.
     */
    public City city;
    
    /**
     * The name of the station.
     */
    public String stationName;
    
    /**
     * The address of the station.
     */
    public String address;
    
    /**
     * Constructs a new Station object with the specified details.
     *
     * @param stationName The name of the station.
     * @param city        The city where the station is located, based on the City enum.
     * @param address     The address of the station.
     */
    public Station(String stationName, City city, String address){
        super();
        this.stationName = stationName;
        this.city = city;
        this.address = address;
    }
    
    /**
     * Returns a string representation of the Station object, including its ID, name, city, and address.
     *
     * @return A string containing the details of the station.
     */
    public String toString(){
        return  "Station ID: " + id + 
                ", Station: " + stationName + 
                ", City: " + city +
                ", Address: " + address;
    }
}
