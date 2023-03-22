// https://leetcode.com/problems/sum-of-two-integers/
public class SumOfTwoIntegers {
    // https://leetcode.com/problems/sum-of-two-integers/solutions/132479/simple-explanation-on-how-to-arrive-at-the-solution/
    // half adder: sum = a ^ b, carry = a & b
    public int getSum(int a, int b) {
        int c = 0;
        // calculate all bits in every step
        while (b != 0) {
            c = a & b; // c is the carry result for every bit
            a = a ^ b; // result of sum for every bit
            b = c << 1; // carry should right shift and be added to the result in next step
        }
        return a;
    }
}
