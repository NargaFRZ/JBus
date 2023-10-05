package FairuzMuhammadJBusRA;

/**
 * The FileParser interface provides methods for reading and writing data to and from files.
 * 
 * @author Fairuz Muhammad
 * @version CS4
 */
public interface FileParser{
    /**
     * Writes the object's data to a file
     * 
     * @return An object representation of the written data
     */
    Object write();
    
    /**
     * Reads data from a specified file and updates the object's state accordingly
     * 
     * @param filename The name or path of the file to read from
     * @return true if the read operation was successful, otherwise false
     */
    boolean read (String filename);
}
