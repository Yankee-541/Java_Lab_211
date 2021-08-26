/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;
/*
    Yankee
*/
import Entity.Report;
import Entity.Student;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Manager {

    public ArrayList<Student> ls;
    Scanner sc = new Scanner(System.in);

    public Manager() {
    }

    public Manager(ArrayList<Student> ls) {
        this.ls = ls;
    }

    public void createStudent() {

        while (true) {
            int count = ls.size();
            if (count >= 3) {
                System.out.print("Do you want to continue (Y/N): ");
                if (!Validation.checkInputYN()) {
                    return;
                }
            }

            System.out.print("Enter id: ");
            String id = Validation.checkInputString();

            String name = "";
            if (!Validation.checkIdExist(ls, id)) {
                System.err.println("ID: " + id + " asigned by student!");
                displayByID(id);
                System.out.print("Do you want to asign new course? (Y/N): ");
                if (Validation.checkInputYN()) {
                    for (Student l : ls) {
                        if (l.getId().equalsIgnoreCase(id)) {
                            name = l.getStudentName();
                            break;
                        }
                    }
                    System.out.print("Enter semester: ");
                    String semester = Validation.checkInputString();
                    System.out.print("Enter name course: ");
                    String course = Validation.checkInputCourse();

                    if (Validation.checkStudentExist(ls, id, name, course, semester)) {
                        ls.add(new Student(id, name, course, semester));
                        System.err.println("Add student successfully.");
                    }
                }
            } else {
                System.out.print("Enter name student: ");
                name = Validation.checkInputString();
                System.out.print("Enter semester: ");
                String semester = Validation.checkInputString();
                System.out.print("Enter name course: ");
                String course = Validation.checkInputCourse();
                if (Validation.checkStudentExist(ls, id, name, course, semester)) {
                    ls.add(new Student(id, name, course, semester));
                    System.err.println("Add student successfully.");
                }
            }
        }
    }

    public void findAndSort() {

        if (ls.isEmpty()) {
            System.err.println("List empty.");
            return;
        } else {
            Collections.sort(ls, new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    return o1.getStudentName().compareToIgnoreCase(o2.getStudentName()); //To change body of generated methods, choose Tools | Templates.
                }
            });

            System.out.print("Enter name to search: ");
            String name = Validation.checkInputString();
            Header();
            for (Student student : ls) {
                if (student.getStudentName().toLowerCase().contains(name.toLowerCase())) {
                    student.print();
                }
            }
        }

    }

    public void updateOrDelete() {
        while (true) {
            System.out.print("Enter id: ");
            String id = Validation.checkInputString();
            int noOfStudentInID = displayByID(id);
            if (noOfStudentInID != 0) {
                System.out.print("Do you want to update (U) or delete (D) student: ");
                if (Validation.checkInputUD()) {
                    System.out.print("You want to update at index: ");
                    int index = sc.nextInt();
                    updateAStudent(index, id);
                    System.err.println("After Updateing");
                    displayByID(id);
                } else {
                    System.out.print("You want to delete at index: ");
                    int index = sc.nextInt();
                    deleteAStudent(index, id);
                    System.err.println("After delete:");
                    displayByID(id);
                }
            }

            System.out.print("Update or delete continue? (Y/N): ");
            if (!Validation.checkInputYN()) {
                break;
            }

        }

    }

    private void updateAStudent(int index, String id) {
        int i = 1;
        String name = "", course = "", semester = "";

        for (Student student : ls) {
            if (student.getId().equalsIgnoreCase(id) && i == index) {
                System.out.print("Do you want to update name (Y/N): ");
                if (Validation.checkInputYN()) {
                    System.out.print("Enter name student: ");
                    name = Validation.checkInputString();
                    for (Student l : ls) {
                        if (l.getId().equalsIgnoreCase(id)) {
                            l.setStudentName(name);
                        }
                    }
                }

                System.out.print("Do you want to update semester? (Y/N): ");
                if (Validation.checkInputYN()) {
                    System.out.print("Enter semester: ");
                    semester = Validation.checkInputString();
                }
                System.out.print("Do you want to update course name? (Y/N): ");
                if (Validation.checkInputYN()) {
                    System.out.print("Enter name course: ");
                    course = Validation.checkInputCourse();
                }

                if (!Validation.checkChangeInfomation(student, id, name, semester, course)) {
                    System.err.println("Nothing change.");
                }
                if (Validation.checkStudentExist(ls, id, name, semester, course)) {
//                    student.setId(idStudent); // id ko được thay đổi
//                    student.setStudentName(name);
                    student.setSemester(semester);
                    student.setCourseName(course);
                    System.err.println("Update success.");
//                    return;
                }
                break;
            } else if (student.getId().equalsIgnoreCase(id)) {
                i++;
            }
        }
    }

    private void deleteAStudent(int index, String id) {
        int i = 1;

        for (int j = 0; j < ls.size(); j++) {
            if (ls.get(j).getId().equalsIgnoreCase(id) && i == index) {
                ls.remove(j);
                System.err.println("Delete success.");
                break;
            } else if (ls.get(j).getId().equalsIgnoreCase(id)) {
                i++;
            }
        }
    }

    public int displayByID(String id) { // display theo id đồng thời đếm xem có bao nhiêu student đứng dưới ID đó
        int index = 1;
        boolean hasFound = false;
        boolean hasPrinted = false;
        for (Student student : ls) {
            if (id.equalsIgnoreCase(student.getId())) {
                if (!hasPrinted) {// if found students have ID x,(print header once time)
                    System.out.println("Student(s) was registed by ID: " + id + " is: ");
                    System.out.printf("%-6s |   %-5s |     %-19s |       %-19s |       %-5s\n",
                            "INDEX", "ID", "NAME", "COURSE NAME", "SEMESTER");
                    hasPrinted = true;
                }
                System.out.printf("%-6d |   %-5s |     %-19s |       %-19s |       %-5s\n", index, student.getId(),
                        student.getStudentName(), student.getCourseName(), student.getSemester());
                hasFound = true;
                index++;
            }
        }
        if (!hasFound) {
            System.err.println("=> Not found student with ID: " + id);
            index = 0;
        }

        return index;
    }

    public void displayAStudent(String id) {
        Header();
        for (Student student : ls) {
            if (student.getId().equalsIgnoreCase(id)) {
                student.print();
                break;
            }
        }
    }

    public void displayAll() {
        Header();
        for (Student student : ls) {
            student.print();
        }
    }

    public void Header() {
        System.out.printf("%-5s |     %-19s |       %-19s |       %-5s\n", "ID", "NAME", "COURSE NAME", "SEMESTER");

    }

    public void report() {
        if (ls.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        ArrayList<Report> lr = new ArrayList<>();
        ArrayList<Student> ls2 = new ArrayList<>(ls);
        int total = 0;
        for (int i = 0; i < ls2.size(); i++) {
            total = 1;
            String id = ls2.get(i).getId();
            String courseName = ls2.get(i).getCourseName();
            String studentName = ls2.get(i).getStudentName();
            for (int j = i + 1; j < ls2.size(); j++) {
                if (ls2.get(j).getId().equalsIgnoreCase(id)
                        && ls2.get(j).getStudentName().equalsIgnoreCase(studentName) && ls2.get(j).getCourseName().equalsIgnoreCase(courseName)) {
                    total++;
                    ls2.remove(j);
                    j--;
                }

            }
            if (Validation.checkReportExist(lr, studentName,
                    courseName, total)) {
                lr.add(new Report(id, studentName, courseName, total));
            }
        }

        System.out.printf("%-5s |     %-19s |       %-19s |    %-15s\n", "ID", "NAME", "COURSE NAME", "TOTAL COURSE");
        for (Report r : lr) {
            System.out.printf("%-5s |     %-19s |       %-19s |    %-15d\n", r.getId(), r.getStudentName(), r.getCourseName(), r.getTotalCourse());
        }
    }
}
