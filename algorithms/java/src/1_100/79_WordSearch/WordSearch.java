// https://leetcode.com/problems/word-search/
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (solve(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean solve(char[][] board, int i, int j, String word, int pos) {
        if (pos == word.length()) {
            return true;
        }

        if (i >= board.length || j >= board[0].length || i < 0 || j < 0) {
            return false;
        }

        char c = board[i][j];
        if (c != word.charAt(pos) || c == '.') {
            return false;
        }
        board[i][j] = '.';

        boolean ret = solve(board, i, j + 1, word, pos + 1) || solve(board, i + 1, j, word, pos + 1)
                || solve(board, i - 1, j, word, pos + 1) || solve(board, i, j - 1, word, pos + 1);
        board[i][j] = c;
        return ret;
    }
}
