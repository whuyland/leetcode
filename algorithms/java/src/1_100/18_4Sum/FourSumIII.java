// https://leetcode.com/problems/4sum/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FourSumIII {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, 0, target, 4);
    }

    private List<List<Integer>> kSum(int[] nums, int start, long target, int k) {
        List<List<Integer>> ret = new LinkedList<>();
        long avg = target / k;
        int n = nums.length;
        if (start > n - k || avg > nums[n - 1] || avg + 1 < nums[start]) {
            return ret;
        }

        if (k == 2) {
            return twoSum(nums, start, target);
        }

        for (int i = start; i < n; ++i) {
            if (i != start && nums[i] == nums[i - 1]) {
                // for the kth elements, if there are duplicate values v in [a, b],
                // we just search answer with the first v at pos a,
                // because the case kth take v in (a, b] is contained in this case
                continue;
            }
            List<List<Integer>> subset = kSum(nums, i + 1, target - nums[i], k - 1);
            for (List<Integer> ans : subset) {
                ans.add(nums[i]);
                ret.add(ans);
            }
        }
        return ret;
    }

    private List<List<Integer>> twoSum(int[] nums, int start, long target) {
        int lo = start;
        int hi = nums.length - 1;
        List<List<Integer>> ret = new LinkedList<>();
        while (lo < hi) {
            long sum = nums[lo] + nums[hi];

            if (sum < target || (lo != start && nums[lo] == nums[lo - 1])) {
                ++lo;
            } else if (sum > target || (hi != nums.length - 1 && nums[hi] == nums[hi + 1])) {
                --hi;
            } else if (sum == target) {
                ret.add(new ArrayList<Integer>(Arrays.asList(nums[hi], nums[lo])));
                ++lo;
                --hi;
            }
        }
        return ret;
    }
}
