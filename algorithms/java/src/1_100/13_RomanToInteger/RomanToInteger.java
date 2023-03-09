import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/roman-to-integer/
public class RomanToInteger {
    private static final Map<Character, Integer> table = new HashMap<>();

    static {
        table.put('I', 1);
        table.put('V', 5);
        table.put('X', 10);
        table.put('L', 50);
        table.put('C', 100);
        table.put('D', 500);
        table.put('M', 1000);
    }

    // elegant
    public int romanToInt(String s) {
        int n = s.length();
        int ret = 0;
        for (int i = 0; i < n - 1; ++i) {
            int current = table.get(s.charAt(i));
            int next = table.get(s.charAt(i + 1));
            // Only char represents 1xx can be placed before 5xx or 10xx,
            // and in this case, it will be subtracted from the later value
            if (current < next) {
                ret -= current;
            } else {
                ret += current;
            }
        }
        return ret + table.get(s.charAt(n - 1));
    }

    public int romanToIntI(String s) {
        int i = 0;
        int n = s.length();
        int ret = 0;
        while (i < n) {
            if (s.charAt(i) == 'I') {
                if (i + 1 < n && s.charAt(i + 1) == 'X') {
                    ret += 9;
                    i += 2;
                } else if (i + 1 < n && s.charAt(i + 1) == 'V') {
                    ret += 4;
                    i += 2;
                } else {
                    ret += 1;
                    ++i;
                }
            } else if (s.charAt(i) == 'X') {
                if (i + 1 < n && s.charAt(i + 1) == 'C') {
                    ret += 90;
                    i += 2;
                } else if (i + 1 < n && s.charAt(i + 1) == 'L') {
                    ret += 40;
                    i += 2;
                } else {
                    ret += 10;
                    ++i;
                }
            } else if (s.charAt(i) == 'C') {
                if (i + 1 < n && s.charAt(i + 1) == 'M') {
                    ret += 900;
                    i += 2;
                } else if (i + 1 < n && s.charAt(i + 1) == 'D') {
                    ret += 400;
                    i += 2;
                } else {
                    ret += 100;
                    ++i;
                }
            } else if (s.charAt(i) == 'M') {
                ret += 1000;
                ++i;
            } else if (s.charAt(i) == 'V') {
                ret += 5;
                ++i;
            } else if (s.charAt(i) == 'L') {
                ret += 50;
                ++i;
            } else if (s.charAt(i) == 'D') {
                ret += 500;
                ++i;
            }
        }
        return ret;
    }
}
