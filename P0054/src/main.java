
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Yankee
 */

public class main {

    public static void main(String[] args) {
        validate v = new validate();
        List<Contact> list = new ArrayList<>();
        Managerment m = new Managerment(list);
        viewer view = new viewer(m);
        m.data();
        while (true) {
            m.menu();
            int choice = v.choice("Enter you choice: ", "Enter number don't letter", 1, 4);
            switch (choice){
                case 1:
                    view.add();
                    break;
                case 2:
                    view.display();
                    break;
                case 3:
                    view.delete();
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
                System.out.println("\n--------------------------");
                               
            }

        }

    }
