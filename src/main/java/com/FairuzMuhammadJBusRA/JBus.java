package com.FairuzMuhammadJBusRA;

import com.FairuzMuhammadJBusRA.dbjson.JsonDBEngine;
import com.FairuzMuhammadJBusRA.dbjson.JsonAutowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.Timestamp;
import java.util.List;

/**
 * Main class for the JBus application.
 * This class initializes and runs the application using Spring Boot and provides utility methods for bus filtering.
 *
 * @author Fairuz Muhammad
 * @version FINAL
 */
@SpringBootApplication
public class JBus{
    public JBus(){
    }

    /**
     * The main method that starts the JBus application.
     * It initializes the JsonDBEngine and runs the Spring Boot application.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        JsonDBEngine.Run(JBus.class);
        SpringApplication.run(JBus.class, args);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> JsonDBEngine.join()));
    }

    /**
     * Filters a list of buses by their departure city and supports pagination.
     *
     * @param buses The list of buses to filter.
     * @param departure The departure city to filter by.
     * @param page The page number for pagination.
     * @param pageSize The number of items per page.
     * @return A list of buses that match the departure city criteria.
     */
    public static List<Bus> filterByDeparture(List<Bus> buses, City departure, int page, int pageSize) {
        return Algorithm.paginate(buses, page, pageSize, bus -> bus.departure.city.equals(departure));
    }

    /**
     * Filters a list of buses by price range.
     *
     * @param buses The list of buses to filter.
     * @param min The minimum price.
     * @param max The maximum price.
     * @return A list of buses within the specified price range.
     */
    public static List<Bus> filterByPrice(List<Bus> buses, int min, int max){
        return Algorithm.<Bus>collect(buses, bus -> ((bus.price.price >= min) && (bus.price.price <= max)));
    }

    /**
     * Finds a bus from a list of buses by its ID.
     *
     * @param buses The list of buses to search through.
     * @param id The ID of the bus to find.
     * @return The bus with the specified ID, or null if not found.
     */
    public static Bus filterBusId(List<Bus> buses, int id){
        return Algorithm.<Bus>find(buses, bus -> bus.id == id);
    }

    /**
     * Filters a list of buses by both departure and arrival cities and supports pagination.
     *
     * @param buses The list of buses to filter.
     * @param departure The departure city to filter by.
     * @param arrival The arrival city to filter by.
     * @param page The page number for pagination.
     * @param pageSize The number of items per page.
     * @return A list of buses that match both departure and arrival city criteria.
     */
    public static List<Bus> filterByDepartureAndArrival(List<Bus> buses, City departure, City arrival, int page, int pageSize) {
        return Algorithm.paginate(buses, page, pageSize, bus -> bus.departure.city.equals(departure) && bus.arrival.city.equals(arrival));
    }
}