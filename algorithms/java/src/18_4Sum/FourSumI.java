// https://leetcode.com/problems/4sum/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

// First sort the array, and think about values in bucket.
// At every ith position, we take out one value from bucket, and bookkeep in freqs.
// If ith position, we use up this value, we must search the other (k - i) values from next bucket.
// And after the inner loop, we add that value back, and move ith position to next bucket.

// With this array, it's kind of more clear than why we compare lo with lo or hi with hi + 1 and skip duplicates.
public class FourSumI {
    public List<List<Integer>> fourSum(int[] nums, int target) {
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

        List<List<Integer>> ret = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            --freqs[i];
            for (int j = freqs[i] > 0 ? i : i + 1; j < n; ++j) {
                --freqs[j];
                for (int k = freqs[j] > 0 ? j : j + 1; k < n; ++k) {
                    Integer query = safeSub(safeSub(safeSub(target, vals[i]), vals[j]), vals[k]);
                    if (query == null) {
                        continue;
                    }
                    if (query < vals[k]) {
                        break;
                    }
                    --freqs[k];
                    if (dict.contains(query) && (query != vals[k] || freqs[k] > 0)) {
                        ret.add(new ArrayList<Integer>(
                                Arrays.asList(vals[i], vals[j], vals[k], query)));
                    }

                    ++freqs[k];
                }
                ++freqs[j];
            }
            ++freqs[i];
        }
        return ret;
    }

    private Integer safeSub(Integer i, Integer j) {
        if (i == null || j == null) {
            return null;
        }
        if (i > 0 && j < 0 && i > Integer.MAX_VALUE + j) {
            return null;
        }
        if (i < 0 && j > 0 && j + Integer.MIN_VALUE > i) {
            return null;
        }

        return i - j;
    }
}
