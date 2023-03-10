// https://leetcode.com/problems/search-a-2d-matrix-ii/
public class SearchA2DMatrixIIBST {
    public boolean searchMatrix(int[][] matrix, int target) {
        System.out.println(target);
        int m = matrix.length;
        int n = matrix[0].length;
        int columnEnd = upperBound(matrix[0], target, true);
        int columnStart = upperBound(matrix[m - 1], target, false);
        int[] column = new int[m];
        for (int i = 0; i < m; ++i) {
            column[i] = matrix[i][0];
        }
        int rowEnd = upperBound(column, target, true);
        for (int i = 0; i < m; ++i) {
            column[i] = matrix[i][n - 1];
        }

        int rowStart = upperBound(column, target, false);
        for (int i = rowStart; i < rowEnd; ++i) {
            for (int j = columnStart; j < columnEnd; ++j) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    private int upperBound(int[] nums, int target, boolean skipTarget) {
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return skipTarget ? mid + 1 : mid;
            }
            if (nums[mid] > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }
}
