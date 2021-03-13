import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String args[]) {
        try {
            Registry registry = LocateRegistry.createRegistry(3000);
            registry.rebind("Accounts", new AccountsImplementation());
            registry.rebind("Items", new AdminImplementation());
        } catch(RemoteException ex) {
            ex.printStackTrace();
            System.out.println("Remote exception error, try changing ports!");
        }
    }
}
