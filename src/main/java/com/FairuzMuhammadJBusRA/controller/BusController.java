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

@RestController
@RequestMapping("/bus")
public class BusController implements BasicGetController<Bus> {
    public static @JsonAutowired(value = Bus.class, filepath = "src/main/java/com/FairuzMuhammadJBusRA/json/buses.json")
    JsonTable<Bus> busTable;

    public JsonTable<Bus> getJsonTable(){
        return busTable;
    }

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

            // Parse the time string to a Timestamp
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
}