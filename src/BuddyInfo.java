public class BuddyInfo {

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
    public static void main(String[] args) {
        System.out.println("Hello world!");
        BuddyInfo test = new BuddyInfo ("Homer", "Ottawa", "613");
        System.out.println("Hello " + test.getName());
    }
}
