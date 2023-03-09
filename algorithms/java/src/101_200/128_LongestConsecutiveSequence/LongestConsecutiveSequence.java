import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-consecutive-sequence/
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        // keep track of the range
        Map<Integer, Integer> asStart = new HashMap<>(); // start-end
        Map<Integer, Integer> asEnd = new HashMap<>(); // end-start

        int maxLen = 0;

        for (int i : nums) {
            if (asStart.containsKey(i) || asEnd.containsKey(i)) {
                continue;
            }
            Integer right = asStart.get(i + 1);
            Integer left = asEnd.get(i - 1);
            if (right != null) {
                asStart.remove(i + 1);
                asEnd.remove(right);
            }

            if (left != null) {
                asStart.remove(left, i - 1);
                asEnd.remove(i - 1, left);
            }
            if (right == null) {
                right = i;
            }
            if (left == null) {
                left = i;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            asStart.put(left, right);
            asEnd.put(right, left);
        }
        return maxLen;
    }
}
