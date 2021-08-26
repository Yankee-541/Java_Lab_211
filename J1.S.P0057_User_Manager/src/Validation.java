
import java.util.Scanner;

public class Validation {

    Scanner sc = new Scanner(System.in);

    public String getString(String mess,String error, String regex) {
        String txt = "";
        while (true) {
            System.out.print(mess);
            txt = sc.nextLine();
            if (txt.matches(regex)) {
                break;
            }else{
                System.out.println(error);
            }
        }
        return txt;
    }

    public int getChoice(String mess, int min, int max) {
        int number = 0;
        while (true) {
            try {
                System.out.print(mess);
                number = Integer.parseInt(sc.nextLine());
                if (number < min || number > max) {
                    System.out.println("Choice within 1-5, please input again");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid number, please input again");
            }
        }
        return number;
    }
}
