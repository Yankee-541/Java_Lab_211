
package j1_s_p0105;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Yankee
 */
public class Viewer {

    Management mn;

    public Viewer(Management mn) {
        this.mn = mn;
    }

    public void CreateStorekeeper() {
        String name;
        int id = 0;
        while (true) {
            id++;
            if (mn.idStoreExist(id)) {
                continue;
            }
            System.out.println("ID: " + id);
            name = Validation.inputName("Storekeeper name: ");
            Storekeeper a = new Storekeeper(id, name);
            mn.addStorekeeper(a);
            System.out.println("Add storekeeper successful.");

            if (!Validation.checkYesNo("Do you want to add more storekeeper? (Y/N)\n=> Your choice: ")) {
                mn.displayStoreList();
                System.out.println("");
                break;
            }
        }
    }

    public void createProduct() {
        int id;
        String Name;
        String Location;
        double Price;
        Date ExpiryDate;
        Date DateOfManufacture;
        String Category;
        Storekeeper s = new Storekeeper();
        Date ReceiptDate;

        if (mn.listStoreIsEmpty()) {
            System.err.println("You must add storekeepers first!");
            return;
        }

        while (true) {
            id = Validation.inputInt("Product ID: ");
            if (mn.idProductExits(id)) {
                System.out.println("This product existed! Enter another product.");
                continue;
            }
            Name = Validation.inputNameProduct("Product name: ");
            Location = Validation.inputNameProduct("Location: ");
            while (true) {
                Price = Validation.inputDouble("Price: ");
                if (Price <= 0) {
                    System.err.println("Price must be bigger than 0! Re-enter.");
                } else {
                    break;
                }
            }
            ExpiryDate = Validation.inputDate("Expiry date: ", "dd/MM/yyyy");
            while (true) {
                DateOfManufacture = Validation.inputDate("Date of manufacture: ", "dd/MM/yyyy");
                if (DateOfManufacture.after(ExpiryDate)) {
                    System.err.println("Date of manufacture mustn't bigger than expiry date! Re-enter.");
                } else {
                    break;
                }
            }

            Category = Validation.inputString("Category: ");
            System.out.println("Choose storekeeper:");
            mn.displayStoreList();
            while (true) {
                String storekeeperName;
                storekeeperName = Validation.inputName("Storekeeper name: ");
                if (mn.findStorekeeper(storekeeperName) != null) {
                    s = new Storekeeper(mn.findStorekeeper(storekeeperName).getId(),
                            mn.findStorekeeper(storekeeperName).getName());
                    break;
                } else {
                    System.err.println("Not found storekeeper! Choose another storekeeper.");
                }
            }

            while (true) {
                ReceiptDate = Validation.inputDate("Recipt date: ", "dd/MM/yyyy");
                if (DateOfManufacture.before(ReceiptDate)
                        && ReceiptDate.before(ExpiryDate)) {
                    break;
                } else {
                    System.err.println("Recipt date must bigger than date of manufacture "
                            + "and smaller than expiry date! Re-enter.");
                }
            }
            Product p = new Product(id, Name, Location, Price, ExpiryDate,
                    DateOfManufacture, Category, s, ReceiptDate);
            mn.addProduct(p);

            if (!Validation.checkYesNo("Do you wan to add more products? (Yes/No)\n=> Your choice: ")) {
                System.out.println("__ADDING PRODUCT SUCCESSFUL___");
                mn.displayProList();
                System.out.println("");
                break;
            }
        }
    }

