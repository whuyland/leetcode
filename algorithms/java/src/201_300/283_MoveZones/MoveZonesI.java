// https://leetcode.com/problems/move-zeroes/
public class MoveZonesI {
    public void moveZeroes(int[] nums) {
        int top = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                swap(nums, top, i);
                ++top;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
