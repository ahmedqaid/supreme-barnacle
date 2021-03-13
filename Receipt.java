import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.Date;

public class Receipt {
    public ArrayList<Integer> itemIds;
    public double amount;
    Date timestamp;

    public Receipt(ArrayList<Integer> itemIds, double amount) {
        this.itemIds = itemIds;
        this.amount = amount;
        Date date = new Date();
        timestamp = new Timestamp(date.getTime());
    }
}
