import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class LetterCombinationOfAPhoneNumber {
    private static final char[][] dict = new char[][]{{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
            {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

    public List<String> letterCombinations(String digits) {
        return recursive(digits, 0);
    }

    private List<String> recursive(String digits, int start) {
        List<String> ret = new LinkedList<>();
        if (start == digits.length()) {
            return ret;
        }

        List<String> substring = recursive(digits, start + 1);
        if (substring.isEmpty()) {
            substring.add("");
        }
        for (char c : dict[digits.charAt(start) - '2']) {
            for (String s : substring) {
                ret.add(c + s);
            }
        }
        return ret;
    }

    // iterative
    public List<String> letterCombinationsI(String digits) {
        LinkedList<String> ret = new LinkedList<>();
        if (digits.length() == 0) {
            return ret;
        }
        ret.add("");

        for (int i = 0; i < digits.length(); ++i) {
            int n = ret.size();
            for (int j = 0; j < n; ++j) {
                String cur = ret.removeFirst();
                for (char c : dict[digits.charAt(i) - '2']) {
                    ret.add(cur + c);
                }
            }
        }
        return ret;
    }
}
