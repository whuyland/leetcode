// https://leetcode.com/problems/move-zeroes/
public class MoveZones {
    public void moveZeroes(int[] nums) {
        int top = 0;
        for (int i : nums) {
            if (i != 0) {
                nums[top++] = i;
            }
        }
        while (top < nums.length) {
            nums[top++] = 0;
        }
    }
}
