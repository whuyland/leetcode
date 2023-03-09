import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/insert-interval/
public class InsertIntervalEfficient {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> list = new LinkedList<>();
        int i = 0; // non-overlap index

        // no way to overlap and absolutely before newInterval
        while (i < n && intervals[i][1] < newInterval[0]) {
            list.add(intervals[i++]);
        }
        // from now, all intervals satisfies intervals[x][1] >= newInterval[0], we just need to check start index
        while (i < n && intervals[i][0] <= newInterval[1]) {
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
}
