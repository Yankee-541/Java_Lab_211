
package j1_s_p0105;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * https://docs.google.com/document/d/1WU6UuevYX6wD3QxwUQ45-nKbjKavnmQf/edit
 *
 * @author Yankee
 */
public class Main {
    public static void main(String[] args) throws ParseException {
        ArrayList<Storekeeper> storeList = new ArrayList<>();
        storeList.add(new Storekeeper(1, "Tom"));
        storeList.add(new Storekeeper(2, "Ca"));
        storeList.add(new Storekeeper(3, "Lon"));
        storeList.add(new Storekeeper(4, "Ga"));

        ArrayList<Product> productsList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        productsList.add(new Product(100, "p1", "l1", 123, sdf.parse("20/02/2021"), sdf.parse("20/02/2019"), "drink", new Storekeeper(1, "Tom"), sdf.parse("20/06/2019")));
        productsList.add(new Product(101, "p2", "l2", 123, sdf.parse("19/02/2020"), sdf.parse("02/02/2019"), "juice", new Storekeeper(2, "Lon"), sdf.parse("19/01/2029")));
        productsList.add(new Product(102, "p3", "l3", 123, sdf.parse("19/02/2021"), sdf.parse("04/02/2019"), "cafe", new Storekeeper(3, "Ga"), sdf.parse("13/12/2019")));
        productsList.add(new Product(103, "p4", "l4", 123, sdf.parse("17/02/2020"), sdf.parse("06/02/2019"), "fruit", new Storekeeper(4, "Ca"), sdf.parse("20/06/2019")));
        Management manage = new Management(productsList, storeList);
        Viewer vw = new Viewer(manage);

        while (true) {
            displayMenu();
            int option = Validation.inputInt("Your choice: ");
            switch (option) {
                case 0:
                    System.exit(0);
                case 1:
                    vw.CreateStorekeeper();
                    break;
                case 2:
                    vw.createProduct();
                    break;
                case 3:
                    vw.updateProduct();
                    break;
                case 4:
                    vw.searchProduct();
                    break;
                case 5:
                    vw.Sort();
                    break;
                case 6:
                    manage.displayProList();
                    break;
                default:
                    System.err.println("You must choose from 0 to 6.");
            }
        }
    }
    
    public static void displayMenu() {
        System.out.println("========MAIN MENU=======");
        System.out.println("1. Add Storekeeper.");
        System.out.println("2. Add product.");
        System.out.println("3. Update product.");
        System.out.println("4. Search product by Name, Category, Storekeeper, ReceiptDate.");
        System.out.println("5. Sort product by Expiry date, Date of manufacture.");
//        System.out.println("6: Display.");
        System.out.println("0. Exit.");
    }

}
