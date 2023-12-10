package com.FairuzMuhammadJBusRA;

import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.text.SimpleDateFormat;
import java.sql.Timestamp;

/**
 * Represents a schedule for a bus with specific departure times and seat availability.
 * This class is responsible for managing seat bookings and checking seat availability.
 *
 * @author Fairuz Muhammad
 * @version FINAL
 */
public class Schedule{
    /**
     * The scheduled departure time of the bus.
     */
    public Timestamp departureSchedule;

    /**
     * A map representing the availability of each seat. A value of true indicates the seat is available.
     */
    public Map<String, Boolean> seatAvailability = new LinkedHashMap<>();
    
    /**
     * Constructs a new Schedule object with a specified departure time and number of seats.
     *
     * @param departureSchedule The scheduled departure time of the bus.
     * @param numberOfSeats     The total number of seats available in the bus.
     */
    public Schedule(Timestamp departureSchedule, int numberOfSeats){
        this.departureSchedule = departureSchedule;
        initializeSeatAvailability(numberOfSeats);
    }
    
    /**
     * Initializes seat availability for a given number of seats.
     *
     * @param numberOfSeats The total number of seats to be initialized.
     */
    private void initializeSeatAvailability(int numberOfSeats) {
        for (int seatNumber = 1; seatNumber <= numberOfSeats; seatNumber++) {
            String sn = seatNumber < 10 ? "0"+seatNumber : ""+seatNumber;
            seatAvailability.put("RA" + sn, true);
        }
    }

    /**
     * Checks if a specific seat is available.
     *
     * @param seat The seat identifier.
     * @return True if the seat is available, otherwise false.
     */
    public boolean isSeatAvailable(String seat){
        return seatAvailability.containsKey(seat) && seatAvailability.get(seat);
    }

    /**
     * Checks if a list of seats are all available.
     *
     * @param seats The list of seat identifiers.
     * @return True if all seats are available, otherwise false.
     */
    public boolean isSeatAvailable(List<String> seats) {
        for (String seat : seats) {
            if(!isSeatAvailable(seat)){
                return false;
            }
        }
        return true;
    }

    /**
     * Books a specific seat, marking it as occupied.
     *
     * @param seat The seat identifier to be booked.
     */
    public void bookSeat(String seat){
        if(seatAvailability.containsKey(seat)){
            seatAvailability.put(seat, false);
        }
    }

    /**
     * Books a list of seats, marking them as occupied.
     *
     * @param seats The list of seat identifiers to be booked.
     */
    public void bookSeat(List<String> seats) {
        for (String seat : seats) {
            bookSeat(seat);
        }
    }
    
    /**
     * Prints the current schedule and seat availability.
     */
    public void printSchedule() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM d, yyyy HH:mm:ss");
        String formattedDepartureSchedule = dateFormat.format(this.departureSchedule);
        
        //Print tanggal keberangkatan
        System.out.println("Tanggal keberangkatan: " + formattedDepartureSchedule);
        
        //Print daftar kursi dan ketersediaan kursinya
        System.out.println("Daftar kursi dan ketersediaan kursinya: ");
        
        //Create a list of seats and sort them numerically
        int maxSeatsPerRow = 4; // Assuming there are 4 seats per row
        int currentSeat = 1;
        for (String seat : this.seatAvailability.keySet()) {
            String symbol = this.seatAvailability.get(seat) ? "O" : "X";
            System.out.print(seat + " : " + symbol + "\t");
            if (currentSeat % maxSeatsPerRow == 0) {
                System.out.println();
            }
            currentSeat++;
        }
        System.out.println("\n");
    }

    /**
     * Returns a string representation of the Schedule object, including departure time and seat occupancy.
     *
     * @return A string containing the schedule and seat occupancy details.
     */
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long occupied = seatAvailability.values().stream().filter(occupiedSeat -> !occupiedSeat).count();
        return "Schedule : " + dateFormat.format(departureSchedule) + "\nOccupied : " + occupied + "/" + seatAvailability.size();
    }
}
