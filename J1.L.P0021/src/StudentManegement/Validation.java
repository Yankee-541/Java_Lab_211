/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentManegement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Quang
 */
public class Validation {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public int getInt(String msg, String err, int min, int max) {
        while (true) {
            try {

                int num;
                System.out.print(msg);
                num = Integer.parseInt(in.readLine());
                if (num < min || num > max) {
                    System.out.println(err);
                    continue;
                }
                return num;
            } catch (Exception ex) {
                System.out.println(err);
            }
        }
    }

    //NHập vào 1 string thỏa mãn regex nào đấy
    public String getString(String msg, String err, String regex) {
        while (true) {
            try {
                String str;
                System.out.print(msg);
                str = in.readLine();
                if (str.matches(regex)) {
                    return str;
                } else {
                    System.out.println(err);
                }
            } catch (Exception e) {
                System.out.println(err);
            }
        }
    }

    public String checkInpuCourse(String msg, String err) {
        while (true) {
            try {
                System.out.print(msg);
                String result = in.readLine();
                if (!result.equalsIgnoreCase("java")
                        && !result.equalsIgnoreCase(".net")
                        && !result.equalsIgnoreCase("c/c++")) {
                    System.out.println(err);
                    continue;
                } else {
                    return result;

                }
            } catch (IOException ex) {
                System.out.println(err);
            }
        }
    }
}
