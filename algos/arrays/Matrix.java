package algos.arrays;

import java.util.Arrays;

public class Matrix {
    private int[][] matrix;

    public Matrix(int[][] matrix) {
        this.matrix = matrix;
    }

    /**
     * Rotate matrix 90 Deg
     */
    public int[][] rotate() {
        int length = this.matrix.length;
        if (length == 0) {
            return this.matrix;
        }

        for (int k = 0; k <= (length / 2) -1 ; k = k + 1) {
            int i = k;
            for (int j = k; j < length - 1 - k; j++) {
                int col1 = length - 1 - i;
                int row1 = j;
                int temp1 = this.matrix[row1][col1];
                int col2 = length - 1 - row1, row2 = col1;
                int temp2 = this.matrix[row2][col2];
                int col3 = length - 1 - row2, row3 = col2;
                int temp3 = this.matrix[row3][col3];

                this.matrix[row1][col1] = this.matrix[i][j];
                this.matrix[row2][col2] = temp1;
                this.matrix[row3][col3] = temp2;
                this.matrix[i][j] = temp3;
            }
        }
        return this.matrix;
    }

    public static void main(String[] args) {
        int[][] twoDArray = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] twoDArray2 = {{1, 2, 3, 4, 5}, {6, 7, 8, 9 , 10}, { 11, 12,13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22,23,24,25}};
        Matrix matrix1 = new Matrix(twoDArray);
        System.out.println(Arrays.deepToString(twoDArray));
        int[][] rotate = matrix1.rotate();
        System.out.println(Arrays.deepToString(matrix1.matrix));
        Matrix matrix2 = new Matrix(twoDArray2);
        System.out.println(Arrays.deepToString(twoDArray2));
        matrix2.rotate();
        System.out.println(Arrays.deepToString(matrix2.matrix));
    }
}
