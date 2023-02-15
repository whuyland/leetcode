// https://leetcode.com/problems/first-missing-positive/
public class FirstMissingPositive {
    // clearer
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int i = 0;
        // we set nums[i] to its correct position
        while (i < n) {
            int val = nums[i];
            // clear
            // if we have a valid value and its position is not valid value,
            // then we put the correct value there
            if (val > 0 && val <= n && nums[val - 1] != val) {
                swap(nums, i, val - 1);
            } else {
                ++i;
            }
        }
        for (i = 0; i < n; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public int firstMissingPositiveI(int[] nums) {
        int n = nums.length;
        int i = 0;
        // we set nums[i] to its correct position
        while (i < n) {
            int val = nums[i];
            if (val > n || val <= 0 || i == val - 1) {
                // if it is out of range [1, n] or it is in the right position,
                // we check next
                ++i;
                continue;
            }
            if (val - 1 < i) {
                // we swap a value that has already been checked, move to next
                swap(nums, val - 1, i);
                ++i;
            } else {
                // we swap a future element, we need to check this
                swap(nums, val - 1, i);
                if (nums[i] == val) {
                    // otherwise we will be stuck
                    ++i;
                }
            }
        }
        for (i = 0; i < n; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
