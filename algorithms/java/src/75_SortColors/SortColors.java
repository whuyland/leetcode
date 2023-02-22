// https://leetcode.com/problems/sort-colors/
public class SortColors {
    public void sortColors(int[] nums) {
        int n = nums.length;

        int zero = -1;
        int two = n;

        int i = 0;
        while (i < two) {
            if (nums[i] == 1) {
                ++i;
            } else if (nums[i] == 0) {
                ++zero;
                swap(nums, zero, i);
                ++i;
            } else if (nums[i] == 2) {
                --two;
                swap(nums, i, two);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
