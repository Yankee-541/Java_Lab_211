/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1_s_p0070;
/**
 *
 * @author Yankee
 */
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class Ebank {

    ResourceBundle rb;

    public Ebank() {
    }

    public Ebank(ResourceBundle rb) {
        this.rb = rb;
    }

    public void setLocal(Locale language) {
        rb = ResourceBundle.getBundle("Language/" + language);
    }
    
    
    public String checkAccount(String acc) {
        if (acc.isEmpty()) {
            return rb.getString("errAccEmpty");
        } else {
            Pattern p = Pattern.compile("^[0-9]{10}$");
            if (p.matcher(acc).find()) {
                return "True";
            }
            return rb.getString("errInputAcc");
        }
    }

    public String checkPassword(String pass) {
        if (pass.isEmpty()) {
            return rb.getString("errPasswordEmpty");
        } else {
            Pattern p = Pattern.compile("^[0-9A-Za-z]{8,31}");
            Pattern pDigit = Pattern.compile("^[0-9A-Za-z]*[0-9]+[0-9A-Za-z]*");
            Pattern pLetter = Pattern.compile("^[0-9A-Za-z]*[A-Za-z]+[0-9A-Za-z]");

            if (p.matcher(pass).find() && pDigit.matcher(pass).find()
                    && pLetter.matcher(pass).find()) {
                return "True";
            }
            return rb.getString("errInputPassword");
        }
    }

    public String createCaptcha() {
        char[] chars = {'A', 'a', 'B', 'b', 'C',
            'c', 'D', 'd', 'E', 'e', 'F', 'f', 'G', 'g', 'H', 'h', 'I',
            'i', 'J', 'j', 'K', 'k', 'L', 'l', 'M', 'm', 'N', 'n', 'O',
            'o', 'P', 'p', 'Q', 'q', 'R', 'r', 'S', 's', 'T', 't', 'U',
            'u', 'V', 'v', 'U', 'u', 'W', 'w', 'X', 'x', 'Y', 'y', 'Z',
            'z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};

        final int length = 6;
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 0; i < length; i++) {
            index = (int) (Math.random() * (chars.length - 1));
            sb.append(chars[index]);
        }
        return sb.toString();
    }

    public String checkCaptcha(String captCha, String createCaptcha) {
        if (captCha.isEmpty()) {
            return rb.getString("errCaptcha");
        } else if (createCaptcha.contains(captCha) && createCaptcha.length() == captCha.length()) {
            return "True";
        } else {
            return rb.getString("errCaptcha");
        }
    }

}
