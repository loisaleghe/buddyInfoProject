import java.util.ArrayList;

public class AddessBook {
    private ArrayList<BuddyInfo> buddyInfos;

    public AddessBook(){
        buddyInfos = new ArrayList<BuddyInfo>();
    }

    public void addBuddy(BuddyInfo aBuddy){
        if(aBuddy != null)
        buddyInfos.add(aBuddy);
    }

    public BuddyInfo removeBuddy(int index){
        if(index >= 0 && index < buddyInfos.size()) {
            return buddyInfos.remove(index);
        }
        return null;
    }

    public static void main (String[] args) {
        System.out.println("Address Book");
        BuddyInfo buddy = new BuddyInfo("Tom", "Carleton", "613");
        AddessBook addressBook = new AddessBook();
        addressBook.addBuddy(buddy);
        addressBook.removeBuddy(0);
        System.out.print("Testing the branch")
    }
}
