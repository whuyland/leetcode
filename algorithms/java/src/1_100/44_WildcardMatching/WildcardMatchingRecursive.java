// https://leetcode.com/problems/wildcard-matching/
public class WildcardMatchingRecursive {
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        Boolean[][] dp = new Boolean[sLen + 1][pLen + 1];
        dp[sLen][pLen] = true;
        // dp[i][j] means if s[i...sLen) and p[j...pLen) is match
        return isMatch(s, 0, p, 0, dp);
    }

    private boolean isMatch(String s, int sIndex, String p, int pIndex, Boolean[][] dp) {
        if (sIndex > s.length() || pIndex > p.length()) {
            return false;
        }

        if (dp[sIndex][pIndex] != null) {
            return dp[sIndex][pIndex];
        }
        if (pIndex == p.length()) {
            dp[sIndex][pIndex] = false;
            return false;
        }

        boolean ret = false;
        if (sIndex == s.length()) {
            if (p.charAt(pIndex) == '*') {
                ret = isMatch(s, sIndex, p, pIndex + 1, dp);
            }
        } else if (p.charAt(pIndex) == '?' || p.charAt(pIndex) == s.charAt(sIndex)) {
            ret = isMatch(s, sIndex + 1, p, pIndex + 1, dp);
        } else if (p.charAt(pIndex) == '*') {
            for (int i = sIndex; i <= s.length(); ++i) {
                if (isMatch(s, i, p, pIndex + 1, dp)) {
                    ret = true;
                    break;
                }
            }
        }
        dp[sIndex][pIndex] = ret;
        return ret;
    }
}
