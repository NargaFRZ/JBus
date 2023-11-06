package FairuzMuhammadJBusRA;

import java.sql.Timestamp;
public class BookingThread extends Thread{
    private Bus bus;
    private Timestamp timestamp ;
    public BookingThread(String name, Bus bus, Timestamp timestamp){
        super(name);
        this.bus = bus;
        this.timestamp = timestamp;
        this.start();
    }
    public void run(){
        System.out.println("Thread " + this.getName() + " ID : " + Thread.currentThread().getId() + " is running");
        synchronized (bus) {
            boolean booking = Payment.makeBooking(timestamp, "RA01", bus);
            if(booking){
                System.out.println("Thread " + this.getName() + " Berhasil Melakukan Booking");
            }
            else{
                System.out.println("Thread " + this.getName() + " Gagal Melakukan Booking");
            }
        }
    }
}