import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/word-break-ii/
public class WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>();
        int minLen = Integer.MAX_VALUE;
        int maxLen = Integer.MIN_VALUE;
        for (String t : wordDict) {
            int len = t.length();
            minLen = Math.min(minLen, len);
            maxLen = Math.max(maxLen, len);
            dict.add(t);
        }
        List<String> ret = new LinkedList<>();
        traverse(s, 0, dict, ret, new StringBuilder(), minLen, maxLen);
        return ret;
    }

    private void traverse(String s, int index, Set<String> dict, List<String> ret, StringBuilder sb, int min, int max) {
        if (index == s.length()) {
            ret.add(sb.toString());
            return;
        }
        int currentLen = sb.length();
        boolean isFirst = true;
        if (currentLen != 0) {
            ++currentLen;
            sb.append(' ');
            isFirst = false;
        }
        for (int len = min; len <= max && index + len <= s.length(); ++len) {
            String sub = s.substring(index, index + len);
            if (dict.contains(sub)) {
                sb.append(sub);
                traverse(s, index + len, dict, ret, sb, min, max);
                sb.setLength(currentLen);
            }
        }
        sb.setLength(isFirst ? currentLen : currentLen - 1);
    }
}
