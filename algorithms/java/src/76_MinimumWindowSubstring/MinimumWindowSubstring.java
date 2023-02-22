import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/minimum-window-substring/
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        Map<Character, Integer> target = new HashMap<>();
        for (char c : t.toCharArray()) {
            target.put(c, target.getOrDefault(c, 0) + 1);
        }
        int n = t.length();
        Map<Character, Integer> cnt = new HashMap<>();
        int retL = -1;
        int retR = -1;
        int left = 0;
        int usefulChar = 0;
        // we first move right, if we reach bar, we shrink left
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (!target.containsKey(c)) {
                if (usefulChar == 0) {
                    left = i + 1;
                }
                continue;
            }
            cnt.put(c, cnt.getOrDefault(c, 0) + 1);
            if (cnt.get(c) <= target.get(c)) {
                ++usefulChar;
            }

            while (usefulChar == n && left <= i) {
                // remember
                if (retL == -1 || retR - retL > i + 1 - left) {
                    retL = left;
                    retR = i + 1;
                }
                char first = s.charAt(left);
                if (cnt.containsKey(first)) {
                    cnt.put(first, cnt.get(first) - 1);
                    if (cnt.get(first) < target.get(first)) {
                        --usefulChar;
                    }
                }
                ++left;
            }
        }
        return retL == -1 ? "" : s.substring(retL, retR);
    }
}
