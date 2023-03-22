import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/intersection-of-two-arrays-ii/
public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) {
            // keep nums2 is small
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> dict = new HashMap<>();
        for (int i : nums2) {
            dict.put(i, dict.getOrDefault(i, 0) + 1);
        }
        List<Integer> ret = new ArrayList<>();
        for (int i : nums1) {
            if (dict.getOrDefault(i, 0) > 0) {
                ret.add(i);
            }
            dict.put(i, dict.getOrDefault(i, 0) - 1);
        }
        return ret.stream().mapToInt(i -> i).toArray();
    }
}
