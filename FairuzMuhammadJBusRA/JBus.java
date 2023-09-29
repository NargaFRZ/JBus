package FairuzMuhammadJBusRA;
import java.util.Scanner;
import java.util.Calendar;

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
        Price[] unfilteredArray = new Price[5];
        for (int i = 0; i < unfilteredArray.length; i++) {
            int j = 5000;
            unfilteredArray[i] = new Price((i+1)*j);
        }
        
        System.out.println("Price List:");
        for (Price price : unfilteredArray) {
            System.out.println(price.price);
        }
        
        System.out.println("Below 12000.0:");
        System.out.println(Validate.filter(unfilteredArray, 12000, true));

        System.out.println("Above 10000.0:");
        System.out.println(Validate.filter(unfilteredArray, 10000, false));    
        
        Bus testBus = createBus();
        
        // Payment
        Payment testPayment = new Payment(1, 1, 1, testBus.id, "S1");
        System.out.println(testPayment.getDepartureInfo());
        System.out.println(testPayment.getTime());
        // Tes Schedule
        Calendar schedule1 = Calendar.getInstance();
        testBus.addSchedule(schedule1);
        Calendar schedule2 = Calendar.getInstance();
        schedule2.add(Calendar.DAY_OF_MONTH, 3);
        testBus.addSchedule(schedule2);
        for(Schedule s: testBus.schedules){
            testBus.printSchedule(s);
        }
    }


    public static Bus createBus(){
        // Bus bus = new Bus(1, "Bus", Facility.AC, newprice, 50);
        Station testDeparture = new Station(2, "Depok Terminal", City.DEPOK, "Jl. Margonda Raya");
        Station testArrival = new Station(3, "Halte UI", City.JAKARTA, "Universitas Indonesia");
        Price price = new Price(100000, 20000);
        Bus testBus = new Bus(1, "Busway", Facility.AC, price, 25, BusType.REGULER, City.DEPOK, testDeparture, testArrival);       
        return testBus;
    }

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
}
