// https://leetcode.com/problems/distinct-subsequences/
public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen < tLen) {
            return 0;
        }

        // dp[i][j]: numDistince of s[0...i) matches t[0...j)
        int[] dp = new int[tLen + 1];

        // to match empty string, we can always remove all character in s
        dp[0] = 1;

        for (int i = 0; i < sLen; ++i) {
            int prev = dp[0];
            for (int j = 0; j < tLen; ++j) {
                int tmp = dp[j + 1];
                // we can always omit s[i]
                if (s.charAt(i) == t.charAt(j)) {
                    // s[0...i) and t[0...j) can also contribute
                    dp[j + 1] += prev;
                }
                prev = tmp;
            }
        }
        return dp[tLen];
    }
}
