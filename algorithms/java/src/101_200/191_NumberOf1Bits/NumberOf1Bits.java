// https://leetcode.com/problems/number-of-1-bits/
public class NumberOf1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            ++sum;
            // this will clear the last bit that takes 1
            n = n & (n - 1);
        }
        return sum;
    }
}
