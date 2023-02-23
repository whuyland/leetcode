import java.util.LinkedList;

// https://leetcode.com/problems/largest-rectangle-in-histogram/
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        LinkedList<Integer> stack = new LinkedList<>();
        stack.add(-1);
        int max = Integer.MIN_VALUE;

        for (int i = 0; i <= n; ++i) {
            int curHeight = i == n ? 0 : heights[i]; // use as marker
            while (stack.size() > 1 && curHeight <= heights[stack.getLast()]) {
                int valIndex = stack.removeLast();
                max = Math.max(max, heights[valIndex] * (i - stack.getLast() - 1));
            }
            stack.add(i);
        }

        return max;
    }
}
