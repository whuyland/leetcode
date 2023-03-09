import java.util.LinkedList;

// https://leetcode.com/problems/longest-valid-parentheses/
public class LongestValidParenthesesDP {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int[] dp = new int[n]; // dp[i] means length of the longest valid substring ending i

        int max = 0;
        for (int i = 1; i < n; ++i) {
            if (s.charAt(i) == '(') {
                // no valid substring ending with '('
                continue;
            }
            if (s.charAt(i - 1) == '(') {
                dp[i] = 2;
                if (i - 2 > 0) {
                    dp[i] += dp[i - 2];
                }
            } else /*(s.charAt(i-1) == ')')*/ {
                int target = i - dp[i - 1] - 1;
                if (target >= 0 && s.charAt(target) == '(') {
                    dp[i] = 2 + dp[i - 1];
                    if (target - 1 >= 0) {
                        dp[i] += dp[target - 1];
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
