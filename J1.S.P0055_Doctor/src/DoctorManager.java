
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author admin
 */
public class DoctorManager {

    private List<Doctor> list;

    public DoctorManager() {
    }

    public DoctorManager(List<Doctor> list) {
        this.list = list;
    }

    public void menu() {
        System.out.println("=======Doctor management=======");
        System.out.println("1.Add Doctor");
        System.out.println("2.Update Doctor");
        System.out.println("3.Delete Doctor");
        System.out.println("4.Search Doctor");
        System.out.println("5.Exit");
    }

    public void search() {
        Validation v = new Validation();
        System.out.println("--------Search doctor---------");
        String name = v.getName("Input name or id: ").toLowerCase();
        int count = 0;
        for (Doctor o : list) {
            if (o.getName().toLowerCase().contains(name) || o.getCode().toLowerCase().contains(name)) {
                count++;
                if (count == 1) {
                    System.out.println("========Result=========");
                }
                System.out.println(o);

            } else if (o.toString().contains(name)) {
                System.out.println(o);
            }
        }
        if (count == 0) {
            System.out.println("not found");
        }
    }

    public void delete() {
        Validation v = new Validation();
        System.out.println("========Delate doctor=========");
        String code = v.getString("Enter code: ");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCode().equals(code)) {
                list.remove(i);
                System.out.println("Remove success");
                break;
            }
        }
    }

    public void add() {
        Validation v = new Validation();
        String code;
        while (true) {
            code = v.getString("Enter code: ");
            int count = 0;
            for (Doctor o : list) {
                if (o.getCode().equals(code)) {
                    count = 1;
                    break;
                }
            }
            if (count == 0) {
                break;
            } else {
                System.out.println("Doctor code exist");
            }
        }

        String name = v.getString("Enter name: ");
        String special = v.getString("Enter specialization: ");
        int available = v.getNumber("Enter Availablity: ");
        list.add(new Doctor(code, name, special, available));

    }

    public void update() {
        Validation v = new Validation();
        String code;
        while (true) {
            code = v.getString("Enter code: ");
            int count = 0;
            for (Doctor o : list) {
                if (o.getCode().equals(code)) {
                    count = 1;
                    break;
                }
            }
            if (count == 1) {
                break;
            } else {
                System.out.println("Doctor code doesn’t exist");
            }
        }

        String name = v.getString("Enter name: ");
        String special = v.getString("Enter specialization: ");
        int available = v.getNumber("Enter Availablity: ");
        for (Doctor o : list) {
            if (o.getCode().equals(code)) {
                o.setName(name);
                o.setSpecial(special);
                o.setAvalable(available);
                break;
            }
        }
    }

    public void addData() {
        list.add(new Doctor("doc 1", "dang", "good", 1));
        list.add(new Doctor("doc 2", "tuan", "bad", 2));
        list.add(new Doctor("doc 3", "longvt", "lazy", 3));
        list.add(new Doctor("doc 4", "tom", "beauty", 4));
        list.add(new Doctor("doc 5", "ky", "healthy", 5));
        list.add(new Doctor("doc 6", "tien", "ugly", 6));
    }

    public static void main(String[] args) {
        List<Doctor> list = new ArrayList<>();
        DoctorManager d = new DoctorManager(list);
        Scanner sc = new Scanner(System.in);
        Validation v = new Validation();
        d.addData();
        while (true) {
            d.menu();
            int choice = v.getNumber("Input choice: ");
            switch (choice) {
                case 1:
                    //add
                    d.add();
                    break;
                case 2:
                    //update
                    d.update();
                    break;
                case 3:
                    //delete
                    d.delete();
                    break;
                case 4:
                    //search
                    d.search();
                    break;
                case 5:
                    System.exit(0);
                    //exit
                    break;
            }
        }
    }
}
