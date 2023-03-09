// https://leetcode.com/problems/length-of-last-word/
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int n = s.length();
        int i = n - 1;
        while (i >= 0 && s.charAt(i) == ' ') {
            --i;
        }
        int ret = 0;
        while (i >= 0 && s.charAt(i) != ' ') {
            ++ret;
            --i;
        }
        return ret;
    }
}
