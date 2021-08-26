
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Yankee
 */
public class Managerment {

    private List<Contact> list;

    public Managerment() {
    }

    public Managerment(List<Contact> list) {
        this.list = list;
    }

    public void data() {
        list.add(new Contact(50, "Dang", "ABC", "Hung Yen", "0312654987"));
        list.add(new Contact(60, "Duy", "ABC", "Hung Yen", "0312654987"));
        list.add(new Contact(70, "Hue", "ABC", "Hung Yen", "0312654987"));
    }

    public void menu() {
        System.out.println("1. Add a contact.");
        System.out.println("2. Display all contacts");
        System.out.println("3. Delete a contact");
        System.out.println("4. Exit");
    }

    public boolean addContact(Contact c) {
        list.add(c);
        return true;
    }

    public boolean listIsEmpty() {
        return list.isEmpty();
    }

    public boolean exitsID(int ID) {
        for (Contact c : list) {
            if (c.getID() == ID) {
                return true;
            }
        }
        return false;
    }

    public void remove(int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getID() == id) {
                System.out.printf("%-10s | %-10s | %-10s | %-10s | %-10s\n", "ID", "Name", "Group", "Address", "phone");
                System.out.printf("%-10s | %-10s | %-10s | %-10s | %-10s\n", list.get(i).getID(), list.get(i).getName(), list.get(i).getAddress(), list.get(i).getGroup(), list.get(i).getPhone());
                list.remove(i);
                System.out.println("Remove success.");
                break;
            }
        }
    }

    public void display(Contact c) {
        System.out.printf("%-10s | %-10s | %-10s | %-10s | %-10s\n", c.getID(), c.getName(), c.getAddress(), c.getGroup(), c.getPhone());
    }

    public void displayAll() {
        System.out.printf("%-10s | %-10s | %-10s | %-10s | %-10s\n", "ID", "Name", "Group", "Address", "phone");
        for (Contact contact : list) {
            display(contact);
        }
    }
}
