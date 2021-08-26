
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class Viewer {

    Manager m;
    Validation v = new Validation();
    List<Task> task = new ArrayList<>();

    public Viewer(Manager m) {
        this.m = m;
    }

    public void menu() {
        System.out.println("---------- Task Manager ---------");
        System.out.println("1. Add Task");
        System.out.println("2. Delete Task");
        System.out.println("3. Display Task");
        System.out.println("4. Exit");
    }

    public void addTask() {
        System.out.println("\t\t\tAdd task");
        while (true) {
            int id = ID();
            String requirementName = v.inputName("Requirement Name: ");
            String taskTypeId = getType();
            Date date = v.InputDate("Date: ");
            String planFrom = v.inputPlanFrom("Time from: ");

            String planTo = "";
            while (true) {
                planTo = v.getTime("Time to: ");
                if (Double.parseDouble(planTo) > Double.parseDouble(planFrom)) {
                    break;
                } else {
                    System.err.println("End time must bigger than start time! Re-enter.");
                }
            }
            String assignee = v.inputName("Assignee: ");
            String reviewer = v.inputName("Reviewer: ");
//            m.list.add(new Task(id, taskTypeId, requirementName, date, planFrom, planTo, assignee, reviewer));
            Task t = new Task(id, taskTypeId, requirementName, date, planFrom, planTo, assignee, reviewer);
            m.addTask(t);
            String choice = v.getYN("-Are you want to add continue(Y/N): ");
            if (choice.equalsIgnoreCase("Y")) {
            } else {
                display();
                break;
            }
        }
    }

    public void delete() {
        if (m.list.isEmpty()) {
            System.out.println("(*)List task empty! You must add task first.");
            return;
        }
        System.out.println("\t\t\tDelete Task");
        while (true) {

            int id = m.inputExistedID();
            m.deleteTask(id);

            System.out.println("Remove employee successful.");
            String choice = v.getYN("-Are you want to add continue(Y/N): ");
            if (choice.equalsIgnoreCase("Y")) {
            } else {
                display();
                break;
            }
        }
    }

    public void display() {
        if (m.list.isEmpty()) {
            System.out.println("(*)List empty! You must add task first.");
            return;
        }
        m.displayAll();
    }

    public int ID() {
        int id = 1; // nếu list rỗng id bằng 1
        if (!m.list.isEmpty()) { //không rỗng thì
            id = m.list.get(m.list.size() - 1).getId() + 1; // lấy id cuối + 1
        }
        return id;
    }

    public String getType() {
        String type;
        while (true) {
            int choice = m.getChoice("Task Type (1.Code, 2.Test, 3.Manager, 4.Learn): ", 1, 4, "Type must be 1.Code, 2.Test, 3.Manager, 4.Learn!\nRe-input: ");
            switch (choice) {
                case 1:
                    type = "Code";
                    return type;
                case 2:
                    type = "Test";
                    return type;
                case 3:
                    type = "Manager";
                    return type;
                case 4:
                    type = "Learn";
                    return type;
            }
        }
    }
}
