import java.util.LinkedList;

// https://leetcode.com/problems/number-of-islands/
public class NumberOfIslandsI {
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

    private void grow(char[][] grid, int rootI, int rootJ) {
        int m = grid.length;
        int n = grid[0].length;
        LinkedList<int[]> jobs = new LinkedList<>();
        jobs.add(new int[]{rootI, rootJ});

        while (!jobs.isEmpty()) {
            int[] root = jobs.removeFirst();
            int i = root[0];
            int j = root[1];
            if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '1') {
                continue;
            }
            grid[i][j] = 'x';
            jobs.add(new int[]{i - 1, j});
            jobs.add(new int[]{i, j - 1});
            jobs.add(new int[]{i + 1, j});
            jobs.add(new int[]{i, j + 1});
        }
    }
}
