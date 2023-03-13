import java.util.Arrays;

// https://leetcode.com/problems/coin-change/
public class CoinChangeI {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int n = 1; n <= amount; ++n) {
            for (int coin : coins) {
                if (n >= coin && dp[n - coin] != -1) {
                    if (dp[n] == -1 || dp[n - coin] + 1 < dp[n]) {
                        dp[n] = dp[n - coin] + 1;
                    }
                }
            }
        }
        return dp[amount];
    }
}
