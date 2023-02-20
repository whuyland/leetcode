// https://leetcode.com/problems/unique-paths-ii/
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }
        obstacleGrid[m - 1][n - 1] = 1;
        int i = m - 2;
        while (i >= 0 && obstacleGrid[i][n - 1] == 0 && obstacleGrid[i + 1][n - 1] == 1) {
            obstacleGrid[i--][n - 1] = 1;
        }
        while (i >= 0) {
            obstacleGrid[i--][n - 1] = 0;
        }
        int j = n - 2;
        while (j >= 0 && obstacleGrid[m - 1][j] == 0 && obstacleGrid[m - 1][j + 1] == 1) {
            obstacleGrid[m - 1][j--] = 1;
        }
        while (j >= 0) {
            obstacleGrid[m - 1][j--] = 0;
        }
        for (i = m - 2; i >= 0; --i) {
            for (j = n - 2; j >= 0; --j) {
                obstacleGrid[i][j] = obstacleGrid[i][j] == 1 ? 0 : obstacleGrid[i + 1][j] + obstacleGrid[i][j + 1];
            }
        }
        return obstacleGrid[0][0];
    }
}