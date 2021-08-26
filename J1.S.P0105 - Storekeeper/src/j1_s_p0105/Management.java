package j1_s_p0105;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Yankee
 */
public class Management {

    private ArrayList<Product> listProDuct;
    private ArrayList<Storekeeper> storeList;

    public Management(ArrayList<Product> listProduct, ArrayList<Storekeeper> storeList) {
        this.listProDuct = listProduct;
        this.storeList = storeList;
    }

    public boolean addStorekeeper(Storekeeper s) {
            storeList.add(s);
        return true;
    }

    public boolean idStoreExist(int id) {
        for (Storekeeper storekeeper1 : storeList) {
            if (storekeeper1.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public boolean listStoreIsEmpty() {
        return storeList.isEmpty();
    }

    public boolean listProIsEmpty() {
        return listProDuct.isEmpty();
    }

    public boolean addProduct(Product d) {
        listProDuct.add(d);
        return true;
    }

    public String update(Product p) {
        for (int i = 0; i < listProDuct.size(); i++) {
            if (listProDuct.get(i).getId() == p.getId()) {
                listProDuct.set(i, p);
                return "____UPDATING SUCCESSFUL____";
            }
        }
        return "Fail";
    }

        public ArrayList<Product> searchProductBySth(String searchValue) {
        ArrayList<Product> searched = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        for (Product p : listProDuct) {
            if (p.getName().toLowerCase().contains(searchValue.toLowerCase())
                    || p.getCategory().toLowerCase().contains(searchValue.toLowerCase())
                    || p.getStorekeeper().getName().toLowerCase().contains(searchValue.toLowerCase())
                    || sdf.format(p.getReceiptDate()).contains(searchValue)) {
                searched.add(p);
            }
        }
        return searched;
    }
    public void Sort(String s) {
        if (s.equalsIgnoreCase("E")) {
            Collections.sort(listProDuct, new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    return o1.getExpiryDate().compareTo(o2.getExpiryDate());
                }
            });
            displayProList();
        } else {
            Collections.sort(listProDuct, new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    return o1.getDateOfManufacture().compareTo(o2.getDateOfManufacture());
                }
            });
            displayProList();
        }
    }

    public boolean idProductExits(int id) {
        for (Product product : listProDuct) {
            if (product.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public Product findProductByID(int id) {
        for (Product product : listProDuct) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public boolean findProByName(String name) {
        for (Product product : listProDuct) {
            if (product.getName().contains(name)) {
                return true;
            }
        }
        return false;
    }

    public Storekeeper findStorekeeper(String name) {
        for (Storekeeper storekeeper : storeList) {
            if (storekeeper.getName().equalsIgnoreCase(name)) {
                return storekeeper;
            }
        }
        return null;
    }

    public void displayStoreList() {
        System.out.println("**List Storekeepers**");
        System.out.printf("%-4s |   %-15s\n", "ID", "Storekeeper name");
        for (Storekeeper storekeeper : storeList) {
            System.out.printf("%-4d |   %-15s\n", storekeeper.getId(), storekeeper.getName());
        }
    }

    public void displayAProduct(Product product) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.printf("%5s %15s %10s %10s %15s %25s %15s %15s %15s\n",
                product.getId(), product.getName(), product.getLocation(), product.getPrice(),
                sdf.format(product.getExpiryDate()), sdf.format(product.getDateOfManufacture()), product.getCategory(),
                product.getStorekeeper().getName(), sdf.format(product.getReceiptDate()));
    }

    public void displayProList() {
        Header();
        for (Product product : listProDuct) {
            displayAProduct(product);
        }
    }

    public void Header() {
        System.out.printf("%5s %15s %10s %10s %15s %25s %15s %15s %15s\n", "ID", "Name product",
                "Location", "Price", "Expiry date", "Date of manufacture",
                "Category", "Storekeeper", "Receipt date");
    }

    public void displayProById(int id) {
        for (Product product : listProDuct) {
            if (product.getId() == id) {
                displayAProduct(product);
                break;
            }
        }
    }

}
