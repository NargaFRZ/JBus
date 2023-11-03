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
    public static void main(String[] args) {
        //TP Modul 6
        /*
        String filepath = "E:\\Code\\Java\\JBus\\data\\station.json";
        Gson gson = new Gson();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath));
            List<Station> stationjson = gson.fromJson(bufferedReader, new TypeToken<List<Station>>() {
            }.getType());
            stationjson.forEach(e -> System.out.println(e.toString()));
            System.out.println();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
         */

        try {
            String filepath = "E:\\Code\\Java\\JBus\\data\\buses_CS.json";
            JsonTable<Bus> busList = new JsonTable<>(Bus.class,filepath);
            Bus filteredBus = filterBusId(busList,155);
            System.out.println(filteredBus.toString());
        }
        catch (Throwable t){
            t.printStackTrace();
        }

    }

    public static List<Bus> filterByDeparture(List<Bus> buses, City departure, int page, int pageSize) {
        return Algorithm.paginate(buses, page, pageSize, bus -> bus.departure.city.equals(departure));
    }

    public static List<Bus> filterByPrice(List<Bus> buses, int min, int max){
        return Algorithm.<Bus>collect(buses, bus -> bus.price.price >= min && bus.price.price <= max );
    }

    public static Bus filterBusId(List<Bus> buses, int id){
        return Algorithm.<Bus>find(buses, bus -> bus.id == id);
    }

    public static List<Bus> filterByDepartureAndArrival(List<Bus> buses, City departure, City arrival, int page, int pageSize) {
        return Algorithm.paginate(buses, page, pageSize, bus -> bus.departure.city.equals(departure) && bus.arrival.city.equals(arrival));
    }
}
