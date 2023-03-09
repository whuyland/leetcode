import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/n-queens/
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] row: board) {
            Arrays.fill(row, '.');
        }
        List<List<String>> ret = new LinkedList<>();
        solve(n, 0, board, ret);
        return ret;
    }

    // at every row, we must put one Queen at some column
    private void solve(int n, int row, char[][] board, List<List<String>> ret) {
        if (row == n) {
            List<String> ans = new LinkedList<>();
            for (char[] chars: board) {
                ans.add(String.valueOf(chars));
            }
            ret.add(ans);
            return;
        }

        for (int col = 0; col < n; ++col) {
            if (!isValid(board, row, col)) {
                continue;
            }
            board[row][col] = 'Q';
            solve(n, row + 1, board, ret);
            board[row][col] = '.';
        }
    }

    private boolean isValid(char[][] board, int row, int col) {
        // up left
        int i = row - 1;
        int j = col - 1;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q') {
                return false;
            }
            --i;
            --j;
        }
        // up right
        i = row - 1;
        j = col + 1;
        while (i >= 0 && j < board.length) {
            if (board[i][j] == 'Q') {
                return false;
            }
            --i;
            ++j;
        }
        // column
        for (i = 0; i < row; ++i) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        return true;
    }
}
