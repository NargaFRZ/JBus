package com.FairuzMuhammadJBusRA.controller;

import com.FairuzMuhammadJBusRA.*;
import com.FairuzMuhammadJBusRA.dbjson.JsonAutowired;
import com.FairuzMuhammadJBusRA.dbjson.JsonTable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.sql.Timestamp;
import java.util.Map;

/**
 * REST Controller for managing Bus-related operations.
 * 
 * @author Fairuz Muhammad
 * @version FINAL
 */
@RestController
@RequestMapping("/bus")
public class BusController implements BasicGetController<Bus> {
    /**
     * A JsonTable instance for managing Bus entities. It uses the JsonAutowired annotation
     * to specify the class type (Bus) and the file path for the JSON file containing Bus data.
     */
    public static @JsonAutowired(value = Bus.class, filepath = "src/main/java/com/FairuzMuhammadJBusRA/json/buses.json")
    JsonTable<Bus> busTable;

    /**
     * Provides the JSON table associated with the Bus entity.
     * 
     * @return The JSON table for buses.
     */
    public JsonTable<Bus> getJsonTable(){
        return busTable;
    }

    /**
     * Creates a new Bus entity.
     * 
     * @param accountId The ID of the account creating the bus.
     * @param name The name of the bus.
     * @param capacity The capacity of the bus.
     * @param facilities The list of facilities available in the bus.
     * @param busType The type of the bus.
     * @param price The price of the bus service.
     * @param stationDepartureId The ID of the departure station.
     * @param stationArrivalId The ID of the arrival station.
     * @return A BaseResponse containing the created Bus entity or an error message.
     */
    @PostMapping("/create")
    public BaseResponse<Bus> create(
            @RequestParam int accountId,
            @RequestParam String name,
            @RequestParam int capacity,
            @RequestParam List<Facility> facilities,
            @RequestParam BusType busType,
            @RequestParam int price,
            @RequestParam int stationDepartureId,
            @RequestParam int stationArrivalId
        )
    {
        Account account = Algorithm.<Account>find(AccountController.accountTable, pred-> pred.id == accountId);
        if(account == null){
            return new BaseResponse<>(false, "Akun tidak ditemukan", null);
        }

        Station stationDeparture = Algorithm.<Station>find(StationController.stationTable, pred -> pred.id == stationDepartureId);
        Station stationArrival = Algorithm.<Station>find(StationController.stationTable, pred -> pred.id == stationArrivalId);

        if(stationDeparture == null || stationArrival == null) {
            return new BaseResponse<>(false, "Stasiun keberangkatan atau kedatangan tidak ditemukan", null);
        }

        Bus bus = new Bus(accountId, name, facilities, new Price(price), capacity, busType, stationDeparture, stationArrival);
        busTable.add(bus);

        return new BaseResponse<>(true, "Bus berhasil dibuat", bus);
    }

    /**
     * Adds a schedule to a bus.
     * 
     * @param busId The ID of the bus to which the schedule is to be added.
     * @param time The time of the new schedule in "yyyy-MM-dd HH:mm:ss" format.
     * @return A BaseResponse containing the updated Bus entity or an error message.
     */
    @PostMapping("/addSchedule")
    public BaseResponse<Bus> addSchedule(
            @RequestParam int busId,
            @RequestParam String time
            ) {
        try {
            Bus bus = Algorithm.<Bus>find(busTable, b -> b.id == busId);
            if (bus == null) {
                return new BaseResponse<>(false, "Bus not found", null);
            }

            Timestamp scheduleTime;
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                scheduleTime = Timestamp.valueOf(LocalDateTime.parse(time, formatter));
            } catch (DateTimeParseException e) {
                return new BaseResponse<>(false, "Invalid time format", null);
            }

            bus.addSchedule(scheduleTime);

            return new BaseResponse<>(true, "Schedule added successfully", bus);
        } catch (Exception e) {
            return new BaseResponse<>(false, "Error adding schedule: " + e.getMessage(), null);
        }
    }

    /**
     * Retrieves buses owned by a specific account.
     * 
     * @param accountId The ID of the account.
     * @return A list of Bus entities owned by the specified account.
     */
    @GetMapping("/getMyBus")
    public List<Bus> getMyBus(
            @RequestParam int accountId
    ) {
        return Algorithm.<Bus>collect(getJsonTable(), b->b.accountId==accountId);
    }

    /**
     * Retrieves a paginated list of buses.
     * 
     * @param page The page number.
     * @param pageSize The size of the page.
     * @return A list of Bus entities for the specified page.
     */
    @GetMapping("/getBus")
    public List<Bus> getBus(@RequestParam(value = "page", defaultValue = "0") int page,
                            @RequestParam(value = "size", defaultValue = "10") int pageSize) {
        return Algorithm.<Bus>paginate(getJsonTable(), page, pageSize, b -> b.capacity != 0 && b.schedules != null);
    }

    /**
     * Returns the number of buses managed by this controller.
     * 
     * @return The total number of buses.
     */
    @GetMapping("/numberOfBuses")
    public Integer numberOfBuses() {
        return busTable.size();
    }

    /**
     * Retrieves seat availability for a specific bus on a given date.
     * 
     * @param busId The ID of the bus.
     * @param date The date in "yyyy-MM-dd HH:mm:ss" format.
     * @return A map representing the seat availability.
     * @throws ResponseStatusException if the date format is invalid or no schedule is found.
     */
    @GetMapping("/seats")
    public Map<String, Boolean> getSeats(@RequestParam int busId, @RequestParam String date){
        Bus bus = Algorithm.<Bus>find(busTable, b -> b.id == busId);
        Timestamp time;
        try {
            time = Timestamp.valueOf(LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        } catch (DateTimeParseException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid");
        }
        for (Schedule schedule : bus.schedules) {
            if (schedule.departureSchedule.equals(time)) {
                return schedule.seatAvailability;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No schedule found for the given date");
    }
}