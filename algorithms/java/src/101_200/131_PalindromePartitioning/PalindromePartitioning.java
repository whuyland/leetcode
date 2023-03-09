import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/palindrome-partitioning/
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        List<List<String>> ret = new LinkedList<>();
        solve(s, 0, ret, new LinkedList<>(), dp);
        return ret;
    }

    private void solve(String s, int startIndex, List<List<String>> ret, LinkedList<String> current, boolean[][] dp) {
        if (startIndex == s.length()) {
            ret.add(new LinkedList<>(current));
            return;
        }
        for (int endIndex = startIndex; endIndex < s.length(); ++endIndex) {
            if (s.charAt(startIndex) == s.charAt(endIndex) && (endIndex - startIndex <= 2 || dp[startIndex + 1][endIndex - 1])) {
                dp[startIndex][endIndex] = true;
                current.add(s.substring(startIndex, endIndex + 1));
                solve(s, endIndex + 1, ret, current, dp);
                current.removeLast();
            }
        }
    }
}
