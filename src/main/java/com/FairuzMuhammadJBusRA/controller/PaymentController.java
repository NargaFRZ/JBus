package com.FairuzMuhammadJBusRA.controller;

import com.FairuzMuhammadJBusRA.*;
import com.FairuzMuhammadJBusRA.dbjson.JsonAutowired;
import com.FairuzMuhammadJBusRA.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment> {
    public static @JsonAutowired(value = Payment.class, filepath = "src/main/java/com/FairuzMuhammadJBusRA/json/payment.json")
    JsonTable<Payment> paymentTable;

    public JsonTable<Payment> getJsonTable() {
        return PaymentController.paymentTable;
    }

    @RequestMapping(value="/makeBooking", method= RequestMethod.POST)
    public BaseResponse<Payment> makeBooking(
            @RequestParam int buyerId,
            @RequestParam int renterId,
            @RequestParam int busId,
            @RequestParam List<String> busSeats,
            @RequestParam String departureDate
        )
    {
        Account buyer = Algorithm.<Account>find(AccountController.accountTable, a -> a.id == buyerId);
        Account accrenter = Algorithm.<Account>find(AccountController.accountTable, a -> a.company.id == renterId);
        Renter renter = accrenter.company;
        Bus bus = Algorithm.<Bus>find(BusController.busTable, b -> b.id == busId);

        if (buyer == null || bus == null) {
            return new BaseResponse<>(false, "Pembeli atau Bus tidak ditemukan", null);
        }

        if (buyer.balance < bus.price.price) {
            return new BaseResponse<>(false, "Balance kurang", null);
        }

        Timestamp departureTimestamp;
        try {
            departureTimestamp = Timestamp.valueOf(LocalDateTime.parse(departureDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        } catch (DateTimeParseException e) {
            return new BaseResponse<>(false, "Invalid", null);
        }

        boolean bookingMade = Payment.makeBooking(departureTimestamp, busSeats, bus);
        if (!bookingMade) {
            return new BaseResponse<>(false, "Booking failed", null);
        }

        buyer.balance -= bus.price.price;

        Payment payment = new Payment(buyerId, buyer, renter, busId, busSeats, departureTimestamp);
        payment.status = Payment.PaymentStatus.WAITING;
        paymentTable.add(payment);

        return new BaseResponse<>(true, "Booking berhasil", payment);
    }

    @RequestMapping(value="/{id}/accept", method=RequestMethod.POST)
    public BaseResponse<Payment> accept(@PathVariable int id){
        Payment payment = Algorithm.<Payment>find(paymentTable, p -> p.id == id);

        if (payment == null) {
            return new BaseResponse<>(false, "Payment tidak ditemukan", null);
        }

        if (payment.status != Payment.PaymentStatus.WAITING) {
            return new BaseResponse<>(false, "Status payment bukan waiting", null);
        }

        payment.status = Payment.PaymentStatus.SUCCESS;

        return new BaseResponse<>(true, "Payment accepted successfully", payment);
    }

    @RequestMapping(value="/{id}/cancel", method=RequestMethod.POST)
    public BaseResponse<Payment> cancel(@PathVariable int id){
        Payment payment = Algorithm.<Payment>find(paymentTable, p -> p.id == id);

        if (payment == null) {
            return new BaseResponse<>(false, "Payment tidak ditemukan", null);
        }

        if (payment.status != Payment.PaymentStatus.WAITING) {
            return new BaseResponse<>(false, "Status payment bukan waiting", null);
        }

        payment.status = Payment.PaymentStatus.FAILED;

        return new BaseResponse<>(true, "Payment telah di cancel", payment);
    }
}
