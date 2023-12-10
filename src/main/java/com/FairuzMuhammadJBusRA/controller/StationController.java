package com.FairuzMuhammadJBusRA.controller;

import com.FairuzMuhammadJBusRA.Bus;
import com.FairuzMuhammadJBusRA.City;
import com.FairuzMuhammadJBusRA.Station;
import com.FairuzMuhammadJBusRA.dbjson.JsonAutowired;
import com.FairuzMuhammadJBusRA.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for handling station-related operations in the application.
 * It provides endpoints for creating new stations and retrieving all stations.
 * @author Fairuz Muhammad
 * @version FINAL
 */
@RestController
@RequestMapping("/station")
public class StationController implements BasicGetController<Station> {
    /**
     * A JsonTable instance for managing Station entities. It uses JsonAutowired annotation
     * to specify the class type (Station) and the file path for the JSON file containing Station data.
     */
    public static @JsonAutowired(value = Station.class, filepath = "src/main/java/com/FairuzMuhammadJBusRA/json/station.json") JsonTable<Station> stationTable;
    
    /**
     * Returns the JsonTable associated with Station entities.
     *
     * @return JsonTable for Station entities.
     */
    @Override
    public JsonTable<Station> getJsonTable() {
        return stationTable;
    }

    /**
     * Endpoint for creating a new station. It creates a new Station entity and records its details.
     *
     * @param stationName The name of the station.
     * @param city The city where the station is located (must match an enum value in City).
     * @param address The address of the station.
     * @return A BaseResponse containing the result of the station creation and the Station object.
     */
    @PostMapping("/create")
    public BaseResponse<Station> createStation(
            @RequestParam String stationName,
            @RequestParam String city,
            @RequestParam String address
    ) {
        try {
            // Validate parameters
            if (stationName.isBlank() || city.isBlank() || address.isBlank()) {
                return new BaseResponse<>(false, "Parameter values cannot be blank or null", null);
            }

            // Validate city as a valid enum value
            City cityEnum = City.valueOf(city.toUpperCase());

            // Create a new station using the provided details
            Station newStation = new Station(stationName, cityEnum, address);

            // Add the new station to the stationTable
            stationTable.add(newStation);

            //Success response message
            return new BaseResponse<>(true, "Station added successfully", newStation);
        } catch (IllegalArgumentException e) {
            // Handle invalid enum value
            return new BaseResponse<>(false, "Invalid city value", null);
        } catch (Exception e) {
            // Handle other unexpected errors
            return new BaseResponse<>(false, "An error occurred while adding the station", null);
        }
    }

    /**
     * Retrieves all stations stored in the system.
     *
     * @return A list of all Station entities.
     */
    @GetMapping("/getAll")
    public List<Station> getAllStation() {
        return getJsonTable();}

}
