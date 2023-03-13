// https://leetcode.com/problems/longest-increasing-subsequence/
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] piles = new int[n]; // we keep an increasing number in piles, with index in [0, top)
        int top = 0;
        for (int val : nums) {
            int l = 0;
            int r = top;
            // we find the element that satisfy: piles[x] >= val, replace it with current val
            while (l < r) {
                int mid = (l + r) / 2;
                if (piles[mid] < val) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            // if it is the largest, we just extend the length of piles
            if (l == top) {
                ++top;
            }
            // remember it
            piles[l] = val;
        }
        return top;
    }
}
