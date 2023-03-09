// https://leetcode.com/problems/house-robber/
public class HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length;
        int robIt = 0;
        int skipIt = 0;
        for (int num : nums) {
            // if we skip the i-th house, the max profit we get is
            // the best we can do to the (i-1)-th house
            int newSkip = Math.max(robIt, skipIt);
            // if we rub the i-th house, we need skip (i-1)-th,
            // and from last step we know that last skipIt is the max of (i - 2)-th,
            // then we just add current value to that
            robIt = skipIt + num;
            skipIt = newSkip;
        }
        return Math.max(robIt, skipIt);
    }
}
