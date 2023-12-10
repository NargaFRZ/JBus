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

/**
 * Controller for handling payment-related operations in the application.
 * It provides endpoints for making bookings, accepting and canceling payments,
 * and retrieving payment details for renters and buyers.
 * 
 * @author Fairuz Muhammad
 * @version FINAL
 */
@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment> {
    /**
     * A JsonTable instance for managing Payment entities. It uses JsonAutowired annotation
     * to specify the class type (Payment) and the file path for the JSON file containing Payment data.
     */
    public static @JsonAutowired(value = Payment.class, filepath = "src/main/java/com/FairuzMuhammadJBusRA/json/payment.json")
    JsonTable<Payment> paymentTable;

    /**
     * Returns the JsonTable associated with Payment entities.
     *
     * @return JsonTable for Payment entities.
     */
    public JsonTable<Payment> getJsonTable() {
        return PaymentController.paymentTable;
    }

    /**
     * Endpoint for creating a booking. It creates a new Payment entity and records the booking details.
     *
     * @param buyerId The ID of the buyer.
     * @param renterId The ID of the renter.
     * @param busId The ID of the bus.
     * @param busSeats The list of seats to be booked.
     * @param departureDate The departure date of the bus.
     * @return A BaseResponse containing the booking result and a Payment object.
     */
    @RequestMapping(value="/makeBooking", method= RequestMethod.POST)
    public BaseResponse<Payment> makeBooking(
            @RequestParam int buyerId,
            @RequestParam int renterId,
            @RequestParam int busId,
            @RequestParam List<String> busSeats,
            @RequestParam String departureDate
    )
    {
        Account buyer = Algorithm.<Account>find(new AccountController().getJsonTable(), t->t.id == buyerId);
        Bus bus = Algorithm.<Bus>find(new BusController().getJsonTable(), t->t.id == busId);

        if (buyer == null || bus == null) {
            return new BaseResponse<>(false, "Pembeli atau Bus tidak ditemukan", null);
        }

        if (buyer.balance < (bus.price.price * busSeats.size())) {
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

        buyer.balance -= (bus.price.price * busSeats.size());

        Payment payment = new Payment(buyerId, renterId, busId, busSeats, departureTimestamp);
        payment.status = Payment.PaymentStatus.WAITING;
        paymentTable.add(payment);

        return new BaseResponse<>(true, "Booking berhasil", payment);
    }

    /**
     * Endpoint to accept a payment. It changes the status of the payment to SUCCESS.
     *
     * @param id The ID of the payment to be accepted.
     * @return A BaseResponse indicating the result of the operation.
     */
    @RequestMapping(value="/{id}/accept", method=RequestMethod.POST)
    public BaseResponse<Payment> accept(@PathVariable int id){
        Payment payment = Algorithm.<Payment>find(paymentTable, p -> p.id == id);
        Account renter = Algorithm.<Account>find(new AccountController().getJsonTable(), t->t.id == payment.renterId);
        Bus bus = Algorithm.<Bus>find(BusController.busTable, b -> b.id == payment.getBusId());

        if (payment == null) {
            return new BaseResponse<>(false, "Payment tidak ditemukan", null);
        }

        if (payment.status != Payment.PaymentStatus.WAITING) {
            return new BaseResponse<>(false, "Status payment bukan waiting", null);
        }

        renter.balance += (payment.busSeat.size() * bus.price.price);
        payment.status = Payment.PaymentStatus.SUCCESS;

        return new BaseResponse<>(true, "Payment accepted successfully", payment);
    }

    /**
     * Endpoint to cancel a payment. It changes the status of the payment to FAILED.
     *
     * @param id The ID of the payment to be cancelled.
     * @return A BaseResponse indicating the result of the operation.
     */
    @RequestMapping(value="/{id}/cancel", method=RequestMethod.POST)
    public BaseResponse<Payment> cancel(@PathVariable int id){
        Payment payment = Algorithm.<Payment>find(paymentTable, p -> p.id == id);
        Account buyer = Algorithm.<Account>find(AccountController.accountTable, a -> a.id == payment.buyerId);
        Bus bus = Algorithm.<Bus>find(BusController.busTable, b -> b.id == payment.getBusId());

        if (payment == null) {
            return new BaseResponse<>(false, "Payment tidak ditemukan", null);
        }

        if (payment.status != Payment.PaymentStatus.WAITING) {
            return new BaseResponse<>(false, "Status payment bukan waiting", null);
        }

        payment.status = Payment.PaymentStatus.FAILED;
        buyer.balance += (bus.price.price * payment.busSeat.size());

        Schedule scheduleToCancel = Algorithm.<Schedule>find(bus.schedules, s -> s.departureSchedule.equals(payment.departureDate));
        if (scheduleToCancel != null) {
            for(String seat : payment.busSeat){
                scheduleToCancel.seatAvailability.put(seat, true);
            }
        }

        return new BaseResponse<>(true, "Payment telah di cancel", payment);
    }

    /**
     * Retrieves payments related to a specific renter.
     *
     * @param renterId The ID of the renter.
     * @return A list of Payment entities associated with the renter.
     */
    @GetMapping("/getRenterPayment")
    public List<Payment> getRenterPayment(@RequestParam int renterId
    ) {
        return Algorithm.<Payment>collect(getJsonTable(), b->b.renterId == renterId);
    }

    /**
     * Retrieves payments related to a specific account.
     *
     * @param accountId The ID of the account.
     * @return A list of Payment entities associated with the account.
     */
    @GetMapping("/getAccountPayment")
    public List<Payment> getBuyerPayment(@RequestParam int accountId
    ) {
        return Algorithm.<Payment>collect(getJsonTable(), b->b.buyerId == accountId);
    }
}