    public Product updateAProduct(Product p) {
        System.err.println("Before update:");
        mn.Header();
        mn.displayProById(p.getId());
        String Name;
        String Location;
        double Price;
        Date ExpiryDate;
        Date DateOfManufacture;
        String Category;
        Storekeeper s = null;
        Date ReceiptDate;
        if (Validation.checkYesNo("You want to update product name? (Y/N): ")) { // update product name
            Name = Validation.inputNameProduct("New product name: ");
            p.setName(Name);
        }
         if (Validation.checkYesNo("You want to update location? (Y/N): ")) { // update location
            Location = Validation.inputNameProduct("New location: ");
            p.setLocation(Location);
        }
        if (Validation.checkYesNo("You want to update price? (Y/N): ")) {
            while (true) {
                Price = Validation.inputDouble("New price: ");
                if (Price > 0) {
                    p.setPrice(Price);
                    break;
                } else {
                    System.err.println("Price must be bigger than 0! Re-enter.");
                }
            }
        }
        if (Validation.checkYesNo("You want to update expriry date? (Y/N): ")) {
            ExpiryDate = Validation.inputDate("New expiry date: ", "dd/MM/yyyy");
            p.setExpiryDate(ExpiryDate);
        }
        if (Validation.checkYesNo("You want to update date of manufacture? (Y/N): ")) {
            while (true) {
                DateOfManufacture = Validation.inputDate("New Date of manufacture: ", "dd/MM/yyyy");
                if (DateOfManufacture.after(p.getExpiryDate())) {
                    System.err.println("Date of manufacture mustn't bigger than expiry date! Re-enter.");
                } else {
                    break;
                }
            }
            p.setDateOfManufacture(DateOfManufacture);
        }
        if (Validation.checkYesNo("You want to update category? (Y/N): ")) {
            Category = Validation.inputString("New Category: ");
            p.setCategory(Category);
        }
        if (Validation.checkYesNo("You want to update storekeeper? (Y/N): ")) {
            System.out.println("Choose new storekeeper:");
            mn.displayStoreList();
            while (true) {
                String storekeeperName;
                storekeeperName = Validation.inputName("Storekeeper name: ");
                if (mn.findStorekeeper(storekeeperName) != null) {
                    s = new Storekeeper(mn.findStorekeeper(storekeeperName).getId(), mn.findStorekeeper(storekeeperName).getName());
                    break;
                } else {
                    System.err.println("Not found storekeeper! Choose another storekeeper.");
                }
            }
            p.setStorekeeper(s);
        }
        if (Validation.checkYesNo("You want to update receipt date? (Y/N): ")) {
            while (true) {
                ReceiptDate = Validation.inputDate("New recipt date: ", "dd/MM/yyyy");
                if (p.getDateOfManufacture().before(ReceiptDate)
                        && ReceiptDate.before(p.getExpiryDate())) {
                    break;
                } else {
                    System.err.println("Recipt date must bigger than expiry date "
                            + "and smaller than date of manufacture! Re-enter.");
                }
            }
            p.setReceiptDate(ReceiptDate);
        }
        return p;
    }

    public void updateProduct() {
        if (mn.listProIsEmpty()) {
            System.err.println("You must add products before excuting uppdate!");
            return;
        }
        while (true) {
            int id = Validation.inputInt("Enter product ID you want to update: ");
            Product p = null;
            if (mn.findProductByID(id) == null) {
                System.err.println("=> Not fount product with ID: " + id);
            } else {
                p = new Product(mn.findProductByID(id).getId(), mn.findProductByID(id).getName(), mn.findProductByID(id).getLocation(),
                        mn.findProductByID(id).getPrice(), mn.findProductByID(id).getExpiryDate(), mn.findProductByID(id).getDateOfManufacture(),
                        mn.findProductByID(id).getCategory(), mn.findProductByID(id).getStorekeeper(), mn.findProductByID(id).getReceiptDate());

                System.err.println(mn.update(updateAProduct(p)));
                System.err.println("After update: ");
                mn.Header();
                mn.displayProById(p.getId());
            }

            if (!Validation.checkYesNo("Do you want to update another product?"
                    + " Choose Yes(Y) to update continue, No(N) to return main screen.\n=>Your choice: ")) {
                System.out.println("");
                break;
            }
        }
    }

    public void searchProduct() {
        if (mn.listStoreIsEmpty()) {
            System.out.println("You must add storekeeper before excuting search product!");
            System.out.println("");
            return;
        }
        if (mn.listProIsEmpty()) {
            System.out.println("You must add products before excuting search product!");
            System.out.println("");
            return;
        }
        Validation in = new Validation();
        while (true) {
            String searchValue = in.inputString("Enter search keywords: ");
            List<Product> searched = mn.searchProductBySth(searchValue);
            if (searched.isEmpty()) {
                System.out.println("There are no product match with "
                        + "\"" + searchValue + "\"");
                return;
            }
            System.out.println("");
            System.out.println("LIST OF PRODUCTS FOUND");
            System.out.printf("%5s %10s %10s %10s %15s %25s %15s %15s %15s\n", "ID", "Name",
                    "Location", "Price", "Expiry date", "Date of manufacture",
                    "Category", "Storekeeper", "Receipt date");
            for (Product p : searched) {
                mn.displayAProduct(p);
            }
            System.out.println("");
            if (!in.checkYesNo("Press \"Y\" if you want to keep taking action," + " press \"N\" if you want to end the action.")) {
                break;
            } else {
                continue;
            }
        }
        System.out.println("");
    }

    public void Sort() {
        if (mn.listProIsEmpty()) {
            System.err.println("You must add products before excuting sort product!");
            return;
        }
        while (true) {
            String s = Validation.inputString("You want to sort product by Expiry date (E), Date of manufacture (D): ");
            if (s.equalsIgnoreCase("E")) {
                System.out.println("\t\t\tSORTING SUCCESSFUL\nAfter sortting:");
                mn.Sort(s);
            } else if (s.equalsIgnoreCase("D")) {
                System.out.println("\t\t\tSORTING SUCCESSFUL\nAfter sortting:");
                mn.Sort(s);
            } else {
                System.err.println("You must choose (E) or (D)! Enter again.");
                continue;
            }
            if (!Validation.checkYesNo("Do you want to sort continue? (Y/N): ")) {
                System.out.println("");
                break;
            }
        }
    }
}
