import java.util.Stack;

// https://leetcode.com/problems/min-stack/
public class MinStack {
    static class Pair {
        int val;
        int min;
        Pair next;

        Pair(int val, int min, Pair next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    private Pair head;

    public MinStack() {
        head = new Pair(Integer.MAX_VALUE, Integer.MAX_VALUE, null);
    }

    public void push(int val) {
        head = new Pair(val, Math.min(val, head.min), head);
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }
}
