/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0101.employees;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Yankee
 */
public class Validation {

    public static Scanner in = new Scanner(System.in);

    /**
     * Check if input is String or not
     *
     * @param message
     * @return
     */
    public static String inputString(String p) {
        String s = "";
        System.out.print(p);
        do {
            s = in.nextLine();
            if (!s.isEmpty()) {
                break;
            } else {
                System.out.print("\nCan't be left blank, enter again.\n" + p);
            }
        } while (true);
        return s;
    }

    /**
     * Check if input is int or not
     *
     * @param message
     * @return
     */
    public static int inputInt(String p) {
        String tmp;
        int i = 0;
        System.out.print(p);
        do {
            try {
                tmp = in.nextLine();
                if (Integer.parseInt(tmp) == Integer.parseInt(tmp)) {
                    i = Integer.parseInt(tmp);
                }
                break;
            } catch (Exception e) {
                System.out.print("Your must be enter number, enter again.\n" + p);
            }
        } while (true);
        return i;
    }

    /**
     * Check if input is double or not
     *
     * @param message
     * @return
     */
    public static double inputDouble(String p) {
        String tmp;
        double d = 0;
        System.out.print(p);
        do {
            try {
                tmp = in.nextLine();
                if (Double.parseDouble(tmp) == Double.parseDouble(tmp)) {
                    d = Double.parseDouble(tmp);
                }
                break;
            } catch (Exception e) {
                System.out.print("Invalid input, enter again.\n" + p);
            }
        } while (true);
        return d;
    }

    /**
     * Check if input is boolean or not
     *
     * @param message
     * @return
     */
    public static boolean inputBoolean(String p) {
        String tmp;
        boolean b = true;
        System.out.print(p);
        do {
            try {
                tmp = in.nextLine();
                if (Boolean.parseBoolean(tmp) == Boolean.parseBoolean(tmp)) {
                    b = Boolean.parseBoolean(tmp);
                }
                break;
            } catch (Exception e) {
                System.out.print("Invalid input, enter again.\n" + p);
            }
        } while (true);
        return b;
    }

    /**
     * Check if input is char or not
     *
     * @param p
     * @param message
     * @return
     */
    public static char inputChar(String p) {
        System.out.print(p);
        String c;
        while (true) {
            c = in.nextLine();
            if (c.length() == 1) {
                return c.charAt(0);
            } else {
                System.out.print("Invalid input, enter again: ");
            }
        }
    }

    /**
     * Check if input date is valid or not
     *
     * @param message
     * @param format date
     * @return
     */
    public static Date inputDate(String p, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date date = new Date();
        String tmp;
        while (true) {
            try {
                System.out.print(p);
                tmp = in.nextLine();
                if (!tmp.isEmpty()) {
                    date = sdf.parse(tmp);
                    if (tmp.equals(sdf.format(date))) {
                        return date;
                    } else {
                        System.err.println("Please enter a right date, enter again.");
                    }
                } else {
                    System.err.println("Not empty! Re-enter.");
                }
            } catch (Exception e) {
                System.err.println("Format must be " + pattern + " ! Enter again.");
            }
        }
    }

    /**
     * Check if input String is letterString or not
     *
     * @param message
     * @return
     */
    public static boolean isLetter(String p) {
        boolean check = true;
        for (int i = 0; i < p.length(); i++) {
            if (!Character.isLetter(p.charAt(i))) {
                check = false;
            }
        }
        return check;
    }

    public static boolean isDigit(String p) {
        boolean check = true;
        for (int i = 0; i < p.length(); i++) {
            if (!Character.isDigit(p.charAt(i))) {
                check = false;
            }
        }
        return check;
    }

    public static boolean isAlphanumeric(String p) {

        boolean check = true;
        for (int i = 0; i < p.length(); i++) {
            if (!Character.isDigit(p.charAt(i)) && !Character.isLetter(p.charAt(i))) {
                check = false;
            }
        }
        return check;
    }

    public static String SexValue(String p) {
        String str = "";
        while (true) {
            System.out.print(p);
            str = in.nextLine();
            if (str.equalsIgnoreCase("male") || str.equalsIgnoreCase("female")) {
                return str;
            } else {
                System.err.println("Sex must be Male or Female! Re-enter!");
            }
        }
    }

    public static boolean checkYesNo(String tmp) {
        System.out.print(tmp);

        while (true) {
            String s = in.nextLine();
            s = s.replaceAll(" ", "");
            if (s.compareToIgnoreCase("yes") == 0 || s.compareToIgnoreCase("y") == 0) {
                return true;
            }
            if (s.compareToIgnoreCase("no") == 0 || s.compareToIgnoreCase("n") == 0) {
                return false;
            }
            System.out.print("You mustt choose Yes(Y) or No(N)!\n" + tmp);
        }
    }

    public static String inputName(String s) {

        String name = "";
        String str = "";
        do {
            System.out.print(s);
            name = in.nextLine();
            if (name.isEmpty()) {
                System.out.println("You must enter your name! Re-enter.");
            } else {
                if (isLetter(name) || name.contains(" ")) {
                    name = name.replaceAll("\\s+", " ").trim();
                    str = str + Character.toUpperCase(name.charAt(0));
                    for (int i = 1; i < name.length(); i++) {
                        if (name.charAt(i) == ' ') {
                            str = str + name.charAt(i) + Character.toUpperCase(name.charAt(i + 1));
                            i++;
                        } else {
                            str = str + Character.toLowerCase(name.charAt(i));
                        }
                    }
                    break;
                } else {
                    System.out.println("Name cannot contain special characters! Re-enter.");
                }
            }
        } while (true);
        return str;
    }

    public static String inputEmail(String s) {
        // loop until have valid name were inputted
        while (true) {
            System.out.print(s);
            String string = in.nextLine().trim();
            string = string.replace("\\s+", " ");
            Pattern p = Pattern.compile("^[a-z0-9A-Z]+@[a-zA-Z]+(\\.[a-zA-Z]+){1,3}+$");
            if (!string.isEmpty()) { // not empty ~> finish
                if (p.matcher(string).find()) {
                    return string;
                } else {
                    System.err.println("Email must in format "
                            + "Local-Part(name(.name2)@Domain(domain.something(.domain2.domain3))(max 3 '.'), enter again!");
                }
            } else { // empty string ~> display error & re-enter
                System.err.println("Email can not empty, enter again!");
            }
        }
    }

    public static int ageValid(Date day) {
        Calendar c = Calendar.getInstance();
        c.setTime(day);
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int date = c.get(Calendar.DATE);
        LocalDate dob = LocalDate.of(year, month, date);
        LocalDate now = LocalDate.now();
        Period age = Period.between(dob, now);
        return age.getYears();
    }

}
