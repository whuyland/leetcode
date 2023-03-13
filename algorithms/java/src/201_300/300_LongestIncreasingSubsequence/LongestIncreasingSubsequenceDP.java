// https://leetcode.com/problems/longest-increasing-subsequence/
public class LongestIncreasingSubsequenceDP {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] memo = new int[n];
        int max = 0;
        for (int i = 0; i < n; ++i) {
            memo[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    memo[i] = Math.max(memo[i], memo[j] + 1);
                }
            }
            max = Math.max(max, memo[i]);
        }
        return max;
    }
}
