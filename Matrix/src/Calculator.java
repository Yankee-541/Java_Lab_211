/**
 *
 * @author Yankee
 */
public class Calculator {

    public int[][] addMatrix(int[][] matrix1, int[][] matrix2) {
        int row = matrix1.length;
        int col = matrix2[0].length;
        int[][] result = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return result;

    }

    public int[][] SubMatrix(int[][] matrix1, int[][] matrix2) {
        int row = matrix1.length;
        int col = matrix2[0].length;
        int[][] result = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }

        return result;
    }

    public int[][] MulMatrix(int[][] matrix1, int[][] matrix2) {
        int row = matrix1.length;
        int col1 = matrix1[0].length;
        int col2 = matrix2[0].length;
        int[][] result = new int[row][col2];

        for(int i = 0; i<row; i++){
            for (int j = 0; j < col2; j++) {
                result[i][j] = 0;
            }
        }
        
        for (int i = 0; i < row; i++) { // chạy từng phần tử trong hàng của matrix 1
            for (int j = 0; j < col2; j++) { // chạy từng phần tử của trong cột của matrix 2
                for (int k = 0; k < col1; k++) { // chạy từng phần tử trong cột của matrix 1
                    result[i][j] += matrix1[i][k] * matrix2[k][j]; // từng phần tử trong hàng của m1 x từng phần tử trong cột của m2)

                }
            }
        }

        return result;
    }

}
