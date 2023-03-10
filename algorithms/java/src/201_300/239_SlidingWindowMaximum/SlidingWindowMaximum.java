import java.util.LinkedList;

// https://leetcode.com/problems/sliding-window-maximum/
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ret = new int[n - k + 1];
        LinkedList<Integer> seen = new LinkedList<>();
        int top = 0;
        for (int i = 0; i < n; ++i) {
            while (!seen.isEmpty() && seen.getLast() < nums[i]) {
                seen.removeLast();
            }
            seen.add(nums[i]);
            if (i >= k - 1) {
                ret[top++] = seen.getFirst();
                if (nums[i - k + 1] == seen.getFirst()) {
                    seen.removeFirst();
                }
            }
        }
        return ret;
    }
}
