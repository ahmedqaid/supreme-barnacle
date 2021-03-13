import java.io.Serializable;

public class Item implements Serializable {
    public int id;
    public String name;
    public double price;
    public int stock;
    public boolean isDeleted = false;

    public Item (String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
}
