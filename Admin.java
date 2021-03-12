import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Admin {
    private String name;
    private String passport;

    private ArrayList <Item> Container = new ArrayList <Item>(); 

    public void writeToFile() {
        try{
            FileOutputStream fileOut = new FileOutputStream("items.txt");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(Container);
            fileOut.close();
            objectOut.close();
        }
    
        catch(IOException e){
            System.out.println("Error with text file!");
        }
    }

    public void readFromFile() {
        try{
            FileInputStream fileIn = new FileInputStream("items.txt");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            Container = (ArrayList<Item>) objectIn.readObject();
            objectIn.close();
            fileIn.close();
        }
        
        catch(IOException | ClassNotFoundException e){
            System.out.println("Error with text file or class!");
        }       
    }

    public void printItems() {
        readFromFile();
        Item[] itemList = new Item[Container.size()];
        for (int i = 0; i < Container.size(); i++)  {
            itemList[i] = Container.get(i);
            System.out.println(itemList[i].name);
            System.out.println(itemList[i].price);
            System.out.println(itemList[i].stock);
        }
    }

    public void addItem(Item item) {
        readFromFile();
        Container.add(item);
        writeToFile();
        printItems();
    }

    public void modifyItem() {

    }

    public void deleteItem() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getPassport() {
        return passport;
    }
}
