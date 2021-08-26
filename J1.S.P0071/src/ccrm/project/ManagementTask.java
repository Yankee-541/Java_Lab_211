/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccrm.project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yankee
 */
public class ManagementTask {
        Validation validator = new Validation();
        private  List<Task> listTask = new ArrayList<>();

    public ManagementTask() {
         listTask = new ArrayList<>();
         listTask.add(new Task(1, "Dev" , "Code" , "28-08-2015" , 8.5,17.0 , "Dev","L"));
         listTask.add(new Task(2, "C" , "test" , "28-08-2016" , 8, 16 , "c","E"));
         listTask.add(new Task(3, "Java" , "learn" , "28-08-2017" , 8 , 16 , "S","G"));
         listTask.add(new Task(4, "Dev" , "manager" , "28-08-2018" , 8 , 16 , "D","H"));               
    }

    public List<Task> getListTask() {
        return listTask;
    }

    public void setListTask(List<Task> listTask) {
        this.listTask = listTask;
    }
        

    void addTask() {
        int id = 1; // nếu list rỗng id bằng 1
        if(!listTask.isEmpty()){
            id = listTask.get(listTask.size()-1).getId()+1; // lấy id cuối + 1
        }
        System.out.println("-----------Add Task---------");
        String name = validator.getString("Requirment name: ", "Invalid Name,please re-enter:", "[a-zA-Z ]+");
        System.out.print("Task Type: ");
        String tasktype = validator.getIdName("Task tpye: ","Task type (1-4)");
        String date = validator.getDate("Enter Date: ","Date invalid !");
        double from = validator.getDouble("From: ", "Plan from must between 8h and 17h30", 8, 17.5);
        double to = validator.getDouble("To: ", "Plan to must between 8h and 17h30", 8, 17.5);
        do{
            System.out.println("Plan From must be less than Plan To");
            from = validator.getDouble("From: ", "Plan from must between 8h and 17h30", 8, 17.5);
            to = validator.getDouble("To: ", "Plan to must between 8h and 17h30", 8, 17.5);
        }
        while(from >= to);
        String assginee = validator.getString("Assignee: ", "Invalid Assignee,please re-enter: ", "[a-zA-Z ]+");
        String reviewer = validator.getString("Reviewer: ", "Invalid Reviewer,please re-enter: ", "[a-zA-Z ]+");
        Task tasks = new Task(id, name, tasktype, date, from, to, assginee, reviewer);
        listTask.add(tasks);
    }

    void deleteTask() {
        int id = validator.getInt("Enter id to delete: ", "Please enter a positive integer", 1, Integer.MAX_VALUE);
        boolean isIdExist = false;
        for (int i = 0; i < listTask.size(); i++) {
            Task tasks = listTask.get(i); //lấy đối tượng ra 
            if(tasks.getId() == id){//tồn tại id trong list 
                listTask.remove(i);   
                isIdExist = true; // khi mà id có tồn tại
                System.out.println("Delete successfully");
                break;
            }
        }
        if(!isIdExist){
            System.out.println("Delete fail");
        }
    }
    
        void showTask() {
            System.out.println("------------------------------Task------------------------------");
            System.out.format("%-5s%-15s%-15s%-15s%-15s%-15s%-15s","Id","Name","Task type","Date","Time","Assignee","Reviewer");
            System.out.println("");
            for (Task task : listTask) {
                System.out.println(task.toString());
            }
    }
        
}
