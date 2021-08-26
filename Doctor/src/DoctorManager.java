
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
 * @author alias
 */
public class DoctorManager {

    public void menu() {
        System.out.println("=======Doctor management=======");
        System.out.println("1.Add Doctor");
        System.out.println("2.Update Doctor");
        System.out.println("3.Delete Doctor");
        System.out.println("4.Search Doctor");
        System.out.println("5.Exit");
    }

    public void addDoctor(List<Doctor> list) {
        Validation v = new Validation();
        String code;
        while(true){
            code = v.getString("Enter code: ");
            int check = 0;
            for (Doctor o : list) {
                if(o.getCode().equals(code)){
                    check = 1;
                }
            }
            if(check == 0){
                break;
            }else{
                 System.out.println("Code is exits, please input again");
            }
        }
        String name = v.getString("Enter name: ");
        String special = v.getString("Enter specialization: ");
        int available = v.getNumber("Enter Availablity: ");
        Doctor doctor = new Doctor(code, name, special, available);
        list.add(doctor);
    }

    public void updateDoctor(List<Doctor> list) {
        Validation v = new Validation();
        String code;
        while(true){
            code = v.getString("Enter code: ");
            int check = 0;
            for (Doctor o : list) {
                if(o.getCode().equals(code)){
                    check = 1;
                }
            }
            if(check == 1){
                break;
            }else{
                 System.out.println("Code isn't exits, please input again");
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

    public void deleteDoctor(List<Doctor> list) {
        Validation v = new Validation();
        System.out.println("-------Delete doctor-------");
        String code;
        while(true){
            code = v.getString("Enter code: ");
            int check = 0;
            for (Doctor o : list) {
                if(o.getCode().equals(code)){
                    check = 1;
                }
            }
            if(check == 1){
                break;
            }else{
                 System.out.println("Code isn't exits, please input again");
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getCode().equals(code)){
                list.remove(i);
                System.out.println("Delete successfully");
                break;
            }
        }
    }

    public void search(List<Doctor> list, String txtSearch) {
        System.out.println("-------Search doctor-------");
        for (Doctor o : list) {
            if (o.getName().contains(txtSearch)) {
                System.out.println(o);
            }
        }
    }

    public static void main(String[] args) {
        DoctorManager d = new DoctorManager();
        Scanner sc = new Scanner(System.in);
        Validation v = new Validation();
        d.menu();
        List<Doctor> list = new ArrayList<>();
        while (true) {
            int choice = v.getNumber("Input choice: ");
            switch (choice) {
                case 1:
                    //add
                    d.addDoctor(list);
                    break;
                case 2:
                    //update
                    d.updateDoctor(list);
                    break;
                case 3:
                    d.deleteDoctor(list);
                    //delete
                    break;
                case 4:
                    //search
                    System.out.println("-------Search doctor-------");
                    System.out.print("Enter text: ");
                    String txtSearch = sc.nextLine();
                    d.search(list, txtSearch);
                    break;
                case 5:
                    System.exit(0);
                    //exit
                    break;
            }
        }
    }
}
