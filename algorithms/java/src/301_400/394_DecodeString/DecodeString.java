// https://leetcode.com/problems/decode-string/
public class DecodeString {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        decode(s, 0, sb);
        return sb.toString();
    }

    private int decode(String s, int i, StringBuilder sb) {
        if (i >= s.length() || s.charAt(i) == ']') {
            return i;
        }

        int cnt = 0;
        while (isInt(s.charAt(i))) {
            cnt = 10 * cnt + toInt(s.charAt(i));
            ++i;
        }
        // repeat
        if (cnt != 0) {
            StringBuilder sub = new StringBuilder();
            i = decode(s, i + 1, sub);
            sb.append(sub.toString().repeat(Math.max(0, cnt)));
            return decode(s, i + 1, sb);
        }

        int r = i + 1;
        while (r < s.length() && isLetter(s.charAt(r))) {
            ++r;
        }
        sb.append(s, i, r);
        return decode(s, r, sb);
    }


    private int toInt(char c) {
        return c - '0';
    }

    private boolean isInt(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean isLetter(char c) {
        return c >= 'a' && c <= 'z';
    }
}
