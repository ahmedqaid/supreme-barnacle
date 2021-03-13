import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String args[]) {
        try {
            Registry registry = LocateRegistry.createRegistry(8080);
            registry.rebind("Accounts", new AccountsImplementation());
        } catch(RemoteException ex) {
            System.out.println("Remote exception error, try changing ports!");
        }
    }
}
