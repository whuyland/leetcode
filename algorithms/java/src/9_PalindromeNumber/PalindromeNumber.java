import java.util.LinkedList;

// https://leetcode.com/problems/palindrome-number
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int base = 1;
        int rightHalf = 0;

        while (base <= x) {
            rightHalf = rightHalf * 10 + x % 10;
            base *= 10;
            x /= 10;
        }
        // System.out.println("l = " + x + ", r = " + rightHalf + ", base = " + base);
        return x == rightHalf || rightHalf / 10 == x;
    }

    // Solution seems wrong with second thought about overflow,
    // e.g. reverse of 2147483647 cannot be expressed in int.
    // But the reverse calculation will finally bring the reverse to
    // a negative value, which is -1126087180 and is never same with origin.
    public boolean isPalindromeII(int x) {
        if (x < 0) {
            return false;
        }
        int origin = x;
        int reverse = 0;
        while (x != 0) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        return origin == reverse;
    }

    public boolean isPalindromeI(int x) {
        if (x < 0) {
            return false;
        }

        LinkedList<Integer> list = new LinkedList<>();
        while (x != 0) {
            list.add(x % 10);
            x /= 10;
        }
        while (list.size() >= 2) {
            int first = list.removeFirst();
            int last = list.removeLast();
            if (first != last) {
                return false;
            }
        }
        return true;

    }
}
