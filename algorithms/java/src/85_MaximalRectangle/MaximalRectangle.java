// https://leetcode.com/problems/maximal-rectangle/
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] leftToRight = new int[m][n];
        int[][] topToDown = new int[m][n];

        int ret = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == '0') {
                    continue;
                }
                leftToRight[i][j] = 1 + (j > 0 ? leftToRight[i][j - 1] : 0);
                topToDown[i][j] = 1 + (i > 0 ? topToDown[i - 1][j] : 0);

                // append horizontal bar to top
                int length = Integer.MAX_VALUE;
                for (int k = 0; k < topToDown[i][j]; ++k) {
                    length = Math.min(length, leftToRight[i - k][j]);
                    ret = Math.max(ret, length * (k + 1));
                }

                // append vertical bar to left
                int height = Integer.MAX_VALUE;
                for (int k = 0; k < leftToRight[i][j]; ++k) {
                    height = Math.min(height, topToDown[i][j - k]);
                    ret = Math.max(ret, height * (k + 1));
                }
            }
        }

        return ret;
    }
}
