// https://leetcode.com/problems/missing-number/
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        int n = nums.length;
        return (n + 1) * n / 2 - sum;
    }
}
