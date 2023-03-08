import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/longest-consecutive-sequence/
public class LongestConsecutiveSequenceII {
    public int longestConsecutive(int[] nums) {
        Set<Integer> dict = new HashSet<>();
        for (int i : nums) {
            dict.add(i);
        }
        int maxLen = 0;
        for (int i : nums) {
            if (dict.contains(i - 1)) {
                continue;
            }
            int cur = 1;
            while (dict.contains(i + cur)) {
                ++cur;
            }
            maxLen = Math.max(maxLen, cur);
        }
        return maxLen;
    }
}
