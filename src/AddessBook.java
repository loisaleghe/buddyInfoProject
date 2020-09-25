import java.util.ArrayList;

public class AddessBook {
    ArrayList<BuddyInfo> buddyInfos;

    public AddessBook(){
        buddyInfos = new ArrayList<BuddyInfo>();
    }

    public void addBuddy(BuddyInfo aBuddy){
        buddyInfos.add(aBuddy);
    }

    public void removeBuddy(BuddyInfo aBuddy){
    buddyInfos.remove(aBuddy);
    }

    public static void main (String[] args) {
        System.out.println("Address Book");
        BuddyInfo buddy = new BuddyInfo("Tom", "Carleton", "613");
        AddessBook addressBook = new AddessBook();
        addressBook.addBuddy(buddy);
        addressBook.removeBuddy(buddy);
    }
}
