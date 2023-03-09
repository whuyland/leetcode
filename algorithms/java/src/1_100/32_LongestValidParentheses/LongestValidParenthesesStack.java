import java.util.LinkedList;

// https://leetcode.com/problems/longest-valid-parentheses/
public class LongestValidParenthesesStack {
    public int longestValidParentheses(String s) {
        LinkedList<Integer> seen = new LinkedList<>();
        // -1 for '('
        int max = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                seen.add(-1);
            } else {
                if (seen.isEmpty()) {
                    continue;
                } else {
                    int tmp = 0;
                    boolean close = false;
                    while (!seen.isEmpty()) {
                        int last = seen.removeLast();
                        if (last == -1) {
                            tmp += 2;
                            close = true;
                            break;
                        } else {
                            tmp += last;
                        }
                    }
                    max = Math.max(max, tmp);
                    if (close) {
                        seen.add(tmp);
                    } else {
                        seen.clear();
                    }
                }
            }
        }
        int tmp = 0;
        while (!seen.isEmpty()) {
            int last = seen.removeLast();
            if (last != -1) {
                tmp += last;
                max = Math.max(tmp, max);
            } else {
                tmp = 0;
            }
        }
        return max;
    }
}
