import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/merge-intervals/
public class MergeIntervalsArray {
    public int[][] merge(int[][] intervals) {
        int maxVal = 0;
        for (int i = 0; i < intervals.length; ++i) {
            maxVal = Math.max(maxVal, intervals[i][1]);
        }

        int[] array = new int[maxVal + 1];
        Arrays.fill(array, -1);
        for (int[] pair : intervals) {
            int group = array[pair[0]];
            if (group == -1) {
                group = pair[0];
            }
            int endIndex = pair[1] + 1;
            if (array[pair[1]] != -1) {
                while (endIndex < array.length && array[endIndex] == array[pair[1]]) {
                    ++endIndex;
                }
            }
            Arrays.fill(array, pair[0], endIndex, group);
        }
        int pos = 0;
        for (int i = 0; i < array.length; ++i) {
            if (array[i] == -1) {
                continue;
            }
            if (i == array.length - 1 || array[i] != array[i + 1]) {
                intervals[pos][0] = array[i];
                intervals[pos][1] = i;
                ++pos;
            }
        }
        return Arrays.copyOfRange(intervals, 0, pos);
    }
}
