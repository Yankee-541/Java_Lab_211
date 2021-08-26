/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0101.employees;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Yankee
 */
public class Main {

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        ArrayList<Employees> empList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        empList.add(new Employees("1", "Tom", "A", "031689458", "Tom@fpt.vn", "Ha Noi", sdf.parse("16/02/1992"), "female", 20, "not"));
        empList.add(new Employees("2", "Tep", "B", "031689458", "Tep@fpt.vn", "Ha Noi", sdf.parse("16/02/1997"), "female", 12, "not"));
        empList.add(new Employees("3", "Cua", "A", "031689458", "Cua@fpt.vn", "Ha Noi", sdf.parse("16/02/1998"), "female", 17, "not"));
        Managermant mn = new Managermant(empList);
        View vw = new View(mn);
        int option = 0;
        while (true) {
            vw.displayMenu();
            System.out.print("Your selection: ");
            try {
                option = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Option must be interger! Re-enter.");
                sc.nextLine();
            }

            if (option == 6) {
                break;
            }
            switch (option) {
                case 1:
                    vw.createEmp();
                    break;
                case 2:
                    vw.updateEmp();
                    break;
                case 3:
                    vw.removeEmp();
                    break;
                case 4:
                    vw.searchEmp();
                    break;
                case 5:
                    vw.sortBySalary();
                    break;
                case 7:
                    vw.Header();
                    vw.displayEmpList();
                    break;
                default:
                    System.out.println("Option must be from 1 to 6! Re-enter.");
            }

        }
    }
}
