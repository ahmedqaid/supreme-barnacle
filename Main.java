import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static AccountsInterface auth;

    public static void main(String args[]) {
        // Admin admin = new Admin();
        // Item item = new Item("namse", 121.5, 1100);
        // admin.addItem(item);
        // AccountsImplementation ai = new AccountsImplementation();

        try {
            auth = (AccountsInterface) Naming.lookup("rmi://localhost:8080/Accounts");
            // TODO code application logic here
        } catch (NotBoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        Admin admin = new Admin("Ahmed", "Qaid", "701239");
        try {
            System.out.println("aa");
            System.out.println(auth.add(admin));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
