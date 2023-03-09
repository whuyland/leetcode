// https://leetcode.com/problems/valid-sudoku/
public class ValidSudokuI {
    public boolean isValidSudoku(char[][] board) {
        int[] his = new int[9];

        // row
        for (char[] row : board) {
            clear(his);
            for (char c : row) {
                inc(his, c);
            }
            if (isInvalid(his)) {
                return false;
            }
        }

        // column
        for (int j = 0; j < 9; ++j) {
            clear(his);
            for (int i = 0; i < 9; ++i) {
                inc(his, board[i][j]);
            }
            if (isInvalid(his)) {
                return false;
            }
        }

        // every box
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                clear(his);
                for (int m = i; m < i + 3; ++m) {
                    for (int n = j; n < j + 3; ++n) {
                        inc(his, board[m][n]);
                    }
                }
                if (isInvalid(his)) {
                    return false;
                }
            }
        }
        return true;
    }

    private void inc(int[] his, char c) {
        if (c == '.') {
            return;
        }
        his[c - '1']++;
    }

    private void clear(int[] his) {
        for (int i = 0; i < 9; ++i) {
            his[i] = 0;
        }
    }

    private boolean isInvalid(int[] his) {
        for (int i : his) {
            if (i > 1) {
                return true;
            }
        }
        return false;
    }
}
