// https://leetcode.com/problems/edit-distance/
public class EditDistanceDP {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1]; // dp[i][j] means how many operations to match word1[0...i) and word2[0...j)
        for (int i = 1; i <= m; ++i) {
            // to match empty word2, in every step we have to delete one char in word1
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; ++j) {
            // add one char in every step
            dp[0][j] = j;
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                // greedy if char matches
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    // (replace or match, delete)
                    dp[i + 1][j + 1] = Math.min(dp[i][j] + 1, dp[i][j + 1] + 1);
                    // add
                    dp[i + 1][j + 1] = Math.min(dp[i + 1][j] + 1, dp[i + 1][j + 1]);
                }
            }
        }
        return dp[m][n];
    }
}
