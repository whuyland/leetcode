// https://leetcode.com/problems/sum-of-two-integers/
public class SumOfTwoIntegersI {
    // half adder: sum = a ^ b, carry = a & b
    // full adder: fullSum = halfSum ^ carry, fullCarry = (halfSum & carry) | halfCarry
    public int getSum(int a, int b) {
        int ret = 0;
        int carry = 0;
        for (int i = 1; i != 0; i <<= 1) {
            int l = a & 1;
            int r = b & 1;
            a >>>= 1;
            b >>>= 1;
            int val = l ^ r ^ carry;
            if (val == 1) {
                ret |= i;
            }
            // carry = (l & r) | (l & carry) | (r & carry);
            carry = ((l ^ r) & carry) | (l & r);
        }
        return ret;
    }
}
