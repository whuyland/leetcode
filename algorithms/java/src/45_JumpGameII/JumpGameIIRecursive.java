// https://leetcode.com/problems/jump-game-ii/
public class JumpGameIIRecursive {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            dp[i] = -1;
        }
        return jump(nums, 0, dp);
    }

    private int jump(int[] nums, int startIndex, int[] dp) {
        if (startIndex == nums.length - 1) {
            return 0;
        }
        if (dp[startIndex] != -1) {
            return dp[startIndex];
        }
        int value = Integer.MAX_VALUE;

        if (startIndex + nums[startIndex] >= nums.length - 1) {
            value = 1;
        } else if (nums[startIndex] == 0) {
            value = Integer.MAX_VALUE;
        } else {
            int min = Integer.MAX_VALUE;
            for (int i = 1; i <= nums[startIndex]; ++i) {
                min = Math.min(min, jump(nums, startIndex + i, dp));
            }
            if (min != Integer.MAX_VALUE) {
                value = min + 1;
            }
        }
        dp[startIndex] = value;
        return value;
    }
}
