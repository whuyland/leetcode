// https://leetcode.com/problems/plus-one/
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        while (i >= 0 && digits[i] == 9) {
            digits[i] = 0;
            --i;
        }
        if (i < 0) {
            int[] ret = new int[digits.length + 1];
            ret[0] = 1;
            return ret;
        }
        ++digits[i];
        return digits;
    }
}
