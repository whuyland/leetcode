// https://leetcode.com/problems/set-matrix-zeroes/
public class SetMatrixZerosLessMemory {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean clearFirstColumn = false;
        // use matrix[0][0] to track if we need to clear first row

        for (int i = 0; i < m; ++i) {
            if (matrix[i][0] == 0) {
                clearFirstColumn = true;
            }
            for (int j = 1; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (matrix[0][0] == 0) {
            for (int j = 1; j < n; ++j) {
                matrix[0][j] = 0;
            }
        }
        if (clearFirstColumn) {
            for (int i = 0; i < m; ++i) {
                matrix[i][0] = 0;
            }
        }
    }
}
