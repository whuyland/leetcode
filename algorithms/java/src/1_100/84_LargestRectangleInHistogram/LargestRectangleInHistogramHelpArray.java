import java.util.LinkedList;

// https://leetcode.com/problems/largest-rectangle-in-histogram/
public class LargestRectangleInHistogramHelpArray {
    // https://leetcode.com/problems/largest-rectangle-in-histogram/
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        // lessLeft[i] contains the most near index to i,
        // that heights[lessLeft[i]] < heights[i]
        int[] lessLeft = new int[n];
        lessLeft[0] = -1;
        for (int i = 1; i < n; ++i) {
            int pos = i - 1;
            while (pos >= 0 && heights[pos] >= heights[i]) {
                pos = lessLeft[pos];
            }
            lessLeft[i] = pos;
        }

        int[] lessRight = new int[n];
        lessRight[n - 1] = n;
        for (int i = n - 2; i >= 0; --i) {
            int pos = i + 1;
            while (pos < n && heights[pos] >= heights[i]) {
                pos = lessRight[pos];
            }
            lessRight[i] = pos;
        }
        // start from i with heights[i], we can increase area when height[l/r] >= heights[i]
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            max = Math.max(max, heights[i] * (lessRight[i] - lessLeft[i] - 1));
        }
        return max;
    }
}
