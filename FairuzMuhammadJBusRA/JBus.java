package FairuzMuhammadJBusRA;
import java.util.Scanner;

/**
 * Fairuz Muhammad
 * 2206814324
 */

public class JBus{
    public static void main(String[] args){
        Payment testPayment = new Payment(1, 1, 1, "A", 1, "A", "A");
        Invoice testInvoice = new Invoice(2,2,2, "B");
        Station testStation = new Station(3, "c", City.DEPOK);
        System.out.println(testPayment.print());
        System.out.println(testInvoice.print());
        System.out.println(testStation.print());
    }

/*
    public static Bus createBus(){
        Price price = new Price(750000,5);
        Bus bus = new Bus(12,"Netlab Bus", Facility.LUNCH, price, 25);
        return bus;
    }
    
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
