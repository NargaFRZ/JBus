package com.FairuzMuhammadJBusRA;

import java.util.List;
import java.text.*;
import java.sql.Timestamp;

/**
 * Represents a Payment with specified details. 
 * The Payment class extends the Invoice class and includes additional details specific to bus bookings.
 *
 * @author Fairuz Muhammad
 * @version FINAL
 * @see Invoice
 */
public class Payment extends Invoice{
    /**
     * The ID of the Bus associated with this payment.
     */
    private int busId;
    
    /**
     * The departure date and time of the Bus.
     */
    public Timestamp departureDate;

    /**
     * A list of seat numbers booked on the Bus.
     */
    public List<String> busSeat;
    
    /**
     * Creates a new Payment object with the specified details.
     *
     * @param buyerId The ID of the buyer, inherited from the Invoice class.
     * @param renterId The ID of the renter, inherited from the Invoice class.
     * @param busId The ID of the Bus.
     * @param busSeat A list of seat numbers of the Bus.
     * @param departureDate The departure date and time of the Bus.
     */
    public Payment(int buyerId, int renterId, int busId, List<String> busSeat, Timestamp departureDate){
        super(buyerId, renterId);
        this.busId = busId;
        this.departureDate = new Timestamp(departureDate.getTime());
        this.busSeat = busSeat;
    }
    
    /**
     * Constructor for Payment object using Account and Renter instances.
     * Initializes a new payment instance for a specific bus booking.
     *
     * @param buyer Account instance representing the buyer. @see Renter
     * @param renter Renter instance representing the renter. @see Account
     * @param busId The ID of the Bus associated with the payment.
     * @param busSeat List of seat numbers booked.
     * @param departureDate The departure date and time of the bus.
     */
    public Payment(Account buyer, Renter renter, int busId, List<String> busSeat, Timestamp departureDate){
        super(buyer, renter);
        this.busId = busId;
        this.departureDate = new Timestamp(departureDate.getTime());
        this.busSeat = busSeat;
    }
    
    /**
     * Provides detailed information about the payment and associated bus booking.
     *
     * @return String representation of payment details including bus information.
     */
    public String getDepartureInfo(){
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy HH:mm:ss");
        return  super.toString() +
                " Bus ID: " + busId +
                " Departure Date: " + sdf.format(departureDate) +
                " Bus Seat: " + busSeat;
    }
    
    /**
     * Formats and returns the payment time.
     *
     * @return Formatted string of the payment time.
     */
    public String getTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy HH:mm:ss");
        return sdf.format(time);
    }
    
    /**
     * Retrieves the Bus ID associated with this payment.
     *
     * @return The Bus ID.
     */
    public int getBusId(){
        return busId;
    }

    /**
     * Checks the availability of a specific seat on a given schedule.
     * 
     * @param departureSchedule The departure schedule of the bus.
     * @param seat The seat to check availability for.
     * @param bus The bus instance.
     * @return Schedule instance if available, null otherwise.
     */
    public static Schedule availableSchedule(Timestamp departureSchedule, String seat, Bus bus){
        for(Schedule s : bus.schedules){
            if(s.departureSchedule.equals(departureSchedule) && s.isSeatAvailable(seat)){
                return s;
            }
        }
        return null;
    }

    /**
     * Checks the availability of multiple seats on a given schedule.
     * 
     * @param departureSchedule The departure schedule of the bus.
     * @param seats List of seats to check availability for.
     * @param bus The bus instance.
     * @return Schedule instance if available, null otherwise.
     */
    public static Schedule availableSchedule(Timestamp departureSchedule, List<String> seats, Bus bus) {
        for(Schedule s : bus.schedules) {
            if(s.departureSchedule.equals(departureSchedule) && s.isSeatAvailable(seats)) {
                return s;
            }
        }
        return null;
    }

    /**
     * Books a specific seat on a given schedule if available.
     * 
     * @param departureSchedule The departure schedule of the bus.
     * @param seat The seat to book.
     * @param bus The bus instance.
     * @return True if booking is successful, false otherwise.
     */
    public static boolean makeBooking(Timestamp departureSchedule, String seat, Bus bus){
        Schedule availableSchedule = availableSchedule(departureSchedule, seat, bus);
        if(availableSchedule!=null){
            availableSchedule.bookSeat(seat);
            return true;
        }
        return false;
    }

    /**
     * Books multiple seats on a given schedule if available.
     * 
     * @param departureSchedule The departure schedule of the bus.
     * @param seats List of seats to book.
     * @param bus The bus instance.
     * @return True if booking is successful, false otherwise.
     */
    public static boolean makeBooking(Timestamp departureSchedule, List<String> seats, Bus bus) {
        Schedule availableSchedule = availableSchedule(departureSchedule, seats, bus);
        if (availableSchedule != null) {
            if (availableSchedule.isSeatAvailable(seats)) {
                availableSchedule.bookSeat(seats);
                return true;
            }
        }
        return false;
    }
}