//https://docs.google.com/document/d/1sjWEJkloUribDBTJp331rk32cDFKxADX/edit
/**
 *
 * @author Yankee
 */
public class ChangeBaseMain {

    public static void main(String[] args) {
        ChangeBaseMain cb = new ChangeBaseMain();
        Convert c = new Convert();
        while (true) {
            System.out.println("-Choose base convert 1 to binary, 2 to decimal, 3 to hexa.");
            System.out.print("Choose your input: ");
            int inputBase = c.getChoice(1, 3);
            int outputBase = 0;
            System.out.println("-Choose number you want output 1 to binary, 2 to decimal, 3 to hexa!");
            while (true) {
                System.out.print("Choose your output: ");
                outputBase = c.getChoice(1, 3);
                if (inputBase == outputBase) {
                    System.err.println("The base input must be different the base output to convert! Re-enter.");
                } else {
                    break;
                }
            }
            String input = c.checkNum(inputBase);
            String temp = "";
            switch (inputBase) {
                case 1:
                    //khi nhap 1 la convert tu binary
                    temp = c.converToDec(input, 2);
                    System.out.println(input + "(" + "Bin" + ") = " + temp + "(" + "Dec" + ")");
                    if (outputBase == 3) {
                        temp = c.convertDecToHex_Bin_StrBui(temp, 16);
                        System.out.println(input + "(" + "Bin" + ") = " + temp + "(" + "Hex" + ")");
                    }
                    break;
                case 2:
                    if (outputBase == 1) {
                        temp = c.convertDecToHex_Bin_StrBui(input, 2);
                        System.out.println(input + "(" + "Dec" + ") = " + temp + "(" + "Bin" + ")");
                    } else {
                        temp = c.convertDecToHex_Bin_StrBui(input, 16);
                        System.out.println(input + "(" + "Dec" + ") = " + temp + "(" + "Hex" + ")");

                    }
                    break;
                case 3:
                    if (outputBase == 1) {
                        temp = c.converToDec(input, 16);
                        temp = c.convertDecToHex_Bin_StrBui(temp, 2);
                        System.out.println(input + "(" + "Hex" + ") = " + temp + "(" + "Bin" + ")");
                    }
                    if (outputBase == 2) {
                        temp = c.converToDec(input, 16);
                        System.out.println(input + "(" + "Hex" + ") = " + temp + "(" + "Dec" + ")");

                    }
                    break;
            }
            System.out.println("---------------------------------------------------------------------");

            if (!c.checkYesNo("Do you want to convert continue?\n"
                    + "Choose Yes(Y) to continue or No(N) to stop program.\n=> Your choice: ")) {
                System.out.println("___________________________________________________________\n");
                break;
            } else {
                System.out.println();
            }
        }
 //            if (inputBase == 1) {
//                if (outputBase == 2) {
//                    temp = c.converToDec(input, 2);
//                    System.out.println(input + "(" + inputBase + ") = " + temp + "(" + outputBase + ")");
//                }
//                if (outputBase == 3) {
//                    temp = c.converToDec(input, 2);
//                    temp = c.convertDecToHex_Bin(temp, 16);
//                    System.out.println(input + "(" + inputBase + ") = " + temp + "(" + outputBase + ")");
//                }
//            }
//            if (inputBase == 2) {
//                if (outputBase == 1) {
//                    temp = c.convertDecToHex_Bin(input, 2);
//                    System.out.println(input + "(" + inputBase + ") = " + temp + "(" + outputBase + ")");
//                }
//                if (outputBase == 3) {
//                    temp = c.convertDecToHex_Bin(input, 16);
//                    System.out.println(input + "(" + inputBase + ") = " + temp + "(" + outputBase + ")");
//                }
//            }
//            if (inputBase == 3) {
//                if (outputBase == 1) {
//                    temp = c.converToDec(input, 16);
//                    temp = c.convertDecToHex_Bin(temp, 2);
//                    System.out.println(input + "(" + inputBase + ") = " + temp + "(" + outputBase + ")");
//                }
//                if (outputBase == 2) {
//                    temp = c.converToDec(input, 16);
//                    System.out.println(input + "(" + inputBase + ") = " + temp + "(" + outputBase + ")");
//                }
//            }
//            System.out.println("----------------------------------------------------------------------------------");
//            if (!c.checkYesNo("Do you want to convert continue?\n"
//                    + "Choose Yes(Y) to continue or No(N) to stop program.\n=> Your choice: ")) {
//                System.out.println("___________________________________________________________\n");
//                break;
//            } else {
//                System.out.println();
//            }
    }
}
