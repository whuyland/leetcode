import java.util.Stack;

// https://leetcode.com/problems/min-stack/
public class MinStackI {
    private final Stack<Integer> nums = new Stack<>();
    private final Stack<Integer> mins = new Stack<>();

    public MinStackI() {
    }

    public void push(int val) {
        nums.push(val);
        if (mins.isEmpty() || val <= mins.peek()) {
            mins.push(val);
        }
    }

    public void pop() {
        int removed = nums.pop();
        if (mins.peek() == removed) {
            mins.pop();
        }
    }

    public int top() {
        return nums.peek();
    }

    public int getMin() {
        return mins.peek();
    }
}
