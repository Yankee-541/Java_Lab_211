
import java.util.Scanner;
/**
 *
 * @author Yankee
 */
public class Validation {

    Scanner sc = new Scanner(System.in);

    public String getString(String mess) {
        String txt = "";
        while (true) {
            System.out.print(mess);
            txt = sc.nextLine();
            if (txt.trim().isEmpty()) {
                System.out.println("String is empty, please input again");
            } else {
                break;
            }
        }
        return txt;
    }

    public String getName(String mess) {
        System.out.println(mess);
        String txt = sc.nextLine();
        return txt;
    }

    public int getNumber(String mess) {
        int number = 0;
        while (true) {
            try {
                System.out.print(mess);
                number = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Invalid number, please input again");
            }
        }
        return number;
    }
}
