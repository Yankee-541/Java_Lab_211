
import java.util.Scanner;

/**
 *
 * @author Yankee
 */
public class Validate {

    Scanner sc = new Scanner(System.in);

    public int choice(String mess, int min, int max) {
        int choose;
        while (true) {
            try {
                System.out.print(mess);
                choose = Integer.parseInt(sc.nextLine());
                if (choose < min || choose > max) {
                    System.out.println("Your choice invalid.");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid.");
            }
        }
        return choose;
    }

    public int[][] inputMatrix(int n) {
        System.out.print("Enter row matrix " + n + ": ");
        int row = inputInt();
        System.out.print("Enter column matrix " + n + ": ");
        int col = inputInt();
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.println("Enter matrix " + n + ": [ " + (i + 1) + " ] " + "[ " + (j + 1) + " ]");
                matrix[i][j] = inputInt();
            }
        }

        return matrix;

    }
    public void Display(int[][] matrix){
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("[ " + matrix[i][j] + " ]");
            }
            System.out.println();
        }
    }

    public int inputInt() {
        int num;
        while (true) {
            try {
                num = Integer.parseInt(sc.nextLine());
                if (num < 0) {
                    System.out.println("A :");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid.");
            }
        }
        return num;

    }
}
