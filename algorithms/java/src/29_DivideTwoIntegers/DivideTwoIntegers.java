import java.util.LinkedList;

// https://leetcode.com/problems/divide-two-integers/
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }

        boolean negative = false;
        if (divisor > 0) {
            divisor = -divisor;
        } else {
            negative = !negative;
        }

        if (dividend > 0) {
            dividend = -dividend;
        } else {
            negative = !negative;
        }

        LinkedList<Integer> factors = new LinkedList<>();
        LinkedList<Integer> amounts = new LinkedList<>();
        int factor = 1;
        int amount = divisor;
        factors.add(factor);
        amounts.add(amount);

        while (amount >= dividend - amount) {
            factor += factor;
            amount += amount;
            factors.add(factor);
            amounts.add(amount);
        }
        ;

        int ret = 0;
        while (!amounts.isEmpty()) {
            factor = factors.removeLast();
            amount = amounts.removeLast();
            if (amount >= dividend) {
                dividend -= amount;
                ret += factor;
            }
        }
        return negative ? -ret : ret;
    }
}
