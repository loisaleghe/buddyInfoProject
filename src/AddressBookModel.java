import javax.swing.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Objects;
import java.util.Scanner;

public class AddressBookModel extends DefaultListModel {

  // private DefaultListModel<BuddyInfo> buddyInfos;

    public AddressBookModel(){

    }

    public void addBuddy(BuddyInfo aBuddy){
        if(aBuddy != null) {
            this.addElement(aBuddy);
        }
    }

    public void removeBuddy(int index){
        if(index >= 0 && index < this.size()) {
             this.remove(index);
        }

    }

    public static void main (String[] args) {
        System.out.println("Address Book");
        BuddyInfo buddy = new BuddyInfo("Tom", "Carleton", "613");
        AddressBookModel addressBook = new AddressBookModel();
        addressBook.addBuddy(buddy);
       // addressBook.removeBuddy(0);
        BuddyInfo b= (BuddyInfo) addressBook.get(0);
        System.out.println(b.getName());
        System.out.print("Testing the branch");
    }

    public void save(String fileName) throws IOException {

        FileOutputStream os = new FileOutputStream(fileName);
        ObjectOutputStream p = new ObjectOutputStream(os);

        Scanner sc = new Scanner(this.toString());
        sc.useDelimiter("#");
        while(sc.hasNext()) {
            byte[] bytesArray = sc.next().getBytes();
            p.write(bytesArray);
        }
        os.close();


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressBookModel that = (AddressBookModel) o;
//        return Objects.equals(buddyInfos, that.buddyInfos);
        return Objects.equals(this, that);

    }




    @Override
    public String toString() {
        return "AddressBookModel{" +
                "buddyInfos=" + this +
                '}';
    }
}
