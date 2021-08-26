
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Yankee
 */
public class Manager {

    List<Task> list;
    Validation v = new Validation();
    Scanner sc = new Scanner(System.in);

    public Manager(List<Task> taskList) {
        this.list = taskList;
    }

    public void data() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        list.add(new Task(1, "Code", "Java", sdf.parse("14-05-2015"), "8.5", "17.0", "A", "C"));
        list.add(new Task(2, "Test", "Html", sdf.parse("14-05-2016"), "9.0", "16.0", "BD", "CB"));
        list.add(new Task(3, "Learn", "Css", sdf.parse("14-05-2017"), "9.5", "15.0", "Cg", "Ah"));
        list.add(new Task(4, "Manager", "JS", sdf.parse("14-05-2018"), "10.0", "14.0", "DR", "DE"));
    }

//        public boolean addTask(Task task) {
//        list.add(task);
//        return true;
//    }
    public List<Task> addTask(Task task) {
        list.add(task);
        return list;
    }

//    public List<Task> deleteTask(int id) {
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).getId() == id) {
//                list.remove(i);
//            }
//        }
//        return list;
//    }
    
    public void deleteTask(int id) {
        for (Task task : list) {
            if (id == task.getId()) {
                list.remove(task);
                return;
            }
        }
    }

    public int inputExistedID() {
        while (true) {
            int id = v.inputInt("Enter ID: ");
            if (isDuplicatedID(id)) {
                return id;
            } else {
                System.out.print("ID not found, enter again: ");
            }
        }
    }

    public boolean isDuplicatedID(int id) {
        for (Task t : list) {
            if (t.getId() == id) {
                return true;
            }
        }
        return false;
    }
//    public int inputExistedID() {
//        while (true) {
//            int id = v.inputInt("Enter ID: ");
//            for (Task t : list) {
//                if (t.getId() == id) {
//                    display(id);
//                    return id;
//                }
//            }
//        }
//    }

    public int getChoice(String mess, int min, int max, String err) {
        int choice = 0;
        System.out.print(mess);
        while (true) {
            try {
                choice = Integer.parseInt(sc.nextLine());
                if (choice > max || choice < min) {
                    System.err.print(err);
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.err.print(err);
            }
        }
        return choice;
    }

    public void displayAll() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("\n\t\t\t\t\t\tTask");
        System.out.printf("%-5s | %-10s | %-15s | %-15s | %-15s | %-15s | %-15s\n", "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
        for (Task task : list) {
            System.out.print(task.toString());
        }
    }

    public int display(int id) {
        SimpleDateFormat spf = new SimpleDateFormat("dd-MM-yyyy");
        for (int i = 0; i < list.size(); i++) {
            if (id == list.get(i).getId()) {
                System.out.printf("%-5s | %-10s | %-15s | %-15s | %-15s | %-15s | %-15s\n",
                        "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
                System.out.printf("%-5d | %-10s | %-15s | %-15s | %-15f | %-15s | %-15s\n",
                        list.get(i).getId(), list.get(i).getRequirementName(), list.get(i).getTaskTypeId(),
                        spf.format(list.get(i).getDate()),
                        Double.parseDouble(list.get(i).getPlanTo()) - Double.parseDouble(list.get(i).getPlanFrom()),
                        list.get(i).getassign(), list.get(i).getreviewer());
                return i;
            }
        }
        return 0;
    }
}
