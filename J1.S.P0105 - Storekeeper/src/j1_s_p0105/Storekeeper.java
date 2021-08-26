package j1_s_p0105;
/**
 *
 * @author Yankee
 */
public class Storekeeper {

    private String name;
    private int id;

    public Storekeeper() {
    }

    public Storekeeper(int id, String name) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    
}
