// https://leetcode.com/problems/valid-sudoku/
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] column = new int[9][9];
        int[][] box = new int[9][9];
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') {
                    continue;
                }
                int num = board[i][j] - '1';
                int boxIndex = i / 3 * 3 + j / 3;
                if (row[i][num] != 0 || column[j][num] != 0 || box[boxIndex][num] != 0) {
                    return false;
                }
                row[i][num] = 1;
                column[j][num] = 1;
                box[boxIndex][num] = 1;
            }
        }
        return true;
    }
}
