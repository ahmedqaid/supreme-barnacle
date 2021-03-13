import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AccountsInterface extends Remote {
    
    public String login(String name, String passport) throws RemoteException;
    public String add(Admin admin) throws RemoteException;
}
