import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AdminInterface extends Remote {
    public String addItem(Item item) throws RemoteException;
    public String modifyItem(Item item) throws RemoteException;
    public String deleteItem(Item item) throws RemoteException;
}
