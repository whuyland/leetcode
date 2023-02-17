import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/insert-interval/
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> list = new LinkedList<>();
        int i = 0; // non-overlap index
        while (i < n && intervals[i][0] < newInterval[0] && !isOverlap(intervals[i], newInterval)) {
            list.add(intervals[i++]);
        }
        while (i < n && isOverlap(intervals[i], newInterval)) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            ++i;
        }
        list.add(newInterval);
        while (i < n) {
            list.add(intervals[i++]);
        }
        return list.toArray(new int[list.size()][2]);
    }

    private boolean isOverlap(int[] a, int[] b) {
        return b[1] >= a[0] && b[0] <= a[1];
    }
}
