/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1_s_p0070;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
/**
 *
 * @author Yankee
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Users> us = new ArrayList<>();
        us.add(new Users("1234567890", "HL150504"));
        us.add(new Users("012346987", "H0346H01"));
        us.add(new Users("9876543210", "Tomtom14"));
        LogInSystem logIn = new LogInSystem();

        displayMenu();
        int choice;
        while (true) {            
            choice = inputInt("=> Your choice: ");
            if (choice != 1 && choice != 2 && choice != 3) {
                System.err.println("You must choose from 1 to 3! Re-enter.");
            } else {
                break;
            }
        }
        
        if (choice == 1 || choice == 2) {
            logIn.changeLanguage(choice);
            logIn.logIn(us);
        }
    }

    public static void displayMenu() {
        System.out.println("***Welcom to ebank***");
        System.out.println("1. Vietnamese\n"
                + "2. English\n"
                + "3. Exit");
    }

    public static int inputInt(String p) {
        Scanner in = new Scanner(System.in);
        String tmp;
        int i = 0;

        do {
            System.out.print(p);
            try {
                tmp = in.nextLine();
                if (Integer.parseInt(tmp) == Integer.parseInt(tmp)) {
                    i = Integer.parseInt(tmp);
                }
                break;
            } catch (NumberFormatException e) {
                System.err.print("You must be enter interger number, enter again.\n");
            }
        } while (true);
        return i;
    }

}
