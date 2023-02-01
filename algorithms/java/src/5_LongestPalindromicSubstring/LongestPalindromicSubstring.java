// https://leetcode.com/problems/longest-palindromic-substring

class LongestPalindromicSubstring {
    // use int[] directly
    public String longestPalindrome(String s) {
        // "abc" -> "a#b#c", we expand at every character including '#'
        // pos / 2 and (pos + 1) / 2 for pos in [0...2n)
        int[] ret = new int[]{0, 0, 0}; // l, r, len
        for (int i = 0; i < 2 * s.length(); ++i) {
            int[] val = expand(s, i);
            if (val[2] > ret[2]) {
                ret = val;
            }
        }
        return ret[2] == 0 ? null : s.substring(ret[0], ret[1]);
    }

    private int[] expand(String s, int pos) {
        int i = pos / 2;
        int j = (pos + 1) / 2;
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            --i;
            ++j;
        }
        return new int[]{i + 1, j, j - i - 1};
    }

    // with dp
    public String longestPalindromeIII(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        int[] ret = new int[]{0, 0};

        // base case: all single element have length 1
        for (int i = 0; i < n; ++i) {
            dp[i][i] = 1;
        }

        for (int i = n - 2; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                // dp is initialized with all zeros,
                // if the guard elements are not same, just ignore
                if (s.charAt(i) != s.charAt(j)) {
                    continue;
                }

                // use single loop for base case and normal dp procedure
                // dp[i][j] depends on dp[i + 1][j - 1] != 0 && s[i] == s[j]
                // and s[i + 1...j-1] should be valid substring;
                // the base case dp[i, i + 1] will refer to dp[i + 1, i]
                // which takes the initial 0, which can be savely added to
                if (i + 1 == j || dp[i + 1][j - 1] != 0) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                    if (dp[i][j] > ret[1] - ret[0] + 1) {
                        ret[0] = i;
                        ret[1] = j;
                    }
                }

            }
        }
        return s.substring(ret[0], ret[1] + 1);
    }

    // use Range to avoid string deep copy
    static class Range {
        int l;
        int r;
        int len;

        // [i...j)
        public Range(int i, int j) {
            l = i;
            r = j;
            len = j - i;
            if (len < 0) {
                len = 0;
            }
        }
    }

    public String longestPalindromeII(String s) {
        // "abc" -> "a#b#c", we expand at every character including '#'
        // pos / 2 and (pos + 1) / 2 for pos in [0...2n)
        Range ret = new Range(0, 0);
        for (int i = 0; i < 2 * s.length(); ++i) {
            Range val = expandII(s, i);
            if (val.len > ret.len) {
                ret = val;
            }
        }
        return ret.len == 0 ? null : s.substring(ret.l, ret.r);
    }

    private Range expandII(String s, int pos) {
        int i = pos / 2;
        int j = (pos + 1) / 2;
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            --i;
            ++j;
        }
        return new Range(i + 1, j);
    }

    public String longestPalindromeI(String s) {
        // "abc" -> "a#b#c", we expand at every character including '#'
        // pos / 2 and (pos + 1) / 2 for pos in [0...2n)
        String ret = null;
        for (int i = 0; i < 2 * s.length(); ++i) {
            String val = expandI(s, i);
            if (ret == null || val.length() > ret.length()) {
                ret = val;
            }
        }
        return ret;
    }

    private String expandI(String s, int pos) {
        int i = pos / 2;
        int j = (pos + 1) / 2;
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            --i;
            ++j;
        }
        if (j - i - 1 > 0) {
            // [i + 1, j)
            return s.substring(i + 1, j);
        }

        return "";
    }
}

