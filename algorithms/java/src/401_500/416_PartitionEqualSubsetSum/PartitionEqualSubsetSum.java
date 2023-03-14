// https://leetcode.com/problems/partition-equal-subset-sum/
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 == 1) {
            return false;
        }
        sum /= 2;
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        dp[0][0] = true;

        for (int i = 0; i < n; ++i) {
            int num = nums[i];
            for (int j = 0; j <= sum; ++j) {
                if (dp[i][j]) {
                    dp[i + 1][j] = true;
                } else if (j >= num && dp[i][j - num]) {
                    dp[i + 1][j] = true;
                }
            }
        }
        return dp[n][sum];
    }
}
