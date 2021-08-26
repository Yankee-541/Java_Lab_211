
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author admin
 */
public class CompareDate {

    public static void main(String[] args) {
        Date f, s;
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        df.setLenient(false);
        while (true) {
            try {
                System.out.print("Please enter the first date: ");
                f = df.parse(sc.nextLine());
                System.out.print("Please enter the second date: ");
                s = df.parse(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.print("Invalid date, please re-input date agian: ");
            }
        }
        if(f.before(s)){
            System.out.println("Date 1 is before date 2");
        }else if(f.after(s)){
            System.out.println("Date 2 is before date 1");
        }else{
            System.out.println("Date 1 is equal date 21");
        }

    }

}
