import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/4sum-ii/
public class FourSumII {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> right = twoSum(nums3, nums4);
        int cnt = 0;
        for (int i : nums1) {
            for (int j : nums2) {
                cnt += right.getOrDefault(-i - j, 0);
            }
        }

        return cnt;
    }

    private Map<Integer, Integer> twoSum(int[] nums1, int[] nums2) {
        Map<Integer, Integer> freqs = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                int sum = i + j;
                freqs.put(sum, freqs.getOrDefault(sum, 0) + 1);
            }
        }
        return freqs;
    }
}
