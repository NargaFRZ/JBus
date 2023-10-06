package FairuzMuhammadJBusRA;
import java.util.HashMap;

/**
 * Represents a serializable object with ID;
 *
 * @author Fairuz Muhammad
 * @version CS5
 */

public class Serializable{
    /**
     * The ID of Serializable object
     */
    public final int id;
    private static HashMap<Class<?>, Integer> mapCounter = new HashMap<>();

    /**
     * Constructs a new Serializable object with specified ID
     */
    protected Serializable (){
        this.id = mapCounter.getOrDefault(getClass(), 0);
        mapCounter.put(getClass(), this.id + 1);
    }

    public static <T> Integer getLastAssignedId(Class<T> cls){
        return mapCounter.get(cls);
    }

    public static <T> Integer setLastAssignedId(Class<T> cls, int id){
        return mapCounter.put(cls, id);
    }

    public int compareTo(Serializable o){
        return Integer.compare(this.id, o.id);
    }

    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj instanceof Serializable){
            Serializable other = (Serializable) obj;
            return this.id == other.id;
        }
        return false;
    }

    public boolean equals(Serializable obj){
        return this.id == obj.id;
    }
}