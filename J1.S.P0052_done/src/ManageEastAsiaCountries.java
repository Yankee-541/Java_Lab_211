
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author Yankee
 */
public class ManageEastAsiaCountries {

    public void menu() {
        System.out.println("1. Enter the information for 11 countries in Southeast Asia.");
        System.out.println("2. Display already information.");
        System.out.println("3. Search the country according to the entered country's name.");
        System.out.println("4. Display the information increasing with the country name.");
        System.out.println("5. Exit.");
    }

    //input choice
    public int getChoice(String mess) {
        int choice = 0;
        System.out.print(mess);
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                choice = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.print("Invalid choice, please re-input choice: ");
            }
        }
        return choice;
    }
//validate string 

    public String getText(String mess) {
        String txt = "";
        System.out.print(mess);
        while (true) {
            Scanner sc = new Scanner(System.in);
            txt = sc.nextLine();
            txt = txt.replaceAll("\\s+", " ").trim();
            if (txt.isEmpty()) {
                System.out.print("Can not null, re-input: ");
            } else {
                break;
            }
        }
        return txt;
    }

//validate area country
    public float getArea(String mess) {
        float area = 0;
        System.out.print(mess);
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                area = Float.parseFloat(sc.nextLine());
                if (area < 1) {
                    System.out.print("Invalid area, please re-input area: ");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.err.print("Invalid area, please re-input area: ");
            }
        }
        return area;
    }

//3: Search information of countries by user-entered name 
    public void search(List<EastAsiaCountries> list, String txt) {
        int count = 0;
        for (EastAsiaCountries o : list) {
            if (o.getCountryName().toLowerCase().contains(txt.toLowerCase())) {
                count++;
                System.out.println("ID\t\tName\t\tTotal Area\t\tTerrain");
                o.display();
                break;
            }
        }
        if (count == 0) {
            System.out.println("Not found");
        }
    }

    //4: ham sort va printf inform country
    public void printList(List<EastAsiaCountries> list) {
        Collections.sort(list, new Comparator<EastAsiaCountries>() {
            @Override
            public int compare(EastAsiaCountries o1, EastAsiaCountries o2) {
                return o1.getCountryName().compareToIgnoreCase(o2.getCountryName());
            }
        });

        System.out.println("ID\t\tName\t\tTotal Area\t\tTerrain");
        for (EastAsiaCountries o : list) {
            o.display();
        }
    }

//check code country
    public int checkExits(List<EastAsiaCountries> list, String code) {
        for (EastAsiaCountries o : list) {
            if (o.getCountryCode().toLowerCase().equals(code.toLowerCase())) {
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        ManageEastAsiaCountries m = new ManageEastAsiaCountries();
        EastAsiaCountries east = null;
        List<EastAsiaCountries> list = new ArrayList<>();
        m.menu();
        while (true) {
            System.out.println("----------------------------------------");
            int choice = m.getChoice("Input your choice: ");
            switch (choice) {
                case 1:
                    String code;
                    while (true) {
                        System.out.println("----------------------------------------");
                        code = m.getText("Enter code of country: ");
                        if (m.checkExits(list, code) == 0) {
                            break;
                        } else {
                            System.err.println("Code is exits, re-input again.");
                        }
                    }
                    String name = m.getText("Enter name of country: ");
                    float area = m.getArea("Enter total area: ");
                    String terrain = m.getText("Enter terrain of country: ");
                    east = new EastAsiaCountries(terrain, code, name, area);
                    list.add(east);
                    break;
                case 2:
                    System.out.println("----------------------------------------");
                    east.display();
                    break;
                case 3:
                    System.out.println("----------------------------------------");
                    String txt = m.getText("Enter the name you want to search for: ");
                    m.search(list, txt);
                    break;
                case 4:
                    System.out.println("----------------------------------------");
                    m.printList(list);
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }
    }
}
