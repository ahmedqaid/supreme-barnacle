
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class SalesExecutiveImplementation extends UnicastRemoteObject implements SalesExecutiveInterface, Serializable {
    private ArrayList<Item> Container = new ArrayList<Item>();
    private ArrayList<Receipt> receipts = new ArrayList<Receipt>();

    public SalesExecutiveImplementation() throws RemoteException {

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
            objectIn.close();
            fileIn.close();
        }

        catch (IOException | ClassNotFoundException e) {
            System.out.println("Error with text file or class!");
        }
    }

    public void makeOrder(ArrayList<Integer> itemIds) throws RemoteException {
        readFromFile();
        Item[] itemList = new Item[Container.size()];
        double total = 0;

        for (int i = 0; i < itemIds.size(); i++) {
            for (int j = 0; j < Container.size(); j++) {
                itemList[j] = Container.get(j);
                if (itemList[i].id == itemIds.get(i)) {
                    itemList[i].stock--;
                    total += itemList[i].price;
                    break;
                }
            }
        }
        writeToFile();
        
        Receipt receipt = new Receipt(itemIds, total);
        readReceiptFromFile();
        receipts.add(receipt);
        writeReceiptToFile();
    }

    public void writeReceiptToFile() {
        try {
            FileOutputStream fileOut = new FileOutputStream("receipts.txt");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(receipts);
            fileOut.close();
            objectOut.close();
        }

        catch (IOException e) {
            System.out.println("Error with text file!");
        }
    }

    public void readReceiptFromFile() {
        try {
            FileInputStream fileIn = new FileInputStream("receipts.txt");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            receipts = (ArrayList<Receipt>) objectIn.readObject();
            objectIn.close();
            fileIn.close();
        }

        catch (IOException | ClassNotFoundException e) {
            System.out.println("Error with text file or class!");
        }
    }

    public ArrayList<Receipt> getReceipts() throws RemoteException {
        readReceiptFromFile();
        return receipts;
    }

    public Item findItem(int itemId) {
        readFromFile();
        
        Item[] itemList = new Item[Container.size()];
        for(int i = 0; i < Container.size(); i++) {
            
            itemList[i] = Container.get(i);
            if(itemList[i].id == itemId) {
                if (itemList[i].isDeleted) {
                    break;
                }
                return itemList[i];
            }
        }
        return null;
    }

    public double calculatePrice(int itemId, int quantity) throws RemoteException {
        Item item = findItem(itemId);
        if (quantity > item.stock) {
            return -1;
        }
        return item.price * quantity;
    }

    public String decreaseStock(ArrayList<Integer> itemIds, ArrayList<Integer> quantities) throws RemoteException {
        ArrayList<Integer> successfulIds = new ArrayList<Integer>();
        readFromFile();

        for (int siz = 0; siz < itemIds.size(); siz++) {
            Item[] itemList = new Item[Container.size()];
            for(int i = 0; i < itemIds.size(); i++) {
                
                itemList[i] = Container.get(i);
                if(itemList[i].id == itemIds.get(siz)) {
                    if (itemList[i].isDeleted) {
                        break;
                    }
                    if (quantities.get(siz) > itemList[i].stock) {
                        break;
                    }
                    itemList[i].stock -= quantities.get(siz);
                    successfulIds.add(itemList[i].id);
                    break;
                }
            }
            
        }

        return "success";
    }
}
