package com.FairuzMuhammadJBusRA.dbjson;
import java.util.HashMap;

/**
 * Represents a serializable object with a unique ID. This class is used as a base
 * for objects that require serialization and identification through a unique ID.
 *
 * @author Fairuz Muhammad
 * @version FINAL
 */

public class Serializable implements Comparable<Serializable>{
    /**
     * The unique ID of the Serializable object.
     */
    public final int id;

    /**
     * A map to keep track of the last assigned ID for each class type.
     */
    private static HashMap<Class<?>, Integer> mapCounter = new HashMap<Class <?>, Integer>();

    /**
     * Constructs a new Serializable object and assigns a unique ID to it.
     * The ID is generated based on the count of objects of its class type.
     */
    protected Serializable(){
        Integer counter = mapCounter.get(getClass());
        counter = counter == null ? 0 : counter + 1;
        mapCounter.put(getClass(), counter);
        this.id = counter;
    }

    /**
     * Retrieves the last assigned ID for a given class type.
     *
     * @param <T> The type of the class.
     * @param getter The class for which to get the last assigned ID.
     * @return The last assigned ID for the specified class, or null if no ID has been assigned.
     */
    public static <T> Integer getLastAssignedId(Class<T> getter ){
        return mapCounter.get(getter);
    }

    /**
     * Sets the last assigned ID for a given class type.
     *
     * @param <T> The type of the class.
     * @param setter The class for which to set the last assigned ID.
     * @param number The ID to set as the last assigned ID.
     * @return The previous ID associated with the class, or null if none was set previously.
     */
    public static <T> Integer setLastAssignedId(Class<T> setter, int number){
        return mapCounter.put(setter, number);
    }

    /**
     * Compares this Serializable object with another Serializable object based on their IDs.
     *
     * @param temp The Serializable object to be compared.
     * @return A negative integer, zero, or a positive integer as this object's ID
     *         is less than, equal to, or greater than the specified object's ID.
     */
    public int compareTo(Serializable temp){
        return ((Integer)this.id).compareTo(temp.id);
    }

    /**
     * Checks if this Serializable object is equal to another Serializable object based on their IDs.
     *
     * @param temp The Serializable object to be compared for equality.
     * @return true if the specified object's ID is equal to this object's ID, false otherwise.
     */
    public boolean equals(Serializable temp){
        return temp.id == this.id;
    }

    /**
     * Checks if this Serializable object is equal to another object.
     *
     * @param object The object to be compared for equality.
     * @return true if the specified object is a Serializable and its ID is equal to this object's ID, false otherwise.
     */
    public boolean equals(Object object){
        return object instanceof Serializable && ((Serializable) object).id == this.id;
    }
}