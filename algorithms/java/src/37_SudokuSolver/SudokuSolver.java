// https://leetcode.com/problems/sudoku-solver/
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] column = new int[9][9];
        int[][] box = new int[9][9];

        // build dict
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') {
                    continue;
                }
                int index = board[i][j] - '1';
                row[i][index] = 1;
                column[j][index] = 1;
                box[boxIndex(i, j)][index] = 1;
            }
        }
        solve(board, row, column, box, 0, 0);
    }

    private boolean solve(char[][] board, int[][] row, int[][] column, int[][] box, int i, int j) {
        if (i == 8 && j == 9) {
            return true;
        }
        // correct i and j
        if (j >= 9) {
            ++i;
            j = 0;
        }
        if (i >= 9) {
            return false;
        }

        char c = board[i][j];
        if (c != '.') {
            return solve(board, row, column, box, i, j + 1);
        }

        for (int num = 0; num < 9; ++num) {
            int k = boxIndex(i, j);
            if (row[i][num] != 0 || column[j][num] != 0 || box[k][num] != 0) {
                continue;
            }
            row[i][num] = 1;
            column[j][num] = 1;
            box[k][num] = 1;
            board[i][j] = (char) ('1' + num);
            if (solve(board, row, column, box, i, j + 1)) {
                return true;
            }
            row[i][num] = 0;
            column[j][num] = 0;
            box[k][num] = 0;
            board[i][j] = '.';
        }
        return false;
    }

    private int boxIndex(int i, int j) {
        return i / 3 * 3 + j / 3;
    }
}
