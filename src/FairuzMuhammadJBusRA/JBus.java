package FairuzMuhammadJBusRA;
import java.util.Scanner;
import java.util.Calendar;
import java.sql.Timestamp;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

/**
 * Represents the Main part of this java program
 *
 * @author Fairuz Muhammad
 * @version CS5
 */

public class JBus{
    /**
     * Main of the class, includes the testing of the other classes
     */
    public static void main(String[] args) {
        // PT Modul 5
        // Tes Pagination
        Bus b = createBus();
        List<Timestamp> listOfSchedules = new ArrayList<>();
        listOfSchedules.add(Timestamp.valueOf("2023-7-18 15:00:00"));
        listOfSchedules.add(Timestamp.valueOf("2023-7-20 12:00:00"));
        listOfSchedules.add(Timestamp.valueOf("2023-7-22 10:00:00"));
        listOfSchedules.add(Timestamp.valueOf("2023-7-26 12:00:00"));

        listOfSchedules.forEach(b::addSchedule);
        System.out.println("Page 1");
        Algorithm.paginate(b.schedules, 0, 3, t -> true).forEach(System.out::println);
        System.out.println("=====================================================");
        System.out.println("Page 2");
        Algorithm.paginate(b.schedules, 1, 3, t -> true).forEach(System.out::println);
        System.out.println("=====================================================");

        // Tes Booking
        String msgSuccess = "Booking Success!";
        String msgFailed = "Booking Failed";
        // valid date, invalid seat = Booking Failed
        Timestamp t1 = Timestamp.valueOf("2023-7-19 15:00:00");
        System.out.println("\nMake booking at July 19, 2023 15:00:00 Seats: RA17 RA18");
        System.out.println(Payment.makeBooking(t1, List.of("RA17", "RA18"), b)? msgSuccess : msgFailed);
        // valid date, invalid seat = Booking Failed
        Timestamp t2 = Timestamp.valueOf("2023-7-18 15:00:00");
        System.out.println("Make booking at July 18, 2023 15:00:00 Seat RA26");
        System.out.println(Payment.makeBooking(t2, "RA26", b)? msgSuccess : msgFailed);
        // valid date, valid seat = Booking Success
        System.out.println("Make booking at July 18, 2023 15:00:00 Seats: RA7 RA8");
        System.out.println(Payment.makeBooking(t2, List.of("RA07", "RA08"), b)? msgSuccess : msgFailed);
        // valid date, valid seat = Booking Success
        Timestamp t3 = Timestamp.valueOf("2023-7-20 12:00:00");
        System.out.println("Make booking at July 20, 2023 12:00:00 Seats: RA1 RA2");
        System.out.println(Payment.makeBooking(t3, List.of("RA01", "RA02"), b)? msgSuccess : msgFailed);
        // valid date, book the same seat = Booking Failed
        System.out.println("Make booking at July 20, 2023 12:00:00 Seat RA1");
        System.out.println(Payment.makeBooking(t3, "RA01", b)? msgSuccess : msgFailed);
        // check if the data changed
        System.out.println("\nUpdated Schedule");
        Algorithm.paginate(b.schedules, 0, 4, t-> true).forEach(System.out::println);
    }

    public static Bus createBus() {
        Price price = new Price(750000, 5);
        Bus bus = new Bus(0,"Netlab Bus", Facility.LUNCH, price, 25, BusType.REGULER, City.BANDUNG, new Station(1,"Depok Terminal", City.DEPOK, "Jl. Margonda Raya"), new Station(2,"Halte UI", City.JAKARTA, "Universitas Indonesia"));
        return bus;
    }

    /* CS5
    public static void main(String[] args) {
        Integer[] numbers = {18, 10, 22, 43, 18, 67, 12, 11, 88, 22, 18};
        System.out.println("Number "+Arrays.toString(numbers));

        // Tes Algorithm
        System.out.print("1. ");
        testCount(numbers);
        System.out.print("2. ");
        testFind(numbers);
        System.out.print("3. ");
        testExist(numbers);
        System.out.println("4. Filtering");
        testCollect(numbers);
    }
    private static void testExist(Integer[] t) {
        int valueToCheck = 67;
        boolean result3 = Algorithm.exists(t, valueToCheck);
        if (result3) {
            System.out.println(valueToCheck + " exist in the array.");
        } else {
            System.out.println(valueToCheck + " doesn't exists in the array.");
        }
    }
    public static void testCount(Integer[] t) {
        int valueToCount = 18;
        int result = Algorithm.count(t, valueToCount);
        System.out.println("Number " + valueToCount + " appears " + result + " times");
    }
    public static void testFind(Integer[] t) {
        Integer valueToFind = 69;
        Integer result2 = Algorithm.find(t, valueToFind);
        System.out.print("Finding " + valueToFind + " inside the array : ");
        if (result2 != null) {
            System.out.println("Found!" + result2);
        } else {
            System.out.println("Not Found");
        }
    }
    private static void testCollect(Integer[] t) {
        Predicate<Integer> below = (val) -> val <= 22;
        Predicate<Integer> above = (val) -> val > 43;

        List<Integer> integerBelow = Algorithm.collect(t, below);
        List<Integer> integerAbove = Algorithm.collect(t, above);

        System.out.println("Below 22");
        System.out.println(integerBelow);
        System.out.println("Above 43");
        System.out.println(integerAbove);
    }

     */

    /*TP5
    public static void main(String[] args){
        Bus bus1 = createBus();
        Bus bus2 = createBus();
        Bus bus3 = createBus();
        Bus bus4 = createBus();
        Bus bus5 = createBus();
        System.out.println(bus1);
        System.out.println(bus2);
        System.out.println(bus3);
        System.out.println(bus4);
        System.out.println(bus5);
    }

    public static Bus createBus() {
        Price price = new Price(750000, 5);
        Bus bus = new Bus(5, "Netlab Bus", Facility.LUNCH, price, 25, BusType.REGULER, City.BANDUNG, new Station(1, "Depok Terminal", City.DEPOK, "Jl. Margonda Raya"), new Station(2, "Halte UI", City.JAKARTA, "Universitas Indonesia"));
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

    /* Testing Serializable CS5
    Bus b1 = createBus();
        Bus b2 = createBus();
        System.out.println(b1);
        System.out.println(b2);
     */
}
