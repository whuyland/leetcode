import java.util.Arrays;

// https://leetcode.com/problems/coin-change/
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 10001);
        dp[0] = 0;
        for (int n = 1; n <= amount; ++n) {
            for (int coin : coins) {
                if (n >= coin) {
                    dp[n] = Math.min(dp[n], dp[n - coin] + 1);
                }
            }
        }
        return dp[amount] == 10001 ? -1 : dp[amount];
    }
}
