package FairuzMuhammadJBusRA;
import java.util.Scanner;
import java.util.Calendar;
import java.sql.Timestamp;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import java.util.Set;
import java.util.HashSet;

/**
 * Represents the Main part of this java program
 *
 * @author Fairuz Muhammad
 * @version CS5
 */

public class JBus{
    /**
     * Main of the class, includes the testing of the other classes
     */

    public JBus(){
    }

    public static void main(String[] args) throws InterruptedException {
        /* CS6
        try {
            String filepath = "E:\\Code\\Java\\JBus\\data\\buses_CS.json";
            JsonTable<Bus> busList = new JsonTable<>(Bus.class,filepath);
            Bus filteredBus = filterBusId(busList,155);
            System.out.println(filteredBus.toString());
        }
        catch (Throwable t){
            t.printStackTrace();
        }
         */

        try {
            String filepath = "E:\\Code\\Java\\JBus\\data\\accountDatabase.json";
            JsonTable<Account> AccountList = new JsonTable<>(Account.class, filepath);
            AccountList.add(new Account("Dio", "dio@gmail.com", "NgikNgok"));
            AccountList.writeJson();
            for (Account account : AccountList) {
                System.out.println(account);
            }
        }
        catch (Throwable t){
            t.printStackTrace();
        }

        Bus bus = createBus();
        bus.schedules.forEach(Schedule::printSchedule);
        for(int i =0; i < 10; i++){
            BookingThread thread = new BookingThread("Thread " + i,bus, Timestamp.valueOf("2023-07-27 19:00:00"));
        }
        Thread.sleep(1000);
        bus.schedules.forEach(Schedule::printSchedule);
    }

    public static List<Bus> filterByDeparture(List<Bus> buses, City departure, int page, int pageSize) {
        return Algorithm.paginate(buses, page, pageSize, bus -> bus.departure.city.equals(departure));
    }

    public static List<Bus> filterByPrice(List<Bus> buses, int min, int max){
        return Algorithm.<Bus>collect(buses, bus -> ((bus.price.price >= min) && (bus.price.price <= max)));
    }

    public static Bus filterBusId(List<Bus> buses, int id){
        return Algorithm.<Bus>find(buses, bus -> bus.id == id);
    }

    public static List<Bus> filterByDepartureAndArrival(List<Bus> buses, City departure, City arrival, int page, int pageSize) {
        return Algorithm.paginate(buses, page, pageSize, bus -> bus.departure.city.equals(departure) && bus.arrival.city.equals(arrival));
    }

    public static Bus createBus() {
        Price price = new Price(750000, 5);
        Bus bus = new Bus("Netlab Bus", Facility.LUNCH, price, 25, BusType.REGULER, City.BANDUNG, new Station("Depok Terminal", City.DEPOK, "Jl. Margonda Raya"), new Station("Halte UI", City.JAKARTA, "Universitas Indonesia"));
        Timestamp timestamp = Timestamp.valueOf("2023-07-27 19:00:00");
        bus.addSchedule(timestamp);
        return bus;
    }
}