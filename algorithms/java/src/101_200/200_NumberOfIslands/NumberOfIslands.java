import java.util.LinkedList;

// https://leetcode.com/problems/number-of-islands/
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int cnt = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '1') {
                    ++cnt;
                    grow(grid, i, j);
                }
            }
        }
        return cnt;
    }

    private void grow(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '0';
        grow(grid, i - 1, j);
        grow(grid, i, j - 1);
        grow(grid, i + 1, j);
        grow(grid, i, j + 1);
    }
}
