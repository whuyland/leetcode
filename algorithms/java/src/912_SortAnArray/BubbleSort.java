// https://leetcode.com/problems/sort-an-array/
public class BubbleSort {
    public int[] sortArray(int[] nums) {
        for (int end = nums.length - 1; end > 0; --end) {
            for (int i = 0; i < end; ++i) {
                if (nums[i] > nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            }
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
