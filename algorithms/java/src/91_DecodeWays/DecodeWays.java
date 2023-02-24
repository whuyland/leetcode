import java.util.Arrays;

// https://leetcode.com/problems/decode-ways/
public class DecodeWays {
    public int numDecodings(String s) {
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return solve(s, 0, memo);
    }

    private int solve(String s, int i, int[] memo) {
        if (i == s.length()) {
            return 1;
        }
        if (memo[i] != -1) {
            return memo[i];
        }

        char c = s.charAt(i);
        int ret = 0;
        if (c > '0') {
            ret = solve(s, i + 1, memo);
            if (c <= '3' && i + 1 < s.length()) {
                int num = (c - '0') * 10 + s.charAt(i + 1) - '0';
                if (num <= 26) {
                    ret += solve(s, i + 2, memo);
                }
            }
        }
        memo[i] = ret;
        return ret;
    }
}
