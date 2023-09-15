package FairuzMuhammadJBusRA;


public class Rating{
    private long count;
    private long total;

    public Rating(){
        this.total = 0;
        this.count = 0; 
    }
    
    public void insert(int rating){
        this.total += rating;
        this.count++;
    }
    
    public double getAverage(){
        double rating;
        rating = this.total / this.count;
        return rating;
    }
    
    public long getCount(){
        return this.count;
    }
    
    public long getTotal(){
        return this.total;
    }
}
