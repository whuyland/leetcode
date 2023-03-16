// https://leetcode.com/problems/factorial-trailing-zeroes/
public class FactorialTrailingZeros {
    public int trailingZeroes(int n) {
        int base = 5;
        int ret = 0;
        while (base <= n) {
            ret += n / base;
            base *= 5;
        }
        return ret;
    }
}
