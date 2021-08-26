package j1_s_p0105;

import java.util.Date;
/**
 *
 * @author Yankee
 */
public class Product {

    private int Id;
    private String Name;
    private String Location;
    private double Price;
    private Date ExpiryDate;
    private Date DateOfManufacture;
    private String Category;
    private Storekeeper Storekeeper;
    private Date ReceiptDate;

    public Product() {
    }

    public Product(int Id, String Name, String Location, double Price, Date ExpiryDate, Date DateOfManufacture,
            String Category, Storekeeper Storekeeper, Date ReceiptDate) {
        this.Id = Id;
        this.Name = Name;
        this.Location = Location;
        this.Price = Price;
        this.ExpiryDate = ExpiryDate;
        this.DateOfManufacture = DateOfManufacture;
        this.Category = Category;
        this.Storekeeper = Storekeeper;
        this.ReceiptDate = ReceiptDate;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public String getLocation() {
        return Location;
    }

    public double getPrice() {
        return Price;
    }

    public Date getExpiryDate() {
        return ExpiryDate;
    }

    public Date getDateOfManufacture() {
        return DateOfManufacture;
    }

    public String getCategory() {
        return Category;
    }

    public Storekeeper getStorekeeper() {
        return Storekeeper;
    }

    public Date getReceiptDate() {
        return ReceiptDate;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public void setExpiryDate(Date ExpiryDate) {
        this.ExpiryDate = ExpiryDate;
    }

    public void setDateOfManufacture(Date DateOfManufacture) {
        this.DateOfManufacture = DateOfManufacture;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public void setStorekeeper(Storekeeper Storekeeper) {
        this.Storekeeper = Storekeeper;
    }

    public void setReceiptDate(Date ReceiptDate) {
        this.ReceiptDate = ReceiptDate;
    }

}
