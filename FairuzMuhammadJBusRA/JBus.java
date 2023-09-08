package FairuzMuhammadJBusRA;
import java.util.Scanner;

/**
 * Fairuz Muhammad
 * 2206814324
 */

class Driver{
    int getBusID(){
        return 0;
    }
    
    String getBusName(){
        return "Bus";
    }
    
    boolean isDiscount(){
        return true;
    }
    
    float getDiscountPercentage(int beforeDiscount, int afterDiscount){
        if (beforeDiscount < afterDiscount){
            return 0.0f;
        }
        
        float dif, percentage, before, after;
        
        before = (float)beforeDiscount;
        after = (float)afterDiscount;
        dif = before - after;
        
        percentage = (dif/before) * 100;
        
        return percentage;
    }
    
    int getDiscountedPrice(int price, float discountPercentage){
        
        if (discountPercentage > 100.0f){
            return 0;
        }
        int discountInt = (int)discountPercentage;
        return (price - (price * (discountInt / 100)));
    }
    
    int getOriginalPrice(int discountedPrice, float discountPercentage){
        int discountInt = (int)discountPercentage;
        return (discountedPrice + (discountedPrice * (discountInt / 100)));
    }
    
    float getAdminFeePercentage(){
        return 0.05f;
    }
    
    int getAdminFee(int price){
        float AdminFeePercentage = getAdminFeePercentage();
        int AdminFeeInt = (int)AdminFeePercentage;
        return price * AdminFeeInt;
    }
    
    int getTotalPrice(int price, int numberOfSeat){
        int AdminFee = getAdminFee(price);
        price += AdminFee;
        return price * numberOfSeat;
    }
}

public class JBus{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Harga awal: ");
        int awal = input.nextInt();
        System.out.println("Harga akhir: ");
        int akhir = input.nextInt();
        
        float Percentage;
        Driver driver = new Driver();
        Percentage = driver.getDiscountPercentage(awal,akhir);
        System.out.println("Harga akhir: " +Percentage);
    }
}
