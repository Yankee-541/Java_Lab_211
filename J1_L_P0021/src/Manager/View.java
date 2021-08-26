/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Entity.Student;
import java.util.ArrayList;

/**
 *
 * @author Yankee
 */
public class View {
    public void menu(){
            System.out.println(" 1.	Create");
            System.out.println(" 2.	Find and Sort");
            System.out.println(" 3.	Update/Delete");
            System.out.println(" 4.	Report");
            System.out.println(" 5.	Exit");
            System.out.print(" Enter your choice: ");
    }

    public void run() {
        
        ArrayList<Student> listStudent = new ArrayList<>();
        Manager manager = new Manager(listStudent);
        listStudent.add(new Student("2", "B", "C", "3"));
        listStudent.add(new Student("2", "B", "C", "1"));
        listStudent.add(new Student("3", "A", "C", "2"));
        listStudent.add(new Student("2", "B", "Python", "4"));
        listStudent.add(new Student("2", "B", "C++", "1"));
        while (true) {
            menu();
            int choice = Validation.checkInputIntLimit(1, 6);
            switch (choice) {
                case 1:
                    manager.createStudent();
                    break;
                case 2:
                    manager.findAndSort();
                    break;
                case 3:
                    manager.updateOrDelete();
                    break;
                case 4:
                    manager.report();
                    break;
                case 5:
                    return;
                case 6:
                    manager.displayAll();
                    break;
            }
        }
    }
}
