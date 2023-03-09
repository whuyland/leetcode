// https://leetcode.com/problems/regular-expression-matching/
public class RegularExpressionMatching {
    // recursive with memo, top down
    public boolean isMatch(String s, String p) {
        Boolean[][] memo = new Boolean[s.length() + 1][p.length() + 1];
        return isMatch(s, 0, p, 0, memo);
    }

    private boolean isMatch(String s, int sIndex, String p, int pIndex, Boolean[][] memo) {
        if (memo[sIndex][pIndex] != null) {
            return memo[sIndex][pIndex];
        }
        // System.out.println("sIndex = " + sIndex + ", pIndex = " + pIndex);
        int sLen = s.length();
        int pLen = p.length();
        if (sIndex == sLen && pIndex == pLen) {
            return true;
        }
        if (pIndex == pLen) {
            // never true if we use up pattern
            return false;
        }

        boolean isPrecedingMatch = sIndex < sLen && (p.charAt(pIndex) == '.' || p.charAt(pIndex) == s.charAt(sIndex));
        // we must consider "x*" as a combi
        boolean ret;
        if (pIndex + 1 < pLen && p.charAt(pIndex + 1) == '*') {
            if (isPrecedingMatch) {
                ret = isMatch(s, sIndex + 1, p, pIndex, memo) // use this combi later
                        || isMatch(s, sIndex, p, pIndex + 2, memo); // we just ignore it
            } else {
                // ignore the combi
                ret = isMatch(s, sIndex, p, pIndex + 2, memo);
            }
        } else {
            ret = isPrecedingMatch && isMatch(s, sIndex + 1, p, pIndex + 1, memo);
        }
        memo[sIndex][pIndex] = ret;
        return ret;
    }

    // dp, bottom up
    public boolean isMatchI(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        // s[0, sIndex) and p[0, pIndex)
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true;

        // use i for index in string s, j for p
        // use them as index directly, but store dp result in dp[i + 1][j + 1] for the base case dp[0][0]
        // it's impossible to match s with any positve length with patter with zero length
        for (int i = 1; i <= sLen; ++i) {
            dp[i][0] = false;
        }
        // only the pattern like 'x*x*x' can match zero length string with non-empty pattern
        for (int j = 0; j < pLen; ++j) {
            if (p.charAt(j) == '*') {
                dp[0][j + 1] = dp[0][j + 1 - 2];
            } else {
                dp[0][j + 1] = false;
            }
        }

        for (int i = 0; i < sLen; ++i) {
            for (int j = 0; j < pLen; ++j) {
                if (p.charAt(j) == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                } else if (p.charAt(j) == '*') {
                    dp[i + 1][j + 1] = dp[i + 1][(j + 1) - 2] // ignore the character-star combi
                            // use '*' one more time and compare s[i] with p[j - 1];
                            || (dp[(i + 1) - 1][j + 1] && isSameChar(s, i, p, j - 1))
                            || dp[i + 1][(j + 1) - 1]; // like the '*' doesn`t exist
                } else {
                    dp[i + 1][j + 1] = dp[(i + 1) - 1][(j + 1) - 1] && isSameChar(s, i, p, j);
                }
            }
        }
        // printDP(dp);
        return dp[sLen][pLen];
    }

    private boolean isSameChar(String s, int sIndex, String p, int pIndex) {
        return p.charAt(pIndex) == s.charAt(sIndex) || p.charAt(pIndex) == '.';
    }

    private void printDP(boolean[][] dp) {
        for (int i = 0; i < dp.length; ++i) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < dp[i].length; ++j) {
                sb.append(dp[i][j] ? 1 : 0).append(' ');
            }
            System.out.println(sb.toString());
        }
    }
}
