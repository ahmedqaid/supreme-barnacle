import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AdminInterface extends Remote {
    public String addItem(Item item) throws RemoteException;
    public String modifyItem(Item item, int id) throws RemoteException;
    public String deleteItem(int id) throws RemoteException;
}
