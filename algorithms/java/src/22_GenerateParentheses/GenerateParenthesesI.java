import java.util.LinkedList;
import java.util.List;

public class GenerateParenthesesI {
    public List<String> generateParenthesis(int n) {
        return generate(n, n);
    }

    private List<String> generate(int left, int right) {
        if (left == 0 && right == 0) {
            return new LinkedList<>();
        }

        // every step prefix one char
        List<String> ret = new LinkedList<>();
        if (left > 0) {
            // it is always possible to add '(' if remain left
            List<String> sub = generate(left - 1, right);
            for (String s : sub) {
                ret.add("(" + s);
            }
        }
        if (right > left) {
            // we can add ')' only if there are more '(' used
            List<String> sub = generate(left, right - 1);
            if (sub.isEmpty()) {
                sub.add("");
            }
            for (String s : sub) {
                ret.add(")" + s);
            }
        }
        return ret;
    }
}
