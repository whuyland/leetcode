import java.util.Arrays;

// https://leetcode.com/problems/jump-game-ii/
public class JumpGameIIDP {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n - 1] = 0;
        for (int i = n - 2; i >= 0; --i) {
            int val = Integer.MAX_VALUE;
            for (int step = 1; step <= nums[i] && i + step < n; ++step) {
                val = Math.min(val, dp[i + step]);
            }
            if (val != Integer.MAX_VALUE) {
                dp[i] = val + 1;
            }
        }
        return dp[0];
    }
}
