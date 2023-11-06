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
        System.out.println("Thread " + this.getName() + " is running");
        System.out.println("ThreadId " + Thread.currentThread().getId());
        synchronized (bus) {
            boolean booking = Payment.makeBooking(timestamp, "RA01", bus);
            if(booking){
                System.out.println("Thread " + this.getName() + " berhasil booking RA01 pada " + timestamp);
            }
        }
    }
}