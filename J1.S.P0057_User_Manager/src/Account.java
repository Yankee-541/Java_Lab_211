import java.io.Serializable;


public class Account implements Serializable{ //convert string từ dữ liệu từ file dat  sang byte
    private String user;
    private String pass;

    public Account() {
    }

    public Account(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return user +"|"+pass;
    }
    
}
