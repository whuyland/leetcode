// https://leetcode.com/problems/n-queens-ii/
public class NQueensII {
    public int totalNQueens(int n) {
        int[][] board = new int[n][n];
        return solve(n, 0, board);
    }

    private int solve(int n, int row, int[][] board) {
        if (row == board.length) {
            return 1;
        }
        int ret = 0;
        for (int col = 0; col < n; ++col) {
            if (!isValid(board, row, col)) {
                continue;
            }
            board[row][col] = 1;
            ret += solve(n, row + 1, board);
            board[row][col] = 0;
        }
        return ret;
    }

    private boolean isValid(int[][] board, int row, int column) {
        for (int i = 0; i < row; ++i) {
            if (board[i][column] == 1) {
                return false;
            }
        }
        int i = row - 1;
        int j = column - 1;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 1) {
                return false;
            }
            --i;
            --j;
        }
        i = row - 1;
        j = column + 1;
        while (i >= 0 && j < board.length) {
            if (board[i][j] == 1) {
                return false;
            }
            --i;
            ++j;
        }
        return true;
    }
}
