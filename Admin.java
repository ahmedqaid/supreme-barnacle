import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Admin implements Serializable {
    private String firstName;
    private String lastName;
    private String passportNumber;
    private ArrayList<Item> Container = new ArrayList<Item>();

    public Admin (String firstName, String lastName, String passportNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passportNumber = passportNumber;
    }

    // public void writeToFile() {
    //     try {
    //         FileOutputStream fileOut = new FileOutputStream("items.txt");
    //         ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
    //         objectOut.writeObject(Container);
    //         fileOut.close();
    //         objectOut.close();
    //     }

    //     catch (IOException e) {
    //         System.out.println("Error with text file!");
    //     }
    // }

    // public void readFromFile() {
    //     try {
    //         FileInputStream fileIn = new FileInputStream("items.txt");
    //         ObjectInputStream objectIn = new ObjectInputStream(fileIn);
    //         Container = (ArrayList<Item>) objectIn.readObject();
    //         objectIn.close();
    //         fileIn.close();
    //     }

    //     catch (IOException | ClassNotFoundException e) {
    //         System.out.println("Error with text file or class!");
    //     }
    // }

    // public void printItems() {
    //     readFromFile();
    //     Item[] itemList = new Item[Container.size()];
    //     for (int i = 0; i < Container.size(); i++) {
    //         itemList[i] = Container.get(i);
    //         System.out.println(itemList[i].name);
    //         System.out.println(itemList[i].price);
    //         System.out.println(itemList[i].stock);
    //     }
    // }

    // public void addItem(Item item) {
    //     readFromFile();
    //     Container.add(item);
    //     writeToFile();
    //     printItems();
    // }

    // public void modifyItem() {

    // }

    // public void deleteItem() {

    // }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void getPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getPassportNumber() {
        return passportNumber;
    }
}
