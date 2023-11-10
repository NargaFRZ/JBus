package com.FairuzMuhammadJBusRA;

import com.FairuzMuhammadJBusRA.dbjson.JsonDBEngine;
import com.FairuzMuhammadJBusRA.dbjson.JsonAutowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.Timestamp;
import java.util.List;

/**
 * Represents the Main part of this java program
 *
 * @author Fairuz Muhammad
 * @version CS5
 */

@SpringBootApplication
public class JBus{
    public JBus(){
    }

    /**
     * Main of the class, includes the testing of the other classes
     */
    public static void main(String[] args) {
        JsonDBEngine.Run(JBus.class);
        SpringApplication.run(JBus.class, args);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> JsonDBEngine.join()));
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