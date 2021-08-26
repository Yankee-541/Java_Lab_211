
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
/**
 *
 * @author Yankee
 */
public class Validation {

    Scanner sc = new Scanner(System.in);

    public String inputString(String mess) {
        String txt = "";
        System.out.print(mess);
        while (true) {
            txt = sc.nextLine();
            txt = txt.replaceAll("\\s+", " ").trim();
            if (txt.isEmpty()) {
                System.err.println("-Can not null, please input again.");
            } else {
                break;
            }
        }
        return upperCaseFirstChar(txt);
    }

    public String inputName(String mess) {
        String name;
        String str = "";
        do {
            System.out.print(mess);
            name = sc.nextLine();
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

    public String getTime(String p) {
        Pattern form = Pattern.compile("^\\d{1,2}\\.5|\\d{1,2}\\.0$");
        while (true) {
            String timePlan = inputString(p);
            if (form.matcher(timePlan).find() && Double.parseDouble(timePlan) >= 8.0
                    && Double.parseDouble(timePlan) <= 17.5) {
                return timePlan;
            } else {
                System.err.println("Time wrong (8h -> 17.30h). Input again!");
            }
        }
    }

    public String inputPlanFrom(String mess) {
        System.out.print(mess);
        while (true) {
            String planF = sc.nextLine().trim();
            planF = planF.replaceAll("\\s+", "");
            if (planF.isEmpty()) {
                System.out.print("Start can not empty, enter again: ");
            } else {
                Pattern p = Pattern.compile("^\\d{1,2}\\.5|\\d{1,2}\\.0$");
                if (p.matcher(planF).find()) {
                    try {
                        double time = Double.parseDouble(planF);
                        if (time >= 8 && time <= 17) {
                            return planF;
                        } else {
                            System.out.print("Start time must be 8 and 17, re-enter: ");
                        }
                    } catch (Exception e) {
                        System.out.print("invalid, re-enter: ");
                    }
                } else {
                    System.out.print("Invalid (format h.0 or h.5, re-enter):");
                }
            }

        }
    }

    public int inputInt(String p) {
        String tmp;
        int i = 0;
        do {
            System.out.print(p);
            try {
                tmp = sc.nextLine();
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
            } catch (Exception e) {
                System.err.print(err);
            }
        }
        return choice;
    }

    public double InputDouble(String mess, String error) {
        double salary = 0;
        while (true) {
            try {
                System.out.print(mess);
                salary = Double.parseDouble(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println(error);
            }
        }
        return salary;
    }

    public Date InputDate(String mess) {
        Date date = null;
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        df.setLenient(false);
        while (true) {
            try {
                System.out.print(mess);
                date = df.parse(sc.nextLine());
                break;
            } catch (ParseException e) {
                System.out.println("Invalid date. Pls re-enter.");
            }
        }
        return date;
    }

    public String getYN(String mess) {
        String txt = "";
        while (true) {
            System.out.print(mess);
            txt = sc.nextLine();
            if (txt.trim().matches("[ynYN]")) {
                break;
            } else {
                System.out.println("You must choose Yes(Y) or No(N)!");
            }
        }
        return txt;
    }

    private String upperCaseFirstChar(String stringInput) {
        if (stringInput.isEmpty()) {
            return null;
        }
        String[] strA = stringInput.replaceAll("\\s+", " ").trim().split(" ");
        if (stringInput.replaceAll(" ", "").isEmpty()) {
            return null;
        }
        String tmp = "";
        String result = "";
        for (String s : strA) {
            s = s.toLowerCase();
            if (s.length() == 1) {
                result = result + s.toUpperCase() + " ";
                continue;
            }
            tmp = s.substring(0, 1).toUpperCase() + s.substring(1) + " ";
            result += tmp;
        }
        return result.trim();
    }

    public String InputEmail(String mess) {
        while (true) {
            System.out.print(mess);
            String str = sc.nextLine().trim();
            str = str.replace("\\s+", " ");
            String p = "[a-z0-9A-Z]+@[a-zA-Z]+(\\.[a-zA-Z]+){1,3}+";
            if (!str.isEmpty()) {
                if (str.matches(p)) {
                    return str;
                } else {
                    System.err.println("Email must in format : ex: abc@gmail.com, pls enter again!");
                }
            } else { // empty string ~> display error & re-enter
                System.err.println("Email can not empty, enter again!");
            }
        }
    }

    public String InputGender(String mess) {
        String txt = "";
        while (true) {
            System.out.print(mess);
            txt = sc.nextLine();
            if (txt.trim().equalsIgnoreCase("Male") || txt.trim().equalsIgnoreCase("Female")) {
                break;
            } else {
                System.err.println("Male or female! Pls re-enter.");
            }
        }
        return upperCaseFirstChar(txt);
    }

    public boolean isLetter(String p) {
        boolean check = true;
        for (int i = 0; i < p.length(); i++) {
            if (!Character.isLetter(p.charAt(i))) {
                check = false;
            }
        }
        return check;
    }

    public String InputPhone(String mess, String error) {
        String txt = "";
        while (true) {
            System.out.print(mess);
            txt = sc.nextLine();
            //9-11 so
            //so dau tien phai la 0
            if (txt.trim().matches("0[1-9]{8,10}")) {
                break;
            } else {
                System.err.println(error);
            }
        }
        return txt;
    }

}
