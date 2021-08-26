/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0101.employees;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Yankee
 
 * https://docs.google.com/document/d/1CM3tEwioYgqPaSx7ul4vAME7znlV4zqT/edit
 */
public class Employees {
    String id;
    String firstName;
    String lastName;
    String phoneNumber;
    String email;
    String address;
    Date DOB;
    String sex;
    double salary;
    String Egency;
    
    public Employees() {
    }

    public Employees(String id, String firstName, String lastName, String phoneNumber, 
            String email, String address, Date DOB, String sex, double salary, String Egency) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.DOB = DOB;
        this.sex = sex;
        this.salary = salary;
        this.Egency = Egency;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public Date getDOB() {
        return DOB;
    }

    public String getSex() {
        return sex;
    }

    public double getSalary() {
        return salary;
    }

    public String getEgency() {
        return Egency;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setEgency(String Egency) {
        this.Egency = Egency;
    }

    void display(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.printf("%-10s | %-11s | %-11s | %-13s | %-30s | %-18s | %-15s | %-8s | %-10.3f | %-15s\n", 
                id, firstName, lastName, phoneNumber, email, address, sdf.format(DOB), sex, salary, Egency);
    }
    
}
