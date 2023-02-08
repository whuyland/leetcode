// https://leetcode.com/problems/3sum-closest/description/

import java.util.Arrays;

public class ThreeSumClosest {
    // two pointer
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;

        int bestAbs = Integer.MAX_VALUE;
        int bestSum = 0;

        // https://leetcode.com/problems/3sum-closest/solutions/7883/c-solution-o-n-2-using-sort/
        // fix i and j at first two positions and k at last position
        // if sum is smaller than target, we increase j,
        // if sum is greater than target, we decrease k,
        // if sum is target, we reach early stop
        for (int i = 0; i <= n - 3; ++i) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < target || (j != i + 1 && nums[j] == nums[j - 1])) {
                    ++j;
                } else if (sum > target || (k != n - 1 && nums[k] == nums[k + 1])) {
                    --k;
                } else /* if (sum == target) */ {
                    return target;
                }
                int abs = Math.abs(sum - target);
                if (abs < bestAbs) {
                    bestAbs = abs;
                    bestSum = sum;
                }
            }
        }
        return bestSum;
    }

    // with binary search
    public int threeSumClosestI(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] container = new int[2];
        int bestSum = 0;
        int bestAbs = Integer.MAX_VALUE;

        for (int i = 0; i <= n - 3; ++i) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j <= n - 2; ++j) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                // bestK = target -nums[i] - nums[j] is the best we can find,
                // the lower bound is the first element k that is nums[k] >= bestK
                // if nums[k] == bestK, we get the answer,
                //  if nums[k] > bestK, we just need to calculate nums[k] and nums[k - 1]
                int index = lowerBound(nums, j + 1, target - nums[i] - nums[j]);
                // use array to remove duplicate
                container[0] = index - 1;
                container[1] = index;
                for (int k : container) {
                    if (k > j && k < n) {
                        int sum = nums[i] + nums[j] + nums[k];
                        if (sum == target) {
                            return sum;
                        }
                        int abs = Math.abs(sum - target);
                        if (abs < bestAbs) {
                            bestAbs = abs;
                            bestSum = sum;
                        }
                    }
                }
            }
        }
        return bestSum;
    }

    private int lowerBound(int[] nums, int start, int target) {
        int l = start;
        int r = nums.length;

        while (l < r) {
            int mid = (l + r) / 2;
            if (target <= nums[mid]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
