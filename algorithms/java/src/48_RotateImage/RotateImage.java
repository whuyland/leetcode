// https://leetcode.com/problems/rotate-image/
public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; ++i) {
            // int up = i
            // int bottom = n - 1 - i
            // int left = i
            // int right = n - 1 - i
            // diff = j - i
            for (int j = i; j < n - 1 - i; ++j) {
                int tmp = matrix[i][j]; // matrix[up][left + diff]
                matrix[i][j] = matrix[n - 1 - j][i]; // matrix[bottom - diff][left]
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j]; // matrix[bottom][right - diff];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i]; // matrix[up + diff][right]
                matrix[j][n - 1 - i] = tmp;
            }
        }
    }
}
