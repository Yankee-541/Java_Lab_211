import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 *
 * @author Yankee
 */
public class Search {
//function input  name txt
    public String getText(String mess) {
        String txt = "";
        System.out.print(mess);
        while (true) {            //hàm check k cho người dùng nhập sai và bắt nhập lại
            Scanner sc = new Scanner(System.in);
            txt = sc.nextLine();
            if(txt.isEmpty()){
                System.out.print("Can not null, re-input: ");
            }else{
                break;
            }
        }
        return txt;
    }
//ham nhap & tim  chuoi muon tim trong txt
    public void search(File file, String txt) {
        try {
            Scanner sc = new Scanner(file);//dung scanner de read du lieu tu txt
            int count = 0;
            while (sc.hasNextLine()) { //doc xem con dong nao nua khong
                String line = sc.nextLine(); //doc du lieu tung dong
                String arr[] = line.split("\\s+");//xoa từ ở dấu cách hoặc nhiều dấu cách
                for (String word : arr) {
                    if (word.toLowerCase().contains(txt.toLowerCase())) {
                        count++;
                        if (count == 1) {
                            System.out.println("\nSearch results:");
                        }
                        System.out.println("\t" + word);
                    }
                }
            }
            if (count == 0) {
                System.out.println("\nNot found " + "\""+txt+ "\"" + " in file");
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Not found file.");
        }
    }
    public static void main(String[] args) {
        Search s = new Search();
        String directory = s.getText("Please enter directory of file: ");
        File file = new File(directory);
        if (file.exists()) {
            String txt = s.getText("Please enter string to search: ");
            s.search(file, txt);
        } else {
            System.out.println("Not found.");
        }
    }
}
