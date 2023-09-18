package FairuzMuhammadJBusRA;


public class Price{
    public double price;
    public double rebate;
//  public double discount;
    
    public Price(double price){
        this.price = price;
        this.rebate = 0.0;
//      this.discount = 0;
    }
    
    public Price(double price, double rebate){
        this.price = price;
        this.rebate = rebate;
//      this.discount = 0.0;
    }
    
/*
    public Price(double price, int discount){
        this.price = price;
        this.discount = discount;
        this.rebate = 0.0;
    }
  
    private double getDiscountedPrice(){
        if (this.discount>100.0){
            this.discount = 100.0;
        }
        
        if (this.discount==100.0){
            return 0;
        }
        
        this.discount = 100.0 - this.discount;
        this.price = (double)(this.price * (this.discount/100.0));
        return this.price;
    }
    
    private double getRebatedPrice(){
        if (this.price < this.rebate){
            return 0.0;
        }
        
        
        if (this.rebate<0){
            return 0.0;
        }
        
        this.price -= this.rebate;

        return this.price;
    }
*/
}

