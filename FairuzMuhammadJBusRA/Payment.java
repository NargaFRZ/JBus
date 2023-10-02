package FairuzMuhammadJBusRA;

import java.util.Calendar;
import java.text.*;
import java.sql.Timestamp;

/**
 * Represents the Payment with specified Details
 * The Payment class extends the Invoice Class
 *
 * @author Fairuz Muhammad
 * @version PT4
 * @see Invoice
 */
public class Payment extends Invoice{
    /**
     * The ID of the Bus
     * This variable is Private
     */
    private int busId;
    
    /**
     * The departure date of the Bus
     */
    public Timestamp departureDate;
    
    /**
     * The seat number of the Bus
     */
    public String busSeat;
    
    /**
     * Construct a new Payment object with the specified details
     * 
     * @param id The ID of the Bus and Invoice, inherited from the Invoice class
     * @param buyerId The ID of the Buyer, inherited from the Invoice class
     * @param renterId The ID of the Renter, inherited from the Invoice class
     * @param busId The ID of the Bus
     * @param departureDate The departure date of the Bus
     * @param busSeat The seat number of the Bus
     */
    public Payment(int id, int buyerId, int renterId, int busId, String busSeat, Timestamp departureDate){
        super(id, buyerId, renterId);
        this.busId = busId;
        this.departureDate = new Timestamp(departureDate.getTime() + 1000 * 60 * 60 * 24 * 2);
        this.busSeat = busSeat;
    }
    
    /**
     * Construct a new Payment object with the specified details
     * 
     * @param id The ID of the Bus and Invoice, inherited from the Invoice class
     * @param buyerId The ID of the Buyer, inherited from the Invoice class, includes the buyer from the Account class @see Account
     * @param renterId The ID of the Renter, inherited from the Invoice class, includes the renter from the Account class @see Account
     * @param busId The ID of the Bus
     * @param departureDate The departure date of the Bus
     * @param busSeat The seat number of the Bus
     */
    public Payment(int id, Account buyer, Renter renter, int busId, String busSeat, Timestamp departureDate){
        super(id, buyer, renter);
        this.busId = busId;
        this.departureDate = new Timestamp(departureDate.getTime() + 1000 * 60 * 60 * 24 * 2);
        this.busSeat = busSeat;
    }
    
    /**
     * Returns a string containing the details of the Bus
     * 
     * @return A string containing the details of the Bus
     */
    public String getDepartureInfo(){
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy HH:mm:ss");
        return  super.toString() +
                " Bus ID: " + busId +
                " Departure Date: " + sdf.format(departureDate) +
                " Bus Seat: " + busSeat;
    }
    
    public String getTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy HH:mm:ss");
        return sdf.format(time);
    }
    
    /**
     * Get the Bus ID which makes the variable to be able to be accessed
     */
    public int getBusId(){
        return busId;
    }
    
    public static boolean isAvailable(Timestamp departureSchedule, String seat, Bus bus){
        for (Schedule s : bus.schedules){
            if (s.departureSchedule.equals(departureSchedule) && s.isSeatAvailable(seat)){
                return true;
            }
        }
        return false;
    }
    
    public static boolean makeBooking(Timestamp departureSchedule, String seat, Bus bus){
        for (Schedule s : bus.schedules){
            if (s.departureSchedule.equals(departureSchedule) && s.isSeatAvailable(seat)){
                s.bookSeat(seat);
                return true;
            }
        }
        return false;
    }
}
