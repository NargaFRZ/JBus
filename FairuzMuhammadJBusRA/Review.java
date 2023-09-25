package FairuzMuhammadJBusRA;


/**
 * Review Clas
 *
 * @author Muhammad
 * @version PT3
 */
public class Review extends Serializable{
    public String date;
    public String desc;
    
    public Review (int id, String date, String desc){
        super(id);
        this.date = date;
        this.desc = desc;
    }
    
    public String toString(){
        return  "Review ID: " + super.id +
                ", Date: " + this.date +
                ", Desc: " + this.desc;
    }
}
