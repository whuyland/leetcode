import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/4sum-ii/
public class FourSumIISolutionI {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> left = twoSum(nums1, nums2);
        Map<Integer, Integer> right = twoSum(nums3, nums4);
        int cnt = 0;
        for (Map.Entry<Integer, Integer> kv : left.entrySet()) {
            cnt += kv.getValue() * right.getOrDefault(-kv.getKey(), 0);
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
