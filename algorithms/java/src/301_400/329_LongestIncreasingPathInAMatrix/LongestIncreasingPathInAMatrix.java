// https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
public class LongestIncreasingPathInAMatrix {
    static private final int[][] steps = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        // if we only move to larger value, we will not use come back
        int[][] memo = new int[m][n];
        int ret = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                ret = Math.max(ret, solve(matrix, i, j, -1, memo));
            }
        }
        return ret;
    }

    private int solve(int[][] matrix, int i, int j, int val, int[][] memo) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length
                || matrix[i][j] <= val) {
            return 0;
        }
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        int max = 1;
        for (int[] step : steps) {
            max = Math.max(max, 1 + solve(matrix, i + step[0], j + step[1], matrix[i][j], memo));
        }
        memo[i][j] = max;
        return max;
    }
}
