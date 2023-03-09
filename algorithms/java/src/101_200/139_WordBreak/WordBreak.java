import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/word-break/
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>();
        Boolean[] dp = new Boolean[s.length()];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (String word : wordDict) {
            min = Math.min(min, word.length());
            max = Math.max(max, word.length());
            dict.add(word);
        }
        return isValid(s, 0, dict, min, max, dp);
    }

    private boolean isValid(String s, int startIndex, Set<String> dict, int min, int max, Boolean[] dp) {
        if (startIndex == s.length()) {
            return true;
        }
        if (dp[startIndex] != null) {
            return dp[startIndex];
        }

        boolean ret = false;

        for (int len = min; len <= max && startIndex + len <= s.length(); ++len) {
            if (dict.contains(s.substring(startIndex, startIndex + len))) {
                if (isValid(s, startIndex + len, dict, min, max, dp)) {
                    ret = true;
                    break;
                }
            }
        }
        dp[startIndex] = ret;
        return ret;
    }
}
