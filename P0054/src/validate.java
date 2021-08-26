
import java.util.Scanner;
/**
 *
 * @author Yankee
 */
public class validate {

    Scanner sc = new Scanner(System.in);

    public int choice(String mess, String err, int min, int max) {
        int choose = 0;
        while (true) {
            System.out.print(mess);
            try {
                choose = Integer.parseInt(sc.nextLine());
                if (choose < min || choose > max) {
                    System.err.println("Enter " + min + " - " + max + ": ");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println(err);
            }
        }
        return choose;

    }
public int number(String mess){
    System.out.print(mess);
    int num;
    while (true) {        
        try {
            num = Integer.parseInt(sc.nextLine());
            break;
            
            
        } catch (Exception e) {
            System.out.println("Number don't letter.");
        }
    }
        return num;
    
}
    public String getString(String mess) {
        String str = "";
        System.out.print(mess);
        while (true) {
            try {
                str = sc.nextLine();
                str = str.replaceAll("\\s+", " ").trim();
                if (str.isEmpty()) {
                    System.out.println("Don't empty");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.err.println("Enter letter don't number!!");
            }
        }
        return str;

    }

    public String getPhone(String mess) {
        String phone = "";
        while (true) {
            System.out.print(mess);
            phone = sc.nextLine();
            String phone1 = "0[1-9]{8,10}";
            String phone2 = "[1-9]{3}-[1-9]{3}-[1-9]{4}";
            String phone3 = "[1-9]{3}-[1-9]{3}-[1-9]{4} x[1-9]{4}";
            String phone4 = "[1-9]{3}-[1-9]{3}-[1-9]{4} ext[1-9]{4}";
            String phone5 = "\\([1-9]{3}\\)-[1-9]{3}-[1-9]{4}";
            String phone6 = "[1-9]{3} [1-9]{3} [1-9]{4}";
            String phone7 = "[1-9]{3}.[1-9]{3}.[1-9]{4}";
            if (phone.matches(phone1) || phone.matches(phone2) || phone.matches(phone3)
                    || phone.matches(phone4) || phone.matches(phone5) || phone.matches(phone6) || phone.matches(phone7)) {
                return phone;
            } else {
                System.err.println("Phone don't right format.");
            }

        }
    }

    public String getYN(String mess) {
        System.out.println(mess);
        String yn = "";
        while (true) {
            yn = sc.nextLine();
            if (yn.trim().matches("[YyNn]")) {
                break;
            } else {
                System.out.println("You must enter Y/N.");
            }
        }
        return yn;
    }


}
