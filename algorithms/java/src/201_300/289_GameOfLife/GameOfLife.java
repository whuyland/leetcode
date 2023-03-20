// https://leetcode.com/problems/game-of-life/
public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] copy = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                copy[i][j] = board[i][j];
            }
        }
        for (int i = 0; i < m; ++i) {
            int one = 0;

            // initial first
            for (int p = Math.max(0, i - 1); p <= Math.min(m - 1, i + 1); ++p) {
                one += copy[p][0];
            }

            for (int j = 0; j < n; ++j) {
                // add right column
                if (j + 1 < n) {
                    for (int p = Math.max(0, i - 1); p <= Math.min(m - 1, i + 1); ++p) {
                        one += copy[p][j + 1];
                    }
                }
                // remove itself
                one -= copy[i][j];

                if (copy[i][j] == 1) {
                    if (one < 2 || one > 3) {
                        board[i][j] = 0;
                    }
                } else if (one == 3) {
                    board[i][j] = 1;
                }
                // add it self
                one += copy[i][j];
                // remove left column
                if (j - 1 >= 0) {
                    for (int p = Math.max(0, i - 1); p <= Math.min(m - 1, i + 1); ++p) {
                        one -= copy[p][j - 1];
                    }
                }
            }
        }
    }
}
