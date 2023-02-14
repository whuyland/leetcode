import java.util.LinkedList;
import java.util.Stack;

// https://leetcode.com/problems/longest-valid-parentheses/
public class LongestValidParenthesesStackI {
    public int longestValidParentheses(String s) {
        Stack<Integer> seen = new Stack<>();
        seen.push(-1);
        // this stack stores the index of all left over elements,
        // starting with '-1' in it,
        // there only 3 pattern can be left in the stack:
        // 1. "-1(("
        // 2. ")(("
        // 3. ")"
        int max = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                seen.push(i);
            } else {
                seen.pop();
                if (seen.isEmpty()) {
                    seen.push(i);
                } else {
                    max = Math.max(max, i - seen.peek());
                }
            }
        }
        return max;
    }
}
