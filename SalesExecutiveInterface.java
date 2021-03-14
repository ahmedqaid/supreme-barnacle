
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface SalesExecutiveInterface extends Remote {
    public void makeOrder(ArrayList<Integer> itemIds) throws RemoteException;
    public ArrayList<Receipt> getReceipts() throws RemoteException;
    public double calculatePrice(int itemId, int quantity) throws RemoteException;
}
