import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class AccountsImplementation extends UnicastRemoteObject implements AccountsInterface, Serializable {
    private ArrayList<Admin> Container = new ArrayList<Admin>();

    public AccountsImplementation() throws RemoteException {

    }

    public void writeToFile() {
        try {
            FileOutputStream fileOut = new FileOutputStream("admins.txt");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(Container);
            fileOut.close();
            objectOut.close();
        }

        catch (IOException e) {
            System.out.println("Error with text file!");
        }
    }

    public void readFromFile() {
        try {
            FileInputStream fileIn = new FileInputStream("admins.txt");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            Container = (ArrayList<Admin>) objectIn.readObject();
            objectIn.close();
            fileIn.close();
        }

        catch (IOException | ClassNotFoundException e) {
            System.out.println("Error with text file or class!");
        }
    }

    public String add(Admin admin) throws RemoteException {
        readFromFile();
        
        boolean isFound = false;
        
        Admin[] adminList = new Admin[Container.size()];
        
        for(int i = 0; i < Container.size(); i++) {
            
            adminList[i] = Container.get(i);
            if(adminList[i] == admin) {
                isFound = true;
                break;
            }
        }
        
        if(isFound == true) {
            return "Failure to add new admin, probably already exists! Try logging in with username and passport numeber!";
        }

        Container.add(admin); 
        writeToFile();
        
        return "Successfully added!";
    }

    public String login(String name, String passport) throws RemoteException{

        readFromFile();
        String[] firstandlastNames = name.split(" ");

        boolean isFound = false;

        Admin[] adminList = new Admin[Container.size()];

        for(int i = 0; i < Container.size(); i++){

            adminList[i] = Container.get(i);

            if(adminList[i].getFirstName().equals(firstandlastNames[0]) && (adminList[i].getLastName().equals(firstandlastNames[1]) && (adminList[i].getPassportNumber().equals(passport)))){
                isFound = true;
                break;
            }
        }
        
        if(isFound == true){
            return "Logged in successfully!";
        }
        
        return "No account found with given username and passport number!";
    }
}
