package FairuzMuhammadJBusRA;

import java.util.Calendar;
import java.util.Map;
import java.util.LinkedHashMap;

/**
 * Schedule Class
 *
 * @author Fairuz Muhammad
 * @version CS4
 */
public class Schedule{
    public Calendar departureSchedule;
    public Map<String, Boolean> seatAvailability;
    
    public Schedule(Calendar departureSchedule, int numberOfSeats){
        this.departureSchedule = departureSchedule;
        initializeSeatAvailability(numberOfSeats);
    }
    
    private void initializeSeatAvailability(int numberOfSeats){
        seatAvailability = new LinkedHashMap<>();
        int seatNumber;
        for(seatNumber=1;seatNumber<=numberOfSeats;seatNumber++){
            seatAvailability.put("RA" + seatNumber, true);
        }
    }
}
