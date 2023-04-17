// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[] first = new int[n];
        // first[i] is the best we can do in day [0...i]
        int min = Integer.MAX_VALUE;
        int seenMax = 0;
        for (int i = 0; i < n; ++i) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                seenMax = Math.max(seenMax, prices[i] - min);
            }
            first[i] = seenMax;
        }

        int[] second = new int[n];
        // second[i] is the best we can do in day [i...n)
        int max = Integer.MIN_VALUE;
        seenMax = 0;
        for (int i = n - 1; i >= 0; --i) {
            if (prices[i] > max) {
                max = prices[i];
            } else {
                seenMax = Math.max(seenMax, max - prices[i]);
            }
            second[i] = seenMax;
        }

        int ret = first[n - 1]; // we can just do one transaction, and first[n - 1] == second[0];
        for (int i = 0; i < n - 1; ++i) {
            ret = Math.max(ret, first[i] + second[i + 1]);
        }
        return ret;
    }
}
