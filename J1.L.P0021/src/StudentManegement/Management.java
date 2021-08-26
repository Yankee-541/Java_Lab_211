/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentManegement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Quang
 */
public class Management {

    private List<Student> listStudents;
    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private final int NOT_EXIST = -1;
    private Validation validator = new Validation();

    public Management() {
        listStudents = new ArrayList<>();
        listStudents.add(new Student(1, "Nguyen Van A", 1, "java"));
        listStudents.add(new Student(1, "Nguyen Van A", 2, "java"));
        listStudents.add(new Student(2, "Nguyen Van B", 1, "java"));
        listStudents.add(new Student(2, "Nguyen Van B", 2, ".net"));
    }

    public int getListSize() {
        return listStudents.size();
    }

    public int addStudent(int id, String name, int semester, String course) {
        Student student = new Student(id, name, semester, course);
        try {
            listStudents.add(student);
        } catch (Exception e) {
            return -1;
        }
        return 1;
    }

    public void FindAndSort(String keyWord) {
        List<Student> listStudents = findStudentByName(this.listStudents, keyWord);
        sortListStudent(listStudents);
        displayStudent(listStudents);
    }

    public int checkListIsEmpty() {
        if (listStudents.isEmpty()) {
            return -1;
        }
        return 1;
    }

    public int UpdateOrDelete(int index, Student student) {
        listStudents.set(index, student);
        return 1;
    }

    void Report() {
        String[] courses = new String[]{"java", "net", "c/c++"};
        List<Report> listReports = new ArrayList<>();
        for (String course : courses) {
            for (Student student : listStudents) {
                if (student.getCourse().equalsIgnoreCase(course)) {
                    int count = countTotalCourseByStudentName(listStudents, student.getName(), course);
                    if (count != 0) {
                        Report studentReport = new Report(student.getName(), student.getCourse(), count);
                        if (findReportByNameAndCourse(listReports, student.getName(), student.getCourse()) == NOT_EXIST) {
                            listReports.add(studentReport);
                        }
                    }
                }
            }
        }
        displayReport(listReports);
    }

    private List<Student> findStudentByName(List<Student> List, String keyWord) {
        List<Student> results = new ArrayList<>();
        for (Student student : List) {
            if (student.getName().toLowerCase().contains(keyWord.toLowerCase())) {
                results.add(student);
            }
        }
        return results;
    }

    private void sortListStudent(List<Student> listStudents) {
        Collections.sort(listStudents, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
    }

    private void displayStudent(List<Student> listStudents) {
        System.out.println("List Student");
        for (Student listStudent : listStudents) {
            System.out.println(listStudent.toString());
        }
        System.out.println("");
    }

    public int findStudentById(List<Student> listStudents, int id) {
        for (int i = 0; i < listStudents.size(); i++) {
            Student get = listStudents.get(i); // lấy đối tượng students tại vị trí i
            if (get.getId() == id) {
                return i;
            }
        }
        return NOT_EXIST;
    }

    public int findStudentById(int id) {
        for (int i = 0; i < listStudents.size(); i++) {
            Student get = listStudents.get(i); // lấy đối tượng students tại vị trí i
            if (get.getId() == id) {
                return i;
            }
        }
        return NOT_EXIST;
    }

    private int findReportByNameAndCourse(List<Report> listReport, String name, String course) {
        for (int i = 0; i < listReport.size(); i++) {
            Report report = listReport.get(i);
            if (report.getName().equalsIgnoreCase(name) && report.getCourse().equalsIgnoreCase(course)) {
                return i;
            }
        }
        return NOT_EXIST;
    }

    private int countTotalCourseByStudentName(List<Student> listStudents, String name, String course) {
        int count = 0;
        for (Student student : listStudents) {
            if (student.getName().equalsIgnoreCase(name) && student.getCourse().equalsIgnoreCase(course)) {
                count++;
            }
        }
        return count;
    }

    public Student getStudentByIndex(int index) {
        if (index < listStudents.size()) {
            return listStudents.get(index);
        }
        return null;
    }

    public int removeStudent(int index) {
        if (index < listStudents.size()) {
            listStudents.remove(index);
            return 1;
        } else {
            return -1;
        }
    }

    private void displayReport(List<Report> listReports) {
        System.out.println("List Report");
        for (Report listReport : listReports) {
            System.out.println(listReport.toString());
        }
    }

}
