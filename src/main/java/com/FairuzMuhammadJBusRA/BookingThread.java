package com.FairuzMuhammadJBusRA;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Represents a thread that handles a booking process for a bus.
 * This thread attempts to book a seat on a bus at a specific time and logs the result.
 * 
 * @author Fairuz Muhammad
 * @version FINAL
 * @see Serializable
 */
public class BookingThread extends Thread{
    /**
     * The bus object on which the booking is attempted.
     * This object represents the bus to be booked by this thread.
     */
    private Bus bus;

    /**
     * The timestamp representing the desired time for the booking.
     * This timestamp specifies when the booking is intended to be made on the bus.
     */
    private Timestamp timestamp ;

    /**
     * Constructs a BookingThread with the specified name, bus, and timestamp.
     * The thread is automatically started upon creation.
     *
     * @param name The name of the thread.
     * @param bus The bus to be booked.
     * @param timestamp The timestamp for which the booking is to be made.
     */
    public BookingThread(String name, Bus bus, Timestamp timestamp){
        super(name);
        this.bus = bus;
        this.timestamp = timestamp;
        this.start();
    }

    /**
     * Runs the booking process in a synchronized block to ensure thread safety.
     * The booking result is logged to the console.
     */
    public void run(){
        System.out.println(this.getName() + " ID : " + Thread.currentThread().getId() + " is running");
        synchronized (bus) {
            boolean booking = Payment.makeBooking(timestamp, "RA01", bus);
            if(booking){
                System.out.println(this.getName() + " Berhasil Melakukan Booking");
            }
            else{
                System.out.println(this.getName() + " Gagal Melakukan Booking");
            }
        }
    }
}