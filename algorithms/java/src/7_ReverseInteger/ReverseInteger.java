// https://leetcode.com/problems/reverse-integer
public class ReverseInteger {
    public int reverse(int x) {
        boolean negative = false;
        if (x < 0) {
            negative = true;
            x = -x;
        }

        int ret = 0;
        while (x != 0) {
            // ret * 10 + reminder > Integer.MAX_VALUE
            // (Integer.MAX_VALUE - reminder) / 10 <  ret
            int reminder = x % 10;
            if ((Integer.MAX_VALUE - reminder) / 10 < ret) {
                // in java, if the result of multiplication gets overflow,
                // the temp result will get type raised,
                // and use the lower bits as final result
                // x * y = (x * y) & 0xffffffff,
                // only the lower 32 bits will be reserved,
                // the sign will not be exactly negative
                return 0;
            }
            ret = ret * 10 + reminder;
            x /= 10;
        }
        return negative ? -ret : ret;
    }
}
