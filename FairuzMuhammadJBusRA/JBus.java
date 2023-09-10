package FairuzMuhammadJBusRA;
import java.util.Scanner;

/**
 * Fairuz Muhammad
 * 2206814324
 */

public class JBus{
    public static void main(String[] args){
        System.out.println("Test Case Diskon");
        Scanner input = new Scanner(System.in);
        System.out.println("Harga awal: ");
        int awal = input.nextInt();
        System.out.println("Harga akhir: ");
        int akhir = input.nextInt();
        
        float Percentage;
        Percentage = getDiscountPercentage(awal,akhir);
        System.out.println("Persentase Discount: " +Percentage);
        
        int discountPrice;
        discountPrice = getDiscountedPrice(awal,Percentage);
        System.out.println("Discount Price: " +discountPrice);
        
        int oriPrice;
        oriPrice = getOriginalPrice(discountPrice,Percentage);
        System.out.println("Original Price: " +oriPrice);
        
        System.out.println("\n\nTest case bus");
        System.out.println("Harga naik bus: ");
        int price = input.nextInt();
        
        System.out.println("Jumlah tempat duduk bus: ");
        int seat = input.nextInt();
        
        int adminFee;
        adminFee = getAdminFee(price);
        System.out.println("Admin Fee: " +adminFee);
        
        int totalPrice;
        totalPrice = getTotalPrice(price, seat);
        System.out.println("Total Price: " +totalPrice);
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
}
