import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/happy-number/
public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        do {
            seen.add(n);
            int sum = 0;
            while (n != 0) {
                int right = n % 10;
                sum += right * right;
                n /= 10;
            }
            n = sum;
        } while (!seen.contains(n));
        return n == 1;
    }
}
