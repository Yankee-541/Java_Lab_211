
import java.util.ArrayList;
import java.util.List;
//https://docs.google.com/document/d/1gjxSBIHQpitj_2uny0wTayqVERXhDWqR/edit
/**
 *
 * @author Yankee
 */
public class Main {
    public static void main(String[] args) throws Exception {
        List<Task> taskList = new ArrayList<>();
        Manager m = new Manager(taskList);
        Viewer view = new Viewer(m);
        m.data();
        while (true) {
            view.menu();
            int choice = m.getChoice("Enter your choice: ", 1, 4,"Pls enter 1-4: ");
            switch (choice) {
                case 1:
                    view.addTask();
                    break;
                case 2:
                    view.delete();
                    break;
                case 3:
                    view.display();
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }
    }
}
