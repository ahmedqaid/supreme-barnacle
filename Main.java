import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static AccountsInterface auth;
    public static AdminInterface auth1;

    public static void main(String args[]) {
        // Admin admin = new Admin();
        // Item item = new Item("namse", 121.5, 1100);
        // admin.addItem(item);
        // AccountsImplementation ai = new AccountsImplementation();

        // try {
        // auth = (AccountsInterface) Naming.lookup("rmi://localhost:3000/Accounts");
        // // TODO code application logic here
        // } catch (NotBoundException ex) {
        // Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        // } catch (MalformedURLException ex) {
        // Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        // } catch (RemoteException ex) {
        // Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        // }

        // Admin admin = new Admin("Ahmed", "Qaid", "701239");
        // try {
        // System.out.println("aa");
        // System.out.println(auth.add(admin));

        // } catch (Exception e) {
        // e.printStackTrace();
        // }

        try {
            auth1 = (AdminInterface) Naming.lookup("rmi://localhost:3000/Items");
            // TODO code application logic here
        } catch (NotBoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            ArrayList<Item> ri = auth1.readItems();
            for (int i = 0; i < ri.size(); i++) {
                System.out.println(ri.get(i).id);
                System.out.println(ri.get(i).name);
                System.out.println(ri.get(i).price);
                System.out.println(ri.get(i).stock);
                System.out.println(ri.get(i).isDeleted);
                System.out.println("-----------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Item item = new Item("vvv", 22, 1123);
        // try {
        //     System.out.println(auth1.addItem(item));
        //     // System.out.println(auth1.modifyItem(item, 2));
        //     // System.out.println(auth1.deleteItem(1));
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }



    }
}
