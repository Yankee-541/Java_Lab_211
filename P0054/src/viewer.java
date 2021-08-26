/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yankee
 */
public class viewer {

    Managerment mn;
    validate v = new validate();
    Contact c = new Contact();

    public viewer(Managerment mn) {
        this.mn = mn;
    }

    public void add() {
        System.out.println("\t\t\tAdd Contact.");
        int id = 0;

        while (true) {
            id++;
            System.out.println("ID: " + id);

            if (mn.exitsID(id)) {
                continue;
            }

            String name = v.getString("Enter name: ");
            String group = v.getString("Enter group: ");
            String address = v.getString("Enter add: ");
            String phone = v.getPhone("Enter phone: ");
            System.out.println("> Add successfullu!!");
            Contact c = new Contact(id, name, group, address, phone);
            mn.addContact(c);
            String YN = v.getYN("Do you continute add contact (Y/N): ");
            if (YN.equalsIgnoreCase("Y")) {
            } else {
                mn.displayAll();
                break;
            }
        }

    }

    public void display() {

        System.err.println("\t\t\t\tDisplay all contact.");
        mn.displayAll();
    }

    public void delete() {
        if (mn.listIsEmpty()) {
            System.out.println("You need add contact first.");
            return;
        }
        System.out.println("\t\t\t\tRemove contact.");
        while (true) {
            int id = v.number("Enter ID: ");
            if (!mn.exitsID(id)) {
                System.out.println("ID doesn't exist.");
                continue;
            }
            mn.remove(id);
            mn.displayAll();

            String YN = v.getYN("Do you continute add contact (Y/N): ");
            if (YN.equalsIgnoreCase("Y")) {
            } else {
                mn.displayAll();
                break;
            }
        }

    }

}
