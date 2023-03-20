import java.util.Stack;

// https://leetcode.com/problems/basic-calculator-ii/
public class BasicCalculatorII {
    private int index = 0;

    public int calculate(String s) {
        Stack<Integer> nums = new Stack<>();
        int n = s.length();
        int num = 0;
        char op = '+';

        while (index < n) {
            char c = s.charAt(index);
            ++index;
            if (c == '(') {
                num = calculate(s);
            }
            if (c == ')') {
                break;
            }

            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            if (index == n || c == '+' || c == '-' || c == '*' || c == '/') {
                if (op == '+') {
                    nums.push(num);
                } else if (op == '-') {
                    nums.push(-num);
                } else if (op == '*') {
                    nums.push(nums.pop() * num);
                } else if (op == '/') {
                    nums.push(nums.pop() / num);
                }
                op = c;
                num = 0;
            }
        }

        int ret = 0;
        while (!nums.isEmpty()) {
            ret += nums.pop();
        }
        return ret;
    }
}
