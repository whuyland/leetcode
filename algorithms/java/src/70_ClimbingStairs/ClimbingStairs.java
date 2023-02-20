// https://leetcode.com/problems/climbing-stairs/
public class ClimbingStairs {
    // Fibonacci
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int a = 1;
        int b = 1;
        while (--n > 0) {
            b = a + b;
            a = b - a;
        }
        return b;
    }
}
