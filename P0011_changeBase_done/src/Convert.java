
import java.math.BigDecimal;
import java.util.Scanner;

/**
 *
 * @author Yankee
 */
public class Convert {
    Scanner sc = new Scanner(System.in);
    public int getChoice(int min, int max) {
  
        while (true) {
            try {
                int temp = Integer.parseInt(sc.nextLine());
                if (temp < min || temp > max) {
                    System.err.print("Input out of scope,please input again: ");
                } else {
                    return temp;
                }
            } catch (NumberFormatException e) {
                System.err.print("Wrong input, please enter again: ");
            }
        }
    }

    public String checkNum(int base) {

        System.out.print("-Enter number you want convert: ");
        while (true) {
            String temp = sc.nextLine();
            switch (base) {
                case 1:
                    if (temp.trim().matches("[01]+")) {
                        return temp;
                    }
                    break;
                case 2:
                    if (temp.trim().matches("[0-9]+")) {
                        return temp;
                    }
                    break;
                case 3:
                    if (temp.trim().matches("[0-9a-fA-F]+")) {
                        return temp;
                    }
                    break;
            }
            System.out.print("Invalid type, please input again: ");
        }
    }

//    /Use String builder
    public String convertDecToHex_Bin_StrBui(String dec, int base) {
        StringBuilder answer = new StringBuilder();
        BigDecimal tempD = new BigDecimal(dec);
        BigDecimal du;
        if (dec.equals("0")) {
            answer = new StringBuilder("0");
        } else {
            while (!tempD.equals(BigDecimal.ZERO)) {
                du = tempD.remainder(new BigDecimal(base));//chia lấy dư bigdecimal
                int mod = du.intValue(); //parse bigdecimal sang int
                String temp = "";
                switch (mod) {
                    case 10:
                        temp = "a";
                        break;
                    case 11:
                        temp = "b";
                        break;
                    case 12:
                        temp = "c";
                        break;
                    case 13:
                        temp = "d";
                        break;
                    case 14:
                        temp = "e";
                        break;
                    case 15:
                        temp = "f";
                        break;
                    default:
                        temp = mod + "";
                }
//            answer = temp + answer; 
                answer.insert(0, temp);
                tempD = (tempD.subtract(du)).divide(new BigDecimal(base));
//            23
                // 2*16^1 + 3*16^0
            }
        }
        return answer.toString();
    }

    //convert Bin to Dec or Hex to Dec
    public String converToDec(String hex, int base) {
        hex = hex.toLowerCase();
        BigDecimal answer = new BigDecimal("0");
        for (int i = 0; i < hex.length(); i++) {
            char ch = hex.charAt(i);
            int value;
            switch (ch) {
                case 'a':
                    value = 10;
                    break;
                case 'b':
                    value = 11;
                    break;
                case 'c':
                    value = 12;
                    break;
                case 'd':
                    value = 13;
                    break;
                case 'e':
                    value = 14;
                    break;
                case 'f':
                    value = 15;
                    break;
                default:
                    value = Integer.parseInt(ch + "");
            }
            //base = 16
            //23ab 
            // 2*16^3 + 3*16^2 + 10*16^1 + 11*16^0
            BigDecimal after = new BigDecimal(base).pow(hex.length() - 1 - i);
            //after = pow(base, hex.length() - 1 - i)
            //answer = answer + value * after
            answer = answer.add(new BigDecimal(value).multiply(after));
        }
        return String.valueOf(answer);
    }

    public boolean checkYesNo(String tmp) {
        System.out.print(tmp);
        while (true) {
            String s = sc.nextLine();
            s = s.replaceAll(" ", "");
            if (s.compareToIgnoreCase("yes") == 0 || s.compareToIgnoreCase("y") == 0) {
                return true;
            }
            if (s.compareToIgnoreCase("no") == 0 || s.compareToIgnoreCase("n") == 0) {
                return false;
            }
            System.err.print("You mustt choose Yes(Y) or No(N): ");
        }
    }
}

//    //using array
//    public String convertToDecArray(String hex, int base) {
//        hex = hex.toLowerCase();
//        BigDecimal answer = new BigDecimal("0");
//        char a[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
//        //187bac
//        for (int i = 0; i < hex.length(); i++) {
//            char ch = hex.charAt(i);
//            int value = 0;
//            if(ch == a[i]){
//                value = i;
//            }
//            BigDecimal after = new BigDecimal(base).pow(hex.length() - 1 - i);
//            answer = answer.add(new BigDecimal(value).multiply(after));
//        }
//        return String.valueOf(answer);
//    }
//Use String builder
//      public String convertDecToHex_Bin_StrBui(String dec, int base) {
//        StringBuilder answer = new StringBuilder();
//        BigDecimal tempD = new BigDecimal(dec);
//        BigDecimal du;
//        while (!tempD.equals(BigDecimal.ZERO)) {
//            du = tempD.remainder(new BigDecimal(base));//chia lấy dư bigdecimal
//            int mod = du.intValue(); //parse bigdecimal sang int
//            String temp = "";
//            switch (mod) {
//                case 10:
//                    temp = "a";
//                    break;
//                case 11:
//                    temp = "b";
//                    break;
//                case 12:
//                    temp = "c";
//                    break;
//                case 13:
//                    temp = "d";
//                    break;
//                case 14:
//                    temp = "e";
//                    break;
//                case 15:
//                    temp = "f";
//                    break;
//                default:
//                    temp = mod + "";
//            }
////            answer = temp + answer;
//            answer.insert(0, temp);
//            tempD = (tempD.subtract(du)).divide(new BigDecimal(base));
//            //tempD = (tempB - du)/ base
//        }
//        return answer.toString();
//    }
//Dùng string
//    public String convertDecToHex_Bin(String dec, int base) {
//        String answer = "";
//        BigDecimal numDec = new BigDecimal(dec);
//        BigDecimal du;
//        if (dec.equals("0")) {
//            answer += "0";
//        } else {
//            while (!numDec.equals(BigDecimal.ZERO)) {//baoh = 0 thi stop
//                du = numDec.remainder(new BigDecimal(base));//chia lấy dư bigdecimal
//                int mod = du.intValue(); //parse bigdecimal sang int
//                String temp = "";
//                switch (mod) {
//                    case 10:
//                        temp = "a";
//                        break;
//                    case 11:
//                        temp = "b";
//                        break;
//                    case 12:
//                        temp = "c";
//                        break;
//                    case 13:
//                        temp = "d";
//                        break;
//                    case 14:
//                        temp = "e";
//                        break;
//                    case 15:
//                        temp = "f";
//                        break;
//                    default:
//                        //chia có dư 1 to 9
//                        temp = mod + "";
//                }
//                answer = temp + answer; //lưu đảo ngược ket qua
//                numDec = (numDec.subtract(du)).divide(new BigDecimal(base));
//            }
//        }
//        return answer;
//    }
