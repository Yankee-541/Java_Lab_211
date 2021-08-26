
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UserManager {

    public void menu() {
        System.out.println("====== USER MANAGER SYSTEM ======");
        System.out.println("1. Create new account");
        System.out.println("2. Login system");
        System.out.println("3. Exit");
    }

    public int checkUsername(String username, String password) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("user.dat"));
            String line = "";
            while (true) {
                line = br.readLine();//doc tung dong
                if (line == null) {
                    break;
                }
                //check xem co chua   vd: admin|123456 ->admin là vị trí số 0 nên so sánh vs userName
                String txt[] = line.split("[|]");
                if (password.isEmpty()) {
                    if (txt[0].equals(username)) {
                        return 1;  //co roi
                    }
                } else {
                    if (txt[0].equals(username) && txt[1].equals(password)) {
                        return 1;  //co roi
                    }
                }
            }
        } catch (Exception e) {
        }

        return 0; //chua co
    }

    public void createAcc() {
        UserManager m = new UserManager();
        Validation v = new Validation();
        m.menu();
        String username = "";
        while (true) {
            username = v.getString("Enter UserName: ",
                    "You must enter least at 5 character, and no space",
                    "[a-zA-Z0-9]{5,}");//{5,} yêu cầu nhập 5 ký tự trở lên
            if (m.checkUsername(username, "") == 0) {
                break;
            } else {
                System.out.println("esist");
            }
        }
        String password = v.getString("Enter password: ",
                "You must enter least at 6 character, and no space",
                "[a-zA-Z0-9]{6,}");//{6,} yêu cầu nhập 5 ký tự trở lên
        Account a = new Account(username, password);

        try {
            //user.txt thì lưu dạng text vd fu hoa la
            //user.dat lưu dạng bit byte vd: fu hoa la -> bit 
            //  BufferedWriter để ghi vào file dat
            BufferedWriter out = new BufferedWriter(new FileWriter("user.dat", true)); //true  để add thêm vào 
            out.newLine(); //ghi dữ liệu vào dòng mới
            out.write(a.toString());//write là ghi còn toString nó như nào thì n ghi đúng như vậy
            out.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {
        UserManager m = new UserManager();
        Validation v = new Validation();
        m.menu();
        while (true) {
            int choice = v.getChoice("> Choose: ", 1, 3);
            switch (choice) {
                case 1:
                    m.createAcc();
                    //add account
                    break;
                case 2:
                    //login
                    String username = v.getString("Enter UserName: ",
                            "You must enter least at 5 character, and no space",
                            "[a-zA-Z0-9]{5,}");
                    String password = v.getString("Enter password: ",
                            "You must enter least at 6 character, and no space",
                            "[a-zA-Z0-9]{6,}");
                    if(m.checkUsername(username, password) ==0){
                        
                    }
                    break;
                case 3:
                    System.exit(0);
            }
        }

    }
}
