// https://leetcode.com/problems/number-of-1-bits/
public class NumberOf1BitsI {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n & 1;
            n >>>= 1;
        }
        return sum;
    }
}
