import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tests {
    public static AccountsInterface accountsInterface;
    public static AdminInterface adminInterface;
    public static SalesExecutiveInterface salesExecutiveInterface;

    public static void main(String args[]) {
        try {
            accountsInterface = (AccountsInterface) Naming.lookup("rmi://localhost:3000/Accounts");
        } catch (NotBoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (accountsInterface != null) {
            System.out.println("#1: rmi://localhost:3000/Accounts - SUCCESS");
        } else {
            System.out.println("#1: rmi://localhost:3000/Accounts - FAILURE");
        }

        try {
            adminInterface = (AdminInterface) Naming.lookup("rmi://localhost:3000/Items");
        } catch (NotBoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (adminInterface != null) {
            System.out.println("#2: rmi://localhost:3000/Items - SUCCESS");
        } else {
            System.out.println("#2: rmi://localhost:3000/Items - FAILURE");
        }

        try {
            salesExecutiveInterface = (SalesExecutiveInterface) Naming.lookup("rmi://localhost:3000/Sales");
        } catch (NotBoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (salesExecutiveInterface != null) {
            System.out.println("#3: rmi://localhost:3000/Sales - SUCCESS");
        } else {
            System.out.println("#3: rmi://localhost:3000/Sales - FAILURE");
        }

    }
}
