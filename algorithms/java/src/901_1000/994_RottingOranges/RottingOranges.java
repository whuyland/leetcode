import java.util.LinkedList;

// https://leetcode.com/problems/rotting-oranges/
public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        LinkedList<int[]> rotten = new LinkedList<>();
        int health = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 2) {
                    rotten.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    ++health;
                }
            }
        }
        int[][] directions = new int[][]{{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

        int days = 0;
        while (!rotten.isEmpty() && health != 0) {
            int numJob = rotten.size();
            for (int k = 0; k < numJob; ++k) {
                int[] top = rotten.removeFirst();
                for (int[] diff : directions) {
                    int i = top[0] + diff[0];
                    int j = top[1] + diff[1];
                    if (i >= 0 && i < m && j >= 0 && j < n && grid[i][j] == 1) {
                        grid[i][j] = 2;
                        rotten.add(new int[]{i, j});
                        --health;
                    }
                }
            }
            ++days;
        }
        return health == 0 ? days : -1;
    }
}
