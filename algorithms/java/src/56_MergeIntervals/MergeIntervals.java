import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/merge-intervals/
public class MergeIntervals {
    // one pass
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> ret = new LinkedList<>();
        int[] cur = intervals[0];
        for (int i = 1; i < intervals.length; ++i) {
            if (cur[1] >= intervals[i][0]) {
                cur[1] = Math.max(cur[1], intervals[i][1]);
            } else {
                ret.add(cur);
                cur = intervals[i];
            }
        }
        ret.add(cur);
        return ret.toArray(new int[ret.size()][]);
    }
}
