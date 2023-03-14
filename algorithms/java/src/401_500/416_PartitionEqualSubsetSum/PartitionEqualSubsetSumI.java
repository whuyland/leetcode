// https://leetcode.com/problems/partition-equal-subset-sum/
public class PartitionEqualSubsetSumI {
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
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int j = sum; j >= 0; --j) {
                if (j - num >= 0) {
                    dp[j] = dp[j] || dp[j - num];
                }
            }
        }
        return dp[sum];
    }
}
