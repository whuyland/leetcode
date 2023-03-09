import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/palindrome-partitioning/
public class PalindromePartitioningI {
    public List<List<String>> partition(String s) {
        List<List<String>> ret = new LinkedList<>();
        solve(s, 0, ret, new LinkedList<>());
        return ret;
    }

    private void solve(String s, int startIndex, List<List<String>> ret, LinkedList<String> current) {
        if (startIndex == s.length()) {
            ret.add(new LinkedList<>(current));
            return;
        }
        for (int endIndex = startIndex + 1; endIndex <= s.length(); ++endIndex) {
            if (isValid(s, startIndex, endIndex)) {
                current.add(s.substring(startIndex, endIndex));
                solve(s, endIndex, ret, current);
                current.removeLast();
            }
        }
    }

    private boolean isValid(String s, int left, int right) {
        --right;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }
}
