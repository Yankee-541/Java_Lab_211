/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentManegement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Quang
 */
public class View {

    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private Validation validator = new Validation();
    private Management manager = new Management();

    public View() {

    }

    void addStudent() {
        int count = manager.getListSize();
        while (true) {
            if (count >= 10) {
                String choice = validator.getString("Do you want to continue (Y/N)?", "Choice(y/n)", "^[yYnN]");
                if (choice.equalsIgnoreCase("n")) {
                    break;
                }
            }
            int id = validator.getInt("Enter ID: ", "ID must be positive integer and not digits", 1, Integer.MAX_VALUE);
            if (manager.findStudentById(id) != -1) {
                System.out.println("ID is exist,please enter another ID");
                continue;
            }
            String name = validator.getString("Enter Student name: ", "Student name invalid", "[a-zA-Z ]+");
            int semester = validator.getInt("Enter semester: ", "Semester [1-9]", 1, 9);
            System.out.println("Course : java,.net,c/c++");
            String course = validator.checkInpuCourse("Enter course: ", "Course(java,.net,c/c++)");
            manager.addStudent(id, name, semester, course);
            System.out.println("Add Successfully");
            count++;
            break;
        }
    }

    void FindAndSort() {
        String keyWord = validator.getString("Enter Name to Find and Sort : ", "Student name invalid", "[a-zA-Z ]+");
        manager.FindAndSort(keyWord);
    }

    void UpdateOrDelete() {
        if (manager.checkListIsEmpty() == -1) {
            System.out.println("List is empty");
            return;
        }
        int id = validator.getInt("Enter ID: ", "ID must be positive integer and not digits", 1, Integer.MAX_VALUE);
        int indexStudent = manager.findStudentById(id);
        Student student = manager.getStudentByIndex(indexStudent);
        if (indexStudent == -1) {
            System.out.println("Student not exist");
        } else {
            String choice = validator.getString("Do you want to update (U) or delete (D) student? \nYour Choice: ", "You must enter (U/D)", "[UuDd]");
            if (choice.equalsIgnoreCase("u")) {
                String newName = validator.getString("Enter new student name: ", "Student name invalid", "^[a-zA-Z ]+");
                if (!newName.trim().equals("")) {
                    student.setName(newName);
                }
                String newSemester = validator.getString("Enter new semester: ", "Semester [1-9]", "[1-9 ]{1}");
                if (!newSemester.trim().equals("")) {
                    student.setSemester(Integer.parseInt(newSemester));
                }
                String newCourse = "";
                while (true) {
                    try {
                        System.out.print("Enter New Course: ");
                        newCourse = in.readLine();
                        if (!newCourse.equalsIgnoreCase("java")
                                && !newCourse.equalsIgnoreCase(".net")
                                && !newCourse.equalsIgnoreCase("c/c++")) {
                            System.out.println("Course(java,.net,c/c++)");
                            continue;
                        }
                        break;
                    } catch (Exception e) {
                    }
                }

                if (!newCourse.trim().equals("")) {
                    student.setCourse(newCourse);
                }
                System.out.println("Update Successfully");
            } else {
                manager.removeStudent(indexStudent);
                System.out.println("Delete Successfully");
            }
        }
        manager.UpdateOrDelete(indexStudent, student);
    }

    void Report() {
        manager.Report();
    }
}
