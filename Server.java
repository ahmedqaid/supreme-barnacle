import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static final int port = 3000;
    public static void main(String args[]) {
        try {
            Registry registry = LocateRegistry.createRegistry(port);
            registry.rebind("Accounts", new AccountsImplementation());
            registry.rebind("Items", new AdminImplementation());
            registry.rebind("Sales", new SalesExecutiveImplementation());
        } catch(RemoteException ex) {
            ex.printStackTrace();
            System.out.println("Remote exception error, try changing ports!");
        }
    }
}
