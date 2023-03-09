// https://leetcode.com/problems/powx-n/
public class Pow {
    public double myPow(double x, int n) {
        if (n == 0 || Double.valueOf(1.0).equals(x)) {
            return 1;
        }
        if (n == Integer.MIN_VALUE) {
            return calculate(1 / x, -(n + 1)) / x;
        }
        return n > 0 ? calculate(x, n) : calculate(1 / x, -n);
    }

    private double calculate(double x, int n) {
        if (n == 1) {
            return x;
        }
        double half = calculate(x, n / 2);
        return half * half * (n % 2 == 1 ? x : 1);
    }
}
