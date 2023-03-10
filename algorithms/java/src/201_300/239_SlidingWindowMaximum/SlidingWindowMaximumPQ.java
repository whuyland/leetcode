import java.util.PriorityQueue;

// https://leetcode.com/problems/sliding-window-maximum/
public class SlidingWindowMaximumPQ {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ret = new int[n - k + 1];
        PriorityQueue<int[]> seen = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int top = 0;
        for (int i = 0; i < n; ++i) {
            seen.add(new int[]{nums[i], i});
            if (i >= k - 1) {
                int leftBar = i - k;
                while (seen.peek()[1] <= leftBar) {
                    seen.poll();
                }
                ret[top++] = seen.peek()[0];
            }
        }
        return ret;
    }
}
