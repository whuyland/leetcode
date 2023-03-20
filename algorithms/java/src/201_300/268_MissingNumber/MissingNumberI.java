// https://leetcode.com/problems/missing-number/
public class MissingNumberI {
    public int missingNumber(int[] nums) {
        int ret = nums.length;
        for (int i = 0; i < nums.length; ++i) {
            ret ^= i ^ nums[i];
        }
        return ret;
    }
}
