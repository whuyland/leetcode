// https://leetcode.com/problems/two-sum/

import java.util.HashMap;
import java.util.Map;

class Solution {
    // two pass
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> store = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; ++i) {
            store.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; ++i) {
            Integer rest = store.get(target - nums[i]);
            if (rest != null && rest != i) {
                return new int[]{i, rest};
            }
        }
        return null;
    }

    // one pass
    public int[] twoSumII(int[] nums, int target) {
        Map<Integer, Integer> store = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; ++i) {
            Integer rest = store.get(target - nums[i]);
            if (rest != null) {
                return new int[]{i, rest};
            }
            store.put(nums[i], i);
        }
        return null;
    }
}
