import java.util.Arrays;

// https://leetcode.com/problems/merge-intervals/
public class MergeIntervalsBruteForce {
    public int[][] merge(int[][] intervals) {
        int top = merge(intervals, intervals.length);
        return Arrays.copyOfRange(intervals, 0, top);
    }

    public int merge(int[][] intervals, int top) {
        int pos = 1;
        for (int i = 1; i < top; ++i) {
            boolean overlap = false;
            for (int j = 0; j < pos; ++j) {
                if (isOverlap(intervals[i], intervals[j])) {
                    intervals[j][0] = Math.min(intervals[i][0], intervals[j][0]);
                    intervals[j][1] = Math.max(intervals[i][1], intervals[j][1]);
                    overlap = true;
                    break;
                }
            }
            if (!overlap) {
                if (pos != i) {
                    intervals[pos][0] = intervals[i][0];
                    intervals[pos][1] = intervals[i][1];
                }
                ++pos;
            }
        }
        return pos == top ? top : merge(intervals, pos);
    }

    private boolean isOverlap(int[] a, int[] b) {
        return b[0] <= a[1] && b[1] >= a[0];
    }
}
