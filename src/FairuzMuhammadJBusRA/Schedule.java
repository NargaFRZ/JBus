package FairuzMuhammadJBusRA;

import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.text.SimpleDateFormat;
import java.sql.Timestamp;

/**
 * Schedule Class
 *
 * @author Fairuz Muhammad
 * @version PT5
 */
public class Schedule{
    public Timestamp departureSchedule;
    public Map<String, Boolean> seatAvailability = new LinkedHashMap<>();
    
    public Schedule(Timestamp departureSchedule, int numberOfSeats){
        this.departureSchedule = departureSchedule;
        initializeSeatAvailability(numberOfSeats);
    }
    
    private void initializeSeatAvailability(int numberOfSeats) {
        for (int seatNumber = 1; seatNumber <= numberOfSeats; seatNumber++) {
            String sn = seatNumber < 10 ? "0"+seatNumber : ""+seatNumber;
            seatAvailability.put("RA" + sn, true);
        }
    }

    public boolean isSeatAvailable(String seat){
        return seatAvailability.containsKey(seat) && seatAvailability.get(seat);
    }

    public boolean isSeatAvailable(List<String> seats) {
        for (String seat : seats) {
            if(!isSeatAvailable(seat)){
                return false;
            }
        }
        return true;
    }

    public void bookSeat(String seat){
        if(seatAvailability.containsKey(seat)){
            seatAvailability.put(seat, false);
        }
    }

    public void bookSeat(List<String> seats) {
        for (String seat : seats) {
            bookSeat(seat);
        }
    }
    
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

    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long occupied = seatAvailability.values().stream().filter(occupiedSeat -> !occupiedSeat).count();
        return "Schedule : " + dateFormat.format(departureSchedule) + "\nOccupied : " + occupied + "/" + seatAvailability.size();
    }
}
