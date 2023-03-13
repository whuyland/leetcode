// https://leetcode.com/problems/find-the-duplicate-number/
public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int ret = 0;
        for (int num : nums) {
            num = Math.abs(num);
            if (nums[num] < 0) {
                ret = num;
                break;
            }
            nums[num] *= -1;
        }
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = Math.abs(nums[i]);
        }
        return ret;
    }
}
