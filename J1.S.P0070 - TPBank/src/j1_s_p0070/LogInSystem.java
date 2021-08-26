/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1_s_p0070;

import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 *
 * @author Yankee
 */
public class LogInSystem {

    Locale locale;
    ResourceBundle rb;
    Ebank in = new Ebank(rb);

    public LogInSystem() {
    }

    public void logIn(ArrayList<Users> user) {

        boolean checkUser = checkUsers(user);
        boolean check = inputCaptcha();

        while (!check) {
            check = inputCaptcha();
        }
        if (checkUser) {
            System.err.println(rb.getString("loginSuccess"));
        } else {
            System.err.println(rb.getString("incorrectInput"));
            System.out.println("\n");
            logIn(user);
        }
    }

    String inputAcc() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(rb.getString("enterAcc"));
            String acc = sc.nextLine();
            if (in.checkAccount(acc).equals("True")) {
                return acc;
            } else {
                System.err.println(in.checkAccount(acc));
            }
        }
    }

    String inputPass() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(rb.getString("enterPassword"));
            String pass = sc.nextLine();
            if (in.checkPassword(pass).equals("True")) {
                return pass;
            } else {
                System.err.println(in.checkPassword(pass));
            }
        }
    }

    boolean inputCaptcha() {
        Scanner sc = new Scanner(System.in);
        String captCha = in.createCaptcha();
        System.out.println("Captcha: " + captCha);
        System.out.print(rb.getString("enterCaptcha"));
        String enCaptcha = sc.nextLine();
        if (in.checkCaptcha(enCaptcha, captCha).equals("True")) {
            return true;
        } else {
            System.err.println(in.checkCaptcha(enCaptcha, captCha));
        }
        return false;
    }

    public boolean checkUsers(ArrayList<Users> users) {
        String acc = inputAcc();
        String pass = inputPass();
        for (Users user : users) {
            if (acc.equals(user.getUserName()) && user.getPassWord().equals(pass)) {
                return true;
            }
        }
        return false;
    }

    public int inputInt(String p) {
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

    public void changeLanguage(int choice) {
        switch (choice) {
            case 1:
                locale = new Locale("vi");
                in.setLocal(locale);
                this.rb = ResourceBundle.getBundle("Language/" + locale);
                break;
            case 2:
                locale = new Locale("en");
                in.setLocal(locale);
                this.rb = ResourceBundle.getBundle("Language/" + locale);
                break;
            case 3:
                System.exit(0);
        }
    }

}
