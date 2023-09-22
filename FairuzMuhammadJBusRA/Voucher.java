package FairuzMuhammadJBusRA;

public class Voucher extends Serializable{
    public String name;
    private boolean used;
    public double minimum;
    public double cut;
    public int code;
    public Type type;
    
    public Voucher(int id, String name, int code, Type type, double minimum, double cut){
        super(id);
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
        if(price.price > this.minimum && !this.used){
            return true;
        }
        return false;
    }
    
    public double apply(Price price){
        if(!canApply(price)){
            return price.price;
        }
        
        this.used = true;
        
        if(this.type == Type.DISCOUNT){
            if(this.cut>100){
                this.cut = 100.0;
            }
            return price.price - (price.price * this.cut / 100.0);
        }
        
        else if(this.type == Type.REBATE){
            if(price.price<this.cut){
                this.cut = price.price;
            }
            return price.price - this.cut;
        }
        
        return price.price;
    }
}
