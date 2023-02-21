import java.util.Arrays;

// https://leetcode.com/problems/next-permutation/
public class NextPermutationI {
    public void nextPermutation(int[] nums) {
        for (int i = 2; i <= nums.length; ++i) {
            if (nextPermutation(nums, i)) {
                return;
            }
        }
        Arrays.sort(nums);
    }

    private boolean nextPermutation(int[] nums, int k) {
        int n = nums.length;
        int first = n - k;
        int minMax = -1;

        for (int i = first + 1; i < n; ++i) {
            if (nums[i] > nums[first]) {
                if (minMax == -1 || nums[i] < nums[minMax]) {
                    minMax = i;
                }
            }
        }
        if (minMax == -1) {
            return false;
        }
        swap(nums, first, minMax);
        Arrays.sort(nums, first + 1, n);
        return true;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
