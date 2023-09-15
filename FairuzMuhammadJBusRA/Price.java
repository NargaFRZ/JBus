package FairuzMuhammadJBusRA;


public class Price{
    public double price;
    public double discount;
    public double rebate;
    
    public Price(double price){
        this.price = price;
        this.discount = this.rebate = 0;
    }
    
    public Price(double price, int discount){
        this.price = price;
        this.discount = discount;
        this.rebate = 0;
    }
    
    public Price(double price, double rebate){
        this.price = price;
        this.discount = 0;
        this.rebate = rebate;
    }
    
    private double getDiscountedPrice(){
        if (this.discount>100.0){
            this.discount = 100.0;
        }
        
        if (this.discount==100.0){
            return 0;
        }
        
        this.discount = 100 - this.discount;
        this.price = this.price * (this.discount/100);
        return this.price;
    }
    
    private double getRebatedPrice(){
        if (this.rebate<0){
            return 0;
        }
        
        this.price -= this.rebate;
        
        if (this.price<0){
            return 0;
        }
        
        return this.price;
    }
}
