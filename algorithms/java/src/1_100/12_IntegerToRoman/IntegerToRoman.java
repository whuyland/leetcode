// https://leetcode.com/problems/integer-to-roman/

public class IntegerToRoman {
    private static final String[][] table = new String[][]{{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
            {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
            {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
            {"", "M", "MM", "MMM"}};

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (num != 0) {
            sb.insert(0, table[index][num % 10]);
            ++index;
            num /= 10;
        }
        return sb.toString();
    }

    private static final int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] reps = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRomanI(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; ++i) {
            while (num >= values[i]) {
                sb.append(reps[i]);
                num -= values[i];
            }
        }
        return sb.toString();
    }
}
