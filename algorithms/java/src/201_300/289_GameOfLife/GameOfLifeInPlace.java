// https://leetcode.com/problems/game-of-life/
public class GameOfLifeInPlace {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        // 0: 0 -> 0, 0: 1 -> 1
        // 2: 0 -> 1, 3: 1 -> 0
        for (int i = 0; i < m; ++i) {
            int one = 0;

            // initial first
            for (int p = Math.max(0, i - 1); p <= Math.min(m - 1, i + 1); ++p) {
                one += getRealNum(board[p][0]);
            }

            for (int j = 0; j < n; ++j) {
                // add right column
                if (j + 1 < n) {
                    for (int p = Math.max(0, i - 1); p <= Math.min(m - 1, i + 1); ++p) {
                        one += getRealNum(board[p][j + 1]);
                    }
                }
                // remove itself
                one -= getRealNum(board[i][j]);

                if (board[i][j] == 1) {
                    if (one < 2 || one > 3) {
                        board[i][j] = 3;
                    }
                } else if (one == 3) {
                    board[i][j] = 2;
                }
                // add itself
                one += getRealNum(board[i][j]);
                // remove left column
                if (j - 1 >= 0) {
                    for (int p = Math.max(0, i - 1); p <= Math.min(m - 1, i + 1); ++p) {
                        one -= getRealNum(board[p][j - 1]);
                    }
                }
            }
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == 3) {
                    board[i][j] = 0;
                } else if (board[i][j] == 2) {
                    board[i][j] = 1;
                }
            }
        }
    }

    private int getRealNum(int val) {
        return val & 1;
    }
}
