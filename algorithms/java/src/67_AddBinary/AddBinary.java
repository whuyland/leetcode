// https://leetcode.com/problems/add-binary/
public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        int carry = 0;
        while (aIndex >= 0 || bIndex >= 0) {
            int sum = carry + (aIndex >= 0 ? value(a, aIndex--) : 0) + (bIndex >= 0 ? value(b, bIndex--) : 0);
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry == 1) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    private int value(String s, int i) {
        return s.charAt(i) - '0';
    }
}
