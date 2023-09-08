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
        float price2 = (float)price;
        price2 = price2 - (price2 * discountPercentage /100);
        price = (int)price2;
        return price;
    }
    
    int getOriginalPrice(int discountedPrice, float discountPercentage){
        float price2 = (float)discountedPrice;
        price2 = price2 + (price2 * discountPercentage /100);
        discountedPrice = (int)price2;
        return discountedPrice;
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
        
        int discountPrice;
        discountPrice = driver.getDiscountedPrice(awal,Percentage);
        System.out.println("Discount Price: " +discountPrice);
        
        int oriPrice;
        oriPrice = driver.getOriginalPrice(discountPrice,Percentage);
        System.out.println("Original Price: " +oriPrice);
    }
}
