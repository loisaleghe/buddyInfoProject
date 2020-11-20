import java.util.Scanner;

public class BuddyInfo {
    private static final String DELIMITER = "#";
    public BuddyInfo(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    private String name;


    public String getName() {
        return name;
    }

    private String address;
    private String phoneNumber;

    public static BuddyInfo importBuddyInfo (String s){
        Scanner sc = new Scanner(s);
        String newName = "";
        String newAddress = "";
        String newPhoneNumber = "";
        while (sc.hasNext()){
            String a = sc.nextLine();
             newName = a.split(DELIMITER)[0];
            newAddress = a.split(DELIMITER)[1];
            newPhoneNumber = a.split(DELIMITER)[2];
        }
        System.out.println(newName);

        return new BuddyInfo(newName,newAddress, newPhoneNumber );
    }

    public static void main(String[] args) {
//        System.out.println("Hello world!");
        BuddyInfo test = new BuddyInfo ("Homer", "Ottawa", "613");
       // System.out.println("Hello " + test.getName());
        String s = "Mary#Ottawa#613";
        test.importBuddyInfo(s);
    }

    @Override
    public String toString() {
        return  name + DELIMITER + address + DELIMITER + phoneNumber;
    }
}
