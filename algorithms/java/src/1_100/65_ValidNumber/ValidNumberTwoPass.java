// https://leetcode.com/problems/valid-number/
public class ValidNumberTwoPass {
    public boolean isNumber(String s) {
        int n = s.length();
        int ePos = 0;
        while (ePos < n && s.charAt(ePos) != 'e' && s.charAt(ePos) != 'E') {
            ++ePos;
        }
        if (ePos == n) {
            return isDecimalOrInteger(s, 0, n);
        }
        return isDecimalOrInteger(s, 0, ePos) && isInteger(s, ePos + 1, n);
    }

    private boolean isDecimalOrInteger(String s, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return false;
        }
        if (s.charAt(startIndex) == '+' || s.charAt(startIndex) == '-') {
            ++startIndex;
        }
        int dotPos = startIndex;
        while (dotPos < endIndex && s.charAt(dotPos) != '.') {
            ++dotPos;
        }
        if (dotPos == startIndex) {
            return isDigits(s, dotPos + 1, endIndex);
        }
        if (dotPos == endIndex - 1 || dotPos == endIndex) {
            return isDigits(s, startIndex, dotPos);
        }
        return isDigits(s, startIndex, dotPos) && isDigits(s, dotPos + 1, endIndex);
    }

    private boolean isInteger(String s, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return false;
        }
        if (s.charAt(startIndex) == '+' || s.charAt(startIndex) == '-') {
            ++startIndex;
        }
        return isDigits(s, startIndex, endIndex);
    }

    private boolean isDigits(String s, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return false;
        }
        while (startIndex < endIndex) {
            if (s.charAt(startIndex) > '9' || s.charAt(startIndex) < '0') {
                return false;
            }
            ++startIndex;
        }
        return true;
    }
}
