/**
 *
 * @author Yankee
 */
public class Main {

    public static void menu() {
        System.out.println("~~~~~~~~~~~---Colculator program---~~~~~~~~~~~");
        System.out.println("Option 1: Addition matrixes");
        System.out.println("Option 2: Subtraction matrixes");
        System.out.println("Option 3: Multiplication matrixes");
        System.out.println("Option 4: Exit program");
        System.out.println("> Your choice");
    }

    public static void main(String[] args) {
        Validate v = new Validate();
        Calculator c = new Calculator();
        int[][] matrix1;  
        int[][] matrix2;
        int choice;
        while (true) {
            menu();
            choice = v.choice("Your choice:  ", 1, 4);
            switch (choice) {
                case 1:
                    System.out.println("---Add matrix---");
                    matrix1 = v.inputMatrix(1);
                    System.out.println("");
                    matrix2 = v.inputMatrix(2);
                    System.out.println("");
                    v.Display(matrix1);
                    System.out.println(" + ");
                    v.Display(matrix2);
                    if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {//cùng số hàng và cùng số cột
                        System.out.println("Matrix is not equal !");
                        break;
                    }
                    System.out.println(" = ");
                    v.Display(c.addMatrix(matrix1, matrix2));
                    break;
                case 2:
                    System.out.println("---Sub matrix---");
                    matrix1 = v.inputMatrix(1);
                    System.out.println("");
                    matrix2 = v.inputMatrix(2);
                    System.out.println("");
                    v.Display(matrix1);
                    System.out.println(" - ");
                    v.Display(matrix2);
                                        
                    if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {//cùng số hàng và cùng số cột
                        System.out.println("Matrix is not equal !");
                        break;
                    }
                    System.out.println(" = ");
                    v.Display(c.SubMatrix(matrix1, matrix2));
                    break;
                case 3:
                   System.out.println("---Mul matrix---");
                    matrix1 = v.inputMatrix(1);
                    System.out.println("");
                    matrix2 = v.inputMatrix(2);
                    System.out.println("");
                    v.Display(matrix1);
                    System.out.println(" * ");
                    v.Display(matrix2);
                    if(matrix1[0].length != matrix2.length){//số cột không bằng số hàng
                        System.out.println("Matrix is not equal !");
                        break;
                    }
                    System.out.println("=");
                    v.Display(c.MulMatrix(matrix1, matrix2));
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }

    }

}
