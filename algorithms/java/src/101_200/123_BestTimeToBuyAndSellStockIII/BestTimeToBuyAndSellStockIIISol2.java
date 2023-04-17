import java.util.Arrays;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
public class BestTimeToBuyAndSellStockIIISol2 {
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/discuss/135704/Detail-explanation-of-DP-solution
    public int maxProfit(int[] prices) {
        int k = 2;
        int[] dp = new int[k + 1];
        int[] min = new int[k + 1];
        Arrays.fill(min, prices[0]);
        for (int i = 1; i < prices.length; ++i) {
            for (int j = 1; j <= k; ++j) {
                min[j] = Math.min(min[j], prices[i] - dp[j - 1]);
                dp[j] = Math.max(dp[j], prices[i] - min[j]);
            }
        }
        return dp[k];
    }
}
