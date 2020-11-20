import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddressBookView extends JFrame {
    private AddressBookModel addressBook;
    private JList<BuddyInfo> buddyInfoJList;

    public AddressBookView(){
        //create the model and add elements
       // DefaultListModel<BuddyInfo> addressBookModel = new DefaultListModel<>();

        JFrame frame = new JFrame("AddressBook");
        frame.setSize(1000,750);

        //JMenu for addressBook
        JMenuBar addressBookBar = new JMenuBar();
        JMenu addressMenu = new JMenu("Address Menu");

        //JMenu for buddyinfo
        JMenu buddyInfoMenu = new JMenu("BuddyInfo Menu");


        //JMenuItem for addressBook
        JMenuItem item1, item2, item3, item4;

        //create JMenuItems
        item1 = new JMenuItem("Create AddressBook");
        item3 = new JMenuItem("Add a BuddyInfo");
        item4 = new JMenuItem("Remove a BuddyInfo");

        //add action listener to item1
        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                e.getSource();
                System.out.println("Creating address book");
                buddyInfoJList = new JList<>();
                frame.add(buddyInfoJList);
                addressBook = new AddressBookModel();
                buddyInfoJList.setModel(addressBook);
                JOptionPane.showMessageDialog(frame,"Address Book created");


                buddyInfoJList.addListSelectionListener(new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent event) {
                        if (!event.getValueIsAdjusting() && buddyInfoJList.isSelectionEmpty()) {
                            BuddyInfo buddy = buddyInfoJList.getSelectedValue();
                            int del = JOptionPane.showConfirmDialog(frame, buddy + "\nDelete this buddy?");
                            if(del == JOptionPane.OK_OPTION) {
                                try {
                                    addressBook.removeElement(buddy);
                                    buddyInfoJList.clearSelection();
                                    JOptionPane.showMessageDialog(frame, "Buddy removed successfully!");
                                } catch (ArrayIndexOutOfBoundsException exc) {
                                    JOptionPane.showMessageDialog(frame, "Cannot find buddy you want removed");
                                    buddyInfoJList.clearSelection();
                                }
                            }
                        }
                    }
                });
            }
        });


        //add action listener to item3
        item3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog(frame, "Enter Name");
                String address = JOptionPane.showInputDialog(frame, "Enter Address");
                String phoneNumber = JOptionPane.showInputDialog(frame, "Enter Phone Number");
                BuddyInfo newBuddy = new BuddyInfo(name, address, phoneNumber);
                addressBook.addElement(newBuddy.toString());
                JOptionPane.showMessageDialog(frame,"Buddy Info added!");

            }
        });

        item4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(addressBook == null){
                    JOptionPane.showMessageDialog(frame, "Address Book has not been created");
                }
                String index  = JOptionPane.showInputDialog(frame,"Enter index you want removed (starts from 0)");
                addressBook.remove(Integer.parseInt(index));
                JOptionPane.showMessageDialog(frame, "Buddy deleted");
            }
        });

       // add JMenuItems to JMenu
        addressMenu.add(item1);
        buddyInfoMenu.add(item3);
        buddyInfoMenu.add(item4);

        //add JMenu to JMenuBar
        addressBookBar.add(addressMenu);
        addressBookBar.add(buddyInfoMenu);


        //set JMenuBar in frame
        frame.setJMenuBar( addressBookBar );
        frame.setVisible(true);
    }

    public static void main (String[] args) {
        new AddressBookView();
    }

}
