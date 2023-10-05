package FairuzMuhammadJBusRA;
import java.util.Scanner;
import java.util.Calendar;
import java.sql.Timestamp;

/**
 * Represents the Main part of this java program
 *
 * @author Fairuz Muhammad
 * @version CS4
 */

public class JBus{
    /**
     * Main of the class, includes the testing of the other classes
     */
    public static void main(String[] args){
        System.out.println("Hello from Intellij!");
    }

/*
    public static Bus createBus() {
        Price price = new Price(750000, 5);
        Bus bus = new Bus(1, "Netlab Bus", Facility.LUNCH, price, 25, BusType.REGULER, City.BANDUNG, new Station(1, "Depok Terminal", City.DEPOK, "Jl. Margonda Raya"), new Station(2, "Halte UI", City.JAKARTA, "Universitas Indonesia"));
        return bus;
    }
 */

/*
    public static int getBusID(){
        return 0;
    }
    
    public static String getBusName(){
        return "Bus";
    }
    
    public static float getDiscountPercentage(int beforeDiscount, int afterDiscount){
        if (beforeDiscount < afterDiscount){
            return 0.0f;
        }
        
        if (beforeDiscount == afterDiscount){
            return 0.0f;
        }
        
        float dif, percentage, before, after;
        
        before = (float)beforeDiscount;
        after = (float)afterDiscount;
        dif = before - after;
        
        percentage = (dif/before) * 100;
        
        return percentage;
    }
    
    public static int getDiscountedPrice(int price, float discountPercentage){
        if (discountPercentage > 100.0f){
            return 0;
        }
        float price2 = (float)price;
        price2 = price2 - (price2 * discountPercentage /100);
        price = (int)price2;
        return price;
    }
    
    public static int getOriginalPrice(int discountedPrice, float discountPercentage){
        if (discountPercentage > 100.0f){
            return 0;
        }
        float originalPrice = discountedPrice / (1.0f - discountPercentage / 100.0f);
        return (int)originalPrice;
    }
    
    public static float getAdminFeePercentage(){
        return 0.05f;
    }
    
    public static int getAdminFee(int price){
        float AdminFeePercentage = getAdminFeePercentage();
        float AdminFee = (float)price * AdminFeePercentage;
        return (int)AdminFee;
    }
    
    public static int getTotalPrice(int price, int numberOfSeat){
        int AdminFee = getAdminFee(price);
        price += AdminFee;
        return price * numberOfSeat;
    }
    */

    //pt4 main
    /*
    Bus b = createBus();
        Timestamp schedule1 = Timestamp.valueOf("2023-7-18 15:00:00");
        Timestamp schedule2 = Timestamp.valueOf("2023-7-20 12:00:00");
        b.addSchedule(schedule1);
        b.addSchedule(schedule2);
        b.schedules.forEach(Schedule::printSchedule);
        // Invalid date
        Timestamp t1 = Timestamp.valueOf("2023-7-19 15:00:00");
        System.out.println("Make booking at July 19, 2023 15:00:00 Seat RA12");
        System.out.println(Payment.makeBooking(t1, "RA12", b));
        // Valid date, invalid seat
        Timestamp t2 = Timestamp.valueOf("2023-7-18 15:00:00");
        System.out.println("\nMake booking at July 18, 2023 15:00:00 Seat RA20");
        System.out.println(Payment.makeBooking(t2, "RA20", b));
        // Valid date, valid seat
        System.out.println("\nMake booking at July 18, 2023 15:00:00 Seat RA07");
        System.out.println(Payment.makeBooking(t2, "RA07", b));
        Timestamp t3 = Timestamp.valueOf("2023-7-20 12:00:00");
        System.out.println("\nMake booking at July 20, 2023 12:00:00 Seat RA01");
        System.out.println(Payment.makeBooking(t3, "RA01", b));
        System.out.println("\nMake booking at July 20, 2023 12:00:00 Seat RA01 again");
        System.out.println(Payment.makeBooking(t3, "RA01", b));
        // Check if the data changed
        System.out.println("\nUpdated Schedule\n");
        b.schedules.forEach(Schedule::printSchedule);
     */
}
