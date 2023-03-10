// https://leetcode.com/problems/search-a-2d-matrix-ii/
public class SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = n - 1;
        while (i < m && j >= 0) {
            int num = matrix[i][j];
            if (num == target) {
                return true;
            }
            if (num < target) {
                i++;
            } else {
                --j;
            }
        }
        return false;
    }
}
