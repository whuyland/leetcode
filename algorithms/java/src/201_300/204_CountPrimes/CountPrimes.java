// https://leetcode.com/problems/count-primes/
public class CountPrimes {
    public int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }
        int[] nums = new int[n];
        for (int i = 2; i < n; ++i) {
            if (nums[i] == 1) {
                continue;
            }
            int j = 2 * i;
            while (j < n) {
                nums[j] = 1;
                j += i;
            }
        }
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        return n - sum - 2;
    }
}
