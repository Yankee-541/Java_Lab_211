
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alias
 */
public class Validation {
    Scanner sc = new Scanner(System.in);
    public String getString(String mess){
        String txt = "";
        while(true){
            System.out.print(mess);
            txt = sc.nextLine();
            if(txt.trim().isEmpty()){
                System.out.println("String is empty, please input again");
            }else{
                break;
            }
        }
        return txt;
    }
    public int getNumber(String mess){
        int number = 0;
        while(true){
            try {
                System.out.print(mess);
                number = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Invalid number, please input again");
            }
        }
        return number;
    }
}
