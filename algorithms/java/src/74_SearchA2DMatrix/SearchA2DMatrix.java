// https://leetcode.com/problems/search-a-2d-matrix/
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0;
        int r = m * n;
        while (l < r) {
            int mid = (l + r) / 2;
            int value = getValue(matrix, n, mid);
            if (value == target) {
                return true;
            }
            if (value > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }

    private int getValue(int[][] matrix, int rowLen, int index) {
        return matrix[index / rowLen][index % rowLen];
    }
}
