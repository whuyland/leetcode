import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/combinations/
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new LinkedList<>();
        backtrack(ret, k, 1, n, new LinkedList<Integer>());
        return ret;
    }

    private void backtrack(List<List<Integer>> ret, int k, int startIndex, int endIndex, LinkedList<Integer> current) {
        if (k == 0) {
            ret.add(new LinkedList<Integer>(current));
        }
        for (int i = startIndex; i <= endIndex; ++i) {
            current.add(i);
            backtrack(ret, k - 1, i + 1, endIndex, current);
            current.removeLast();
        }
    }
}
