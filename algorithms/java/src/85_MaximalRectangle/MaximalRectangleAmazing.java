import java.util.Arrays;

// https://leetcode.com/problems/maximal-rectangle/
public class MaximalRectangleAmazing {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix[0].length;
        int[] heights = new int[n]; // heights in current row
        int[] left = new int[n]; // left[i] ... i are all elements with height >= heights[i]
        int[] right = new int[n]; // i ... right[i] are all elements with height >= heights[i]
        Arrays.fill(right, n - 1);
        int ret = 0;
        for (char[] chars : matrix) {
            for (int j = 0; j < n; ++j) {
                if (chars[j] == '1') {
                    ++heights[j];
                } else {
                    heights[j] = 0;
                }
            }

            int leftBar = 0;
            for (int j = 0; j < n; ++j) {
                if (chars[j] == '1') {
                    left[j] = Math.max(leftBar, left[j]);
                } else {
                    left[j] = 0;
                    leftBar = j + 1;
                }
            }
            int rightBar = n - 1;
            for (int j = n - 1; j >= 0; --j) {
                if (chars[j] == '1') {
                    right[j] = Math.min(rightBar, right[j]);
                } else {
                    right[j] = n - 1;
                    rightBar = j - 1;
                }
            }
            for (int j = 0; j < n; ++j) {
                ret = Math.max(ret, heights[j] * (right[j] - left[j] + 1));
            }
        }
        return ret;
    }
}
