import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses {
    // better solution with backtracking
    public List<String> generateParenthesis(int n) {
        List<String> ret = new LinkedList<>();
        generate(new StringBuilder(), n, n, ret);
        return ret;
    }


    private void generate(StringBuilder sb, int left, int right, List<String> ret) {
        if (left == 0 && right == 0) {
            ret.add(sb.toString());
        }

        // every step prefix one char
        if (left > 0) {
            // it is always possible to add '(' if remain left
            sb.append('(');
            generate(sb, left - 1, right, ret);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right > left) {
            // we can add ')' only if there are more '(' used
            sb.append(')');
            generate(sb, left, right - 1, ret);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
