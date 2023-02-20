// https://leetcode.com/problems/minimum-path-sum/
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (i == 0 && j == 0) {
                    continue;
                }
                grid[i][j] = grid[i][j] + Math.min(i > 0 ? grid[i - 1][j] : Integer.MAX_VALUE, j > 0 ? grid[i][j - 1] : Integer.MAX_VALUE);
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
