// https://leetcode.com/problems/string-to-integer-atoi
public class StringToInteger {
    public int myAtoi(String s) {
        int i = 0;
        int len = s.length();
        while (i < len && s.charAt(i) == ' ') {
            ++i;
        }
        if (i == len) {
            return 0;
        }
        boolean negative = false;
        if (s.charAt(i) == '-') {
            negative = true;
            ++i;
        } else if (s.charAt(i) == '+') {
            ++i;
        }
        int sum = 0;
        while (i < len && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            int num = s.charAt(i) - '0';
            // newSum = sum * 10 + num <= MAX --> sum <= (MAX - num) / 10 is the condition to keep scanning
            // the negative case is contained in the positive case, abs(MIN) - abs(MAX) = 1
            // if sum overflows, the negative will also overflow to MIN
            if (sum > (Integer.MAX_VALUE - num) / 10) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            sum = sum * 10 + num;
            ++i;
        }
        return negative ? -sum : sum;
    }

    public int myAtoiI(String s) {
        System.out.println(Integer.MAX_VALUE);
        int current = trimLeft(s);
        if (current >= s.length()) {
            return 0;
        }
        boolean negative = false;
        if (s.charAt(current) == '+') {
            ++current;
        } else if (s.charAt(current) == '-') {
            negative = true;
            ++current;
        }
        // return negative ? negativeCase(s, current) : positiveCase(s, current);
        int asNegative = negativeCase(s, current);
        if (negative) return asNegative;
        if (asNegative == Integer.MIN_VALUE || asNegative == Integer.MIN_VALUE + 1) {
            return Integer.MAX_VALUE;
        }
        return -asNegative;
    }

    // use negative case with larger range
    private int negativeCase(String s, int current) {
        int sum = 0;
        while (current < s.length() && s.charAt(current) >= '0' && s.charAt(current) <= '9') {
            int num = s.charAt(current) - '0';
            // newSum = sum * 10 - num > MIN -> sum > (MIN + num) / 10
            if (sum >= (Integer.MIN_VALUE + num) / 10) {
                sum = sum * 10 - num;
            } else {
                return Integer.MIN_VALUE;
            }
            ++current;
        }
        return sum;
    }

    private int positiveCase(String s, int current) {
        int sum = 0;
        while (current < s.length() && s.charAt(current) >= '0' && s.charAt(current) <= '9') {
            int num = s.charAt(current) - '0';
            // newSum = sum * 10 + num < MAX -> sum < (MAX - num) / 10
            if (sum <= (Integer.MAX_VALUE - num) / 10) {
                sum = sum * 10 + num;
            } else {
                return Integer.MAX_VALUE;
            }
            ++current;
        }
        return sum;
    }

    private int trimLeft(String s) {
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) != ' ') {
                return i;
            }
        }
        return 0;
    }
}
