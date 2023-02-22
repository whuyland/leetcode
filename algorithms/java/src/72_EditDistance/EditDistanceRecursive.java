import java.util.Arrays;

// https://leetcode.com/problems/edit-distance/
public class EditDistanceRecursive {
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0) {
            return word2.length();
        }
        if (word2.length() == 0) {
            return word1.length();
        }
        int[][] memo = new int[word1.length()][word2.length()];
        solve(word1, 0, word2, 0, memo);
        return memo[0][0];
    }

    private int solve(String word1, int i, String word2, int j, int[][] memo) {
        int m = word1.length();
        int n = word2.length();
        if (i == m && j == n) {
            return 0;
        }
        if (i == m) {
            // we just add all left
            return n - j;
        }
        if (j == n) {
            // we delete all left
            return m - i;
        }
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        int ret;
        if (word1.charAt(i) == word2.charAt(j)) {
            // greedy
            ret = solve(word1, i + 1, word2, j + 1, memo);
        } else {
            // add or delete
            ret = Math.min(solve(word1, i + 1, word2, j, memo), solve(word1, i, word2, j + 1, memo));
            // replace
            ret = Math.min(ret, solve(word1, i + 1, word2, j + 1, memo)) + 1;
        }
        memo[i][j] = ret;
        return ret;
    }
}
