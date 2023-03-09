// https://leetcode.com/problems/maximum-product-subarray/
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        Integer[] maxPositive = new Integer[n];
        Integer[] minNegative = new Integer[n];

        if (nums[0] > 0) {
            maxPositive[0] = nums[0];
        } else if (nums[0] < 0) {
            minNegative[0] = nums[0];
        }
        int max = nums[0];

        for (int i = 1; i < n; ++i) {
            if (nums[i] == 0) {
                max = Math.max(max, 0);
                continue;
            }

            int factor = maxPositive[i - 1] != null ? maxPositive[i - 1] : 1;
            if (nums[i] > 0) {
                maxPositive[i] = factor * nums[i];
                if (minNegative[i - 1] != null) {
                    minNegative[i] = minNegative[i - 1] * nums[i];
                }
            } else {
                minNegative[i] = factor * nums[i];
                if (minNegative[i - 1] != null) {
                    maxPositive[i] = minNegative[i - 1] * nums[i];
                }
            }

            if (maxPositive[i] != null) {
                max = Math.max(max, maxPositive[i]);
            }
        }
        return max;
    }
}
