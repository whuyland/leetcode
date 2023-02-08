import java.util.*;

// https://leetcode.com/problems/3sum/
public class ThreeSum {
    // double pointer
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new LinkedList<>();
        int n = nums.length;
        for (int i = 0; i <= n - 3; ++i) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // two sum
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum < 0 || (l != i + 1 && nums[l] == nums[l - 1])) {
                    ++l;
                } else if (sum > 0 || (r != n - 1 && nums[r] == nums[r + 1])) {
                    --r;
                } else /* if (sum == 0) */ {
                    ret.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[l], nums[r])));
                    ++l;
                    --r;
                }
            }
        }
        return ret;
    }

    // with bucket
    public List<List<Integer>> threeSumI(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        Set<Integer> dict = new HashSet<>();
        for (int num : nums) {
            dict.add(num);
        }
        int[] vals = new int[n];
        int[] freqs = new int[n];
        int ind = 0;
        vals[ind] = nums[0];
        freqs[ind] = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (vals[ind] != nums[i]) {
                ++ind;
                vals[ind] = nums[i];
                System.out.println(vals[ind]);
            }
            ++freqs[ind];
        }

        List<List<Integer>> ret = new LinkedList<>();

        for (int i = 0; i < vals.length && vals[i] <= 0; ++i) {
            --freqs[i];
            for (int j = freqs[i] > 0 ? i : i + 1; j < vals.length; ++j) {
                int target = -vals[i] - vals[j];
                if (target < vals[j]) {
                    break;
                }
                if (dict.contains(target)) {
                    if (target != vals[j] || freqs[j] >= 2) {
                        ret.add(new ArrayList<Integer>(Arrays.asList(vals[i], vals[j], target)));
                    }
                }
            }
            ++freqs[i];
        }
        return ret;
    }
}
