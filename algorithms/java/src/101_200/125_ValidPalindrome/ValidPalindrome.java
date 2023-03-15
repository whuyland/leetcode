// https://leetcode.com/problems/valid-palindrome/
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (getLetter(s.charAt(l)) == null) {
                ++l;
            } else if (getLetter(s.charAt(r)) == null) {
                --r;
            } else if (getLetter(s.charAt(l)) == getLetter(s.charAt(r))) {
                ++l;
                --r;
            } else {
                return false;
            }
        }
        return true;
    }

    private Character getLetter(char c) {
        if (c >= 'a' && c <= 'z') {
            return c;
        }

        if (c >= 'A' && c <= 'Z') {
            return (char) (c - 'A' + 'a');
        }

        if (c >= '0' && c <= '9') {
            return c;
        }

        return null;
    }
}
