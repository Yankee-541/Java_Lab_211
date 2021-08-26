//https://docs.google.com/document/d/1sjWEJkloUribDBTJp331rk32cDFKxADX/edit
//p0011_changeBase



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Yankee
 */
public class ChangeBaseMain {

    public static void main(String[] args) {
        Convert c = new Convert();
        while (true) {
            System.out.println("-Choose base convert 1 to binary, 2 to decimal, 3 to hexa.");
            System.out.print("-Choose your input: ");
            int inputBase = c.getChoice(1, 3);
            int outputBase = 0;
            System.out.println("-Choose number you want output 1 to binary, 2 to decimal, 3 to hex.");
            while (true) {
                System.out.print("-Choose your output: ");
                outputBase = c.getChoice(1, 3);
                if (inputBase == outputBase) {
                    System.out.println("-The base input must be different the base output to convert! Re-enter.");
                } else {
                    break;
                }
            }
            String input = c.checkNum(inputBase);
            String temp = "";
            switch (inputBase) {
                case 1:
                    //khi nhap 1 la convert tu binary
                    if (outputBase == 2) {
                        temp = c.converToDec(input, 2);
                        System.out.println(input + "(Bin) = " + temp + "(Dec)");
                    } else {
                        temp = c.converToDec(input, 2);
                        temp = c.convertDecTo_Hex_Bin(temp, 16);
                        System.out.println(input + "(Bin) = " + temp + "(Hex)");
                    }
                    break;
                case 2:
                    //khi nhap 2 la convert tu decimal
                    if (outputBase == 1) {
                        temp = c.convertDecTo_Hex_Bin(input, 2);
                        System.out.println(input + "(Dec) = " + temp + "(Bin)");
                    } else {
                        temp = c.convertDecTo_Hex_Bin(input, 16);
                        System.out.println(input + "(Dec) = " + temp + "(Hex)");
                    }
                    break;
                case 3:
                    //khi nhap 3 la convert tu heximal
                    if (outputBase == 1) {
                        temp = c.converToDec(input, 16);
                        temp = c.convertDecTo_Hex_Bin(temp, 2);
                        System.out.println(input + "(Hex) = " + temp + "(Bin)");
                    } else {
                        temp = c.converToDec(input, 16);
                        System.out.println(input + "(Hex) = " + temp + "(Dec)");

                    }
                    break;
            }
            System.out.println("---------------------------------------------------------------------");
            if (!c.checkYesNo()) {
                System.out.println("___________________________________________________________\n");
                break;
            } else {
                System.out.println();
            }
        }
    }
}


     //            if (inputBase == 1) {
//                if (outputBase == 2) {
//                    temp = c.converToDec(input, 2);
//                    System.out.println(input + "(" + inputBase + ") = " + temp + "(" + outputBase + ")");
//                }
//                if (outputBase == 3) {
//                    temp = c.converToDec(input, 2);
//                    temp = c.convertDecTo_Hex_Bin(temp, 16);
//                    System.out.println(input + "(" + inputBase + ") = " + temp + "(" + outputBase + ")");
//                }
//            }
//            if (inputBase == 2) {
//                if (outputBase == 1) {
//                    temp = c.convertDecTo_Hex_Bin(input, 2);
//                    System.out.println(input + "(" + inputBase + ") = " + temp + "(" + outputBase + ")");
//                }
//                if (outputBase == 3) {
//                    temp = c.convertDecTo_Hex_Bin(input, 16);
//                    System.out.println(input + "(" + inputBase + ") = " + temp + "(" + outputBase + ")");
//                }
//            }
//            if (inputBase == 3) {
//                if (outputBase == 1) {
//                    temp = c.converToDec(input, 16);
//                    temp = c.convertDecTo_Hex_Bin(temp, 2);
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