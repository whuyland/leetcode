// https://leetcode.com/problems/longest-common-subsequence/
public class LongestCommonSubsequenceI {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        if (m < n) {
            return longestCommonSubsequence(text2, text1);
        }

        int[] dp = new int[n + 1];
        for (int i = 0; i < m; ++i) {
            int prev = 0;
            for (int j = 0; j < n; ++j) {
                int cur = dp[j + 1];
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[j + 1] = prev + 1;
                } else {
                    dp[j + 1] = Math.max(dp[j], dp[j + 1]);
                }
                prev = cur;
            }
        }
        return dp[n];
    }
}
