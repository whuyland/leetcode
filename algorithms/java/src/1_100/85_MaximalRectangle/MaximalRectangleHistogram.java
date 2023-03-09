import java.util.Stack;

// https://leetcode.com/problems/maximal-rectangle/
public class MaximalRectangleHistogram {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] heights = new int[n + 1]; // add a zero as guard
        int ret = 0;
        for (char[] row : matrix) {
            for (int j = 0; j < n; ++j) {
                if (row[j] == '1') {
                    ++heights[j];
                } else {
                    heights[j] = 0;
                }
            }
            ret = Math.max(ret, solveHistogram(heights));
        }
        return ret;
    }

    private int solveHistogram(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.add(-1);
        int ret = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1 && heights[i] <= heights[stack.peek()]) {
                int top = stack.pop();
                ret = Math.max(heights[top] * (i - stack.peek() - 1), ret);
            }
            stack.push(i);
        }
        return ret;
    }
}
