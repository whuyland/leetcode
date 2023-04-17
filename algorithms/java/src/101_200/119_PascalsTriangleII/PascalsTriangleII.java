import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/pascals-triangle-ii/

public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        return solve(rowIndex, new LinkedList<>());
    }

    private List<Integer> solve(int rowIndex, LinkedList<Integer> input) {
        if (rowIndex == 0) {
            input.add(1);
            return input;
        }

        solve(rowIndex - 1, input);
        int n = input.size();
        int prev = 0;
        for (int i = 0; i < n; ++i) {
            int top = input.removeFirst();
            input.add(top + prev);
            prev = top;
        }
        input.add(1);
        return input;
    }
}
