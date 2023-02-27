// https://leetcode.com/problems/interleaving-string/
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        if (s2.length() > s1.length()) {
            return isInterleave(s2, s1, s3);
        }
        int m = s1.length();
        int n = s2.length();

        boolean[] dp = new boolean[n + 1];
        for (int i = 0; i <= m; ++i) {
            for (int j = 0; j <= n; ++j) {
                if (i == 0 && j == 0) {
                    dp[j] = true;
                    continue;
                }
                dp[j] = (i > 0 && s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[j])
                        || (j > 0 && s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[j - 1]);
            }
        }
        return dp[n];
    }
}
