import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class AdminImplementation extends UnicastRemoteObject implements AdminInterface, Serializable {
    private ArrayList<Item> Container = new ArrayList<Item>();

    public AdminImplementation() throws RemoteException {

    }

    public void writeToFile() {
        try {
            FileOutputStream fileOut = new FileOutputStream("items.txt");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(Container);
            fileOut.close();
            objectOut.close();
        }

        catch (IOException e) {
            System.out.println("Error with text file!");
        }
    }

    public void readFromFile() {
        try {
            FileInputStream fileIn = new FileInputStream("items.txt");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            Container = (ArrayList<Item>) objectIn.readObject();
            for (int i = 0; i < Container.size(); i++) {
                if (! Container.get(i).isDeleted) {
                    System.out.println(Container.get(i).id);
                    System.out.println(Container.get(i).name);
                }
            }
            objectIn.close();
            fileIn.close();
        }

        catch (IOException | ClassNotFoundException e) {
            System.out.println("Error with text file or class!");
        }
    }

    public String addItem(Item item) throws RemoteException {
        readFromFile();
        item.id = Container.size();
        Container.add(item);
        writeToFile();
        return "Successfully added!";
    }

    public String modifyItem(Item item, int id) throws RemoteException {
        readFromFile();
        
        item.id = id;
        Item[] itemList = new Item[Container.size()];
        
        for(int i = 0; i < Container.size(); i++) {
            
            itemList[i] = Container.get(i);
            if(itemList[i].id == id) {
                if (itemList[i].isDeleted) {
                    return "Item does not exist!";
                }
                Container.remove(i);
                break;
            }
        }
        Container.add(item);
        writeToFile();
        
        return "Successfully modified!";
    }

    public String deleteItem(int id) throws RemoteException {
        readFromFile();
        
        Item[] itemList = new Item[Container.size()];
        
        for(int i = 0; i < Container.size(); i++) {
            
            itemList[i] = Container.get(i);
            if(itemList[i].id == id) {
                if (itemList[i].isDeleted) {
                    return "Item does not exist!";
                }
                Container.get(i).isDeleted = true;
                break;
            }
        }
        writeToFile();
        
        return "Successfully deleted!";

    }

}
