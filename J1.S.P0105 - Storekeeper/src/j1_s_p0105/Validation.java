package j1_s_p0105;

import java.text.SimpleDateFormat;
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

        do {
            System.out.print(p);
            s = in.nextLine();
            if (!s.isEmpty()) {
                break;
            } else {
                System.err.print("\nCan't be left blank, enter again.\n");
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

        do {
            System.out.print(p);
            try {
                tmp = in.nextLine();
                if (Integer.parseInt(tmp) == Integer.parseInt(tmp)) {
                    i = Integer.parseInt(tmp);
                }
                break;
            } catch (Exception e) {
                System.err.print("You must be enter interger number, enter again.\n");
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

        do {
            System.out.print(p);
            try {
                tmp = in.nextLine();
                if (Double.parseDouble(tmp) == Double.parseDouble(tmp)) {
                    d = Double.parseDouble(tmp);
                }
                break;
            } catch (Exception e) {
                System.err.print("Invalid input, enter again.\n");
            }
        } while (true);
        return d;
    }

    /**
     * Check if input is boolean or not
     *
     * @param p
     * @param message
     * @return
     */
    public static boolean inputBoolean(String p) {
        String tmp;
        boolean b = true;

        do {
            try {
                System.out.print(p);
                tmp = in.nextLine();
                if (Boolean.parseBoolean(tmp.toLowerCase()) == Boolean.parseBoolean(tmp.toLowerCase())) {
                    b = Boolean.parseBoolean(tmp);
                }
                break;
            } catch (Exception e) {
                System.err.print("You must enter TRUE or FALSE! Re-enter.\n");
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
        String c;
        while (true) {
            System.out.print(p);
            c = in.nextLine();
            if (c.length() == 1) {
                return c.charAt(0);
            } else {
                System.err.print("Must enter character, enter again! ");
            }
        }
    }

    /**
     * Check if input date is valid or not
     *
     * @param p
     * @param pattern
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

    public static boolean SexValue(String p) {
        boolean check = true;
        if (p.compareToIgnoreCase("male") != 0 && p.compareToIgnoreCase("female") != 0) {
            check = false;
        }
        return check;
    }

    public static boolean checkYesNo(String tmp) {
        while (true) {
            System.out.print(tmp);
            String s = in.nextLine();
            s = s.replaceAll(" ", "");
            if (s.compareToIgnoreCase("yes") == 0 || s.compareToIgnoreCase("y") == 0) {
                return true;
            }
            if (s.compareToIgnoreCase("no") == 0 || s.compareToIgnoreCase("n") == 0) {
                return false;
            }
            System.err.print("You must choose Yes(Y) or No(N)!\n");
        }
    }

    public static String checkBin(String s) {

        boolean flag = true;
        String Bin = new String();
        while (true) {
            System.out.print(s);
            Bin = in.nextLine();
            if (Bin.isEmpty()) {
                System.err.print("=> Can't be left blank, enter again.\n\n");
                continue;
            }
            for (int i = 0; i < Bin.length(); i++) {
                if (Bin.charAt(i) < '0' || Bin.charAt(i) > '1') {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                flag = true;
                System.err.print("Number you entered isn't binary number! Re-enter.\n");
            } else {
                break;
            }
        }
        return Bin;
    }

    public static String checkHex(String s) {

        boolean flag = true;
        String hex = new String();
        while (true) {
            System.out.print(s);
            hex = in.nextLine();
            if (hex.isEmpty()) {
                System.err.print("=> Can't be left blank, enter again.\n\n");
                continue;
            }
            for (int i = 0; i < hex.length(); i++) {
                if ((hex.charAt(i) < '0' || hex.charAt(i) > '9')
                        && (hex.charAt(i) < 'A' || hex.charAt(i) > 'F')
                        && (hex.charAt(i) < 'a' || hex.charAt(i) > 'f')) {
                    flag = false;
                    break;
                }
            }

            if (!flag) {
                System.err.print("Number you entered isn't hexacimal number! Re-enter.\n");
            } else {
                flag = true;
                break;
            }
        }
        return hex;
    }

    public static String inputName(String s) {

        String name = "";
        String str = "";
        do {
            System.out.print(s);
            name = in.nextLine();
            if (name.isEmpty()) {
                System.err.println("You must enter your name! Re-enter.");
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
                    System.err.println("Name must be letter! Re-enter.");
                }
            }
        } while (true);
        return str;
    }
    
    public static String inputNameProduct(String s){
        String name = "";
        String str = "";
        do {
            System.out.print(s);
            name = in.nextLine();
            if (name.isEmpty()) {
                System.err.println("You must enter your name! Re-enter.");
            } else {
                if (isAlphanumeric(name) || name.contains(" ")) {
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
                    System.err.println("Product name invalid! Re-enter.");
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
}
