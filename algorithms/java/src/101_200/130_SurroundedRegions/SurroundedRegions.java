import java.util.LinkedList;

// https://leetcode.com/problems/surrounded-regions/
public class SurroundedRegions {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        if (m == 1 || n == 1) {
            return;
        }

        LinkedList<int[]> jobs = new LinkedList<>();
        for (int i : new int[]{0, m - 1}) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == 'O') {
                    jobs.add(new int[]{i, j});
                }
            }
        }
        for (int j : new int[]{0, n - 1}) {
            for (int i = 0; i < m; ++i) {
                if (board[i][j] == 'O') {
                    jobs.add(new int[]{i, j});
                }
            }
        }
        while (!jobs.isEmpty()) {
            int[] top = jobs.removeFirst();
            int i = top[0];
            int j = top[1];
            if (i >= 0 && i < m && j >= 0 && j < n && board[i][j] == 'O') {
                board[i][j] = '.';
                jobs.add(new int[]{i - 1, j});
                jobs.add(new int[]{i + 1, j});
                jobs.add(new int[]{i, j - 1});
                jobs.add(new int[]{i, j + 1});
            }
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == '.') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
