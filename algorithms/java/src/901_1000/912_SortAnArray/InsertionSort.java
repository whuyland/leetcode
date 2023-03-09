// https://leetcode.com/problems/sort-an-array/
public class InsertionSort {
    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    private void sort(int[] nums, int lo, int hi) {
        for (int i = lo + 1; i <= hi; ++i) {
            int val = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > val) {
                nums[j + 1] = nums[j];
                --j;
            }
            nums[j + 1] = val;
        }
    }
}
