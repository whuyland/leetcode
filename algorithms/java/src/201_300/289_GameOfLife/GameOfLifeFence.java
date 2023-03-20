// https://leetcode.com/problems/game-of-life/
public class GameOfLifeFence {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] copy = new int[m + 2][n + 2];
        for (int i = 0; i < m; ++i) {
            System.arraycopy(board[i], 0, copy[i + 1], 1, n);
        }
        for (int i = 1; i <= m; ++i) {
            int one = 0;

            // initial first two columns, because first column is zero, can skip
            for (int p = -1; p <= 1; ++p) {
                one += copy[i + p][1];
            }

            for (int j = 1; j <= n; ++j) {
                // add right column
                for (int p = -1; p <= 1; ++p) {
                    one += copy[i + p][j + 1];
                }
                // remove itself
                one -= copy[i][j];

                if (copy[i][j] == 1) {
                    if (one < 2 || one > 3) {
                        board[i - 1][j - 1] = 0;
                    }
                } else if (one == 3) {
                    board[i - 1][j - 1] = 1;
                }
                // add itself
                one += copy[i][j];
                // remove left column
                for (int p = -1; p <= 1; ++p) {
                    one -= copy[i + p][j - 1];
                }
            }
        }
    }
}
