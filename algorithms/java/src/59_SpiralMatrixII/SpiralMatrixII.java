// https://leetcode.com/problems/spiral-matrix-ii/
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] ret = new int[n][n];
        solve(ret, 0, 0, n - 1, n - 1, 0, 1);
        return ret;
    }

    private void solve(int[][] ret, int startI, int startJ, int endI, int endJ, int direction, int num) {
        if (startI > endI || startJ > endJ) {
            return;
        }
        // top: left to right
        if (direction == 0) {
            for (int j = startJ; j <= endJ; ++j) {
                ret[startI][j] = num++;
            }
            solve(ret, startI + 1, startJ, endI, endJ, 1, num);
        }
        // right: top to bottom
        if (direction == 1) {
            for (int i = startI; i <= endI; ++i) {
                ret[i][endJ] = num++;
            }
            solve(ret, startI, startJ, endI, endJ - 1, 2, num);
        }
        // bottom: right to left
        if (direction == 2) {
            for (int j = endJ; j >= startJ; --j) {
                ret[endI][j] = num++;
            }
            solve(ret, startI, startJ, endI - 1, endJ, 3, num);
        }
        // right: bottom to top
        if (direction == 3) {
            for (int i = endI; i >= startI; --i) {
                ret[i][startJ] = num++;
            }
            solve(ret, startI, startJ + 1, endI, endJ, 0, num);
        }
    }
}
