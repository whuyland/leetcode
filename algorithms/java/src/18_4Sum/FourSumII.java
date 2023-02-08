// https://leetcode.com/problems/4sum/

import java.util.*;

// recursive kSum with bucket counting
public class FourSumII {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        return kSum(nums, target, 4);
    }

    private List<List<Integer>> kSum(int[] nums, int target, int k) {
        Arrays.sort(nums);
        Set<Integer> dict = new HashSet<>();
        for (int i : nums) {
            dict.add(i);
        }
        int n = dict.size();
        int[] vals = new int[n];
        int[] freqs = new int[n];
        int ind = 0;
        vals[ind] = nums[0];
        freqs[ind] = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (vals[ind] != nums[i]) {
                ++ind;
                vals[ind] = nums[i];
            }
            ++freqs[ind];
        }

        return kSum(vals, freqs, dict, 0, target, k);
    }

    // in the middle of calculation, it can be that target is out of range of int
    private List<List<Integer>> kSum(int[] vals, int[] freqs, Set<Integer> dict, int start, long target, int k) {
        List<List<Integer>> ret = new LinkedList<>();

        long avg = target / k; // with vals[x] * k, it can overflow
        if (start >= vals.length || avg > vals[vals.length - 1] || avg + 1 < vals[start]) { // avg is ceil
            // early stop condition r.s.t side elements
            // if how many elements left are kept, the condition start > vals.length can be further specified
            return ret;
        }


        if (k == 2) {
            for (int i = start; i < vals.length; ++i) {
                long remain = target - vals[i];
                if (remain < vals[i]) {
                    // we collect elements in ascending order,
                    // so the last element must be greater than vals[i],
                    // and from i on, remain will only be smaller
                    break;
                }
                if (remain > Integer.MAX_VALUE) {
                    // vals[i] is too small, keep scanning
                    continue;
                }
                // remain can be safely converted back to int
                if (dict.contains((int) remain) && (remain != vals[i] || freqs[i] > 1)) {
                    ret.add(new LinkedList<>(Arrays.asList((int) remain, vals[i])));
                }
            }
        } else {
            for (int i = start; i < vals.length; ++i) {
                --freqs[i];
                List<List<Integer>> sub = kSum(vals, freqs, dict, freqs[i] > 0 ? i : i + 1, target - vals[i], k - 1);
                for (List<Integer> ans : sub) {
                    ans.add(vals[i]);
                    ret.add(ans);
                }
                ++freqs[i];
            }
        }
        return ret;
    }
}
