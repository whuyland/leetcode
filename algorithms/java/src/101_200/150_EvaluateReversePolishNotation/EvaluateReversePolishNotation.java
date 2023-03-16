import java.util.Stack;

// https://leetcode.com/problems/evaluate-reverse-polish-notation/
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> seen = new Stack<>();
        for (String s : tokens) {
            if ("+".equals(s)) {
                seen.add(seen.pop() + seen.pop());
            } else if ("-".equals(s)) {
                int r = seen.pop();
                int l = seen.pop();
                seen.add(l - r);
            } else if ("*".equals(s)) {
                seen.add(seen.pop() * seen.pop());
            } else if ("/".equals(s)) {
                int r = seen.pop();
                int l = seen.pop();
                seen.add(l / r);
            } else {
                seen.add(Integer.parseInt(s));
            }
        }
        return seen.pop();
    }
}
