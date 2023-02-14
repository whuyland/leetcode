// https://leetcode.com/problems/next-permutation/
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 1;
        while (i >= 1 && nums[i - 1] >= nums[i]) {
            --i;
        }
        if (i > 0) {
            int j = n - 1;
            while (nums[j] <= nums[i - 1]) {
                --j;
            }
            swap(nums, i - 1, j);

            reverse(nums, i, n - 1);
        } else {
            reverse(nums, 0, n - 1);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int from, int to) {
        int i = from;
        int j = to;
        while (i < j) {
            swap(nums, i, j);
            ++i;
            --j;
        }
    }
}
