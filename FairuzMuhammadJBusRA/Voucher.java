package FairuzMuhammadJBusRA;

public class Voucher{
    public String name;
    private boolean used;
    public double minimum;
    public double cut;
    public int code;
    public Type type;
    
    public Voucher(String name, int code, Type type, double minimum, double cut){
        this.name = name;
        this.code = code;
        this.type = type;
        this.minimum = minimum;
        this.cut = cut;
        this.used = false;
    }
    
    public boolean isUsed(){
        return used;
    }
    
    public boolean canApply(Price price){
        if(price.price > this.minimum && this.used == false){
            return true;
        }
        return false;
    }
    
    public double apply(Price price){
        this.used = true;
        
        if(this.type == Type.DISCOUNT){
            return price.price - (price.price * this.cut / 100.0);
        }
        else if(this.type == Type.REBATE){
            return price.price - this.cut;
        }
        
        return price.price;
    }
}
