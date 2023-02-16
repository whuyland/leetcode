// https://leetcode.com/problems/wildcard-matching/
public class WildcardMatchingIterative {
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();

        boolean[][] dp = new boolean[sLen + 1][pLen + 1]; // true if s[0...i) and p[0...j) matches
        dp[0][0] = true;

        for (int i = 0; i <= sLen; ++i) {
            for (int j = 1; j <= pLen; ++j) {
                if (i > 0 && (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1))) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    // if s[0...i) matches p[0...j-1), '*' can represent empty
                    dp[i][j] = dp[i][j - 1];
                    // if s[0...k] for k in [0...i-1) matches p[0...j)
                    // the chars in s[k + 1...i) can be matched with '*'
                    for (int k = 0; k < i; ++k) {
                        dp[i][j] = dp[i][j] || dp[k][j];
                    }
                }
            }
        }

        return dp[sLen][pLen];
    }
}
