import java.util.Stack;

// https://leetcode.com/problems/daily-temperatures/
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ret = new int[n];
        Stack<Integer> decrease = new Stack<>();
        for (int i = 0; i < n; ++i) {
            int cur = temperatures[i];
            while (!decrease.isEmpty() && cur > temperatures[decrease.peek()]) {
                int top = decrease.pop();
                ret[top] = i - top;
            }
            decrease.add(i);
        }
        return ret;
    }
}
