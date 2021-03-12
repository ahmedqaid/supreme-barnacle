public class Admin {
    private String name;
    private String passport;

    public void addItem() {
        String name = "name";
        double price = 2.4;
        int stock = 2;
    
        Item item = new Item(name, price, stock);
        
    }

    public void modifyItem() {

    }

    public void deleteItem() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getPassport() {
        return passport;
    }
}
