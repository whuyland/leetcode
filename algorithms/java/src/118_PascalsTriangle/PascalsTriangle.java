import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/pascals-triangle/
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>(numRows);
        List<Integer> lastRow = new ArrayList<>();
        lastRow.add(1);
        ret.add(lastRow);
        for (int i = 0; i < numRows - 1; ++i) {
            List<Integer> row = new ArrayList<>(i + 2);
            ret.add(row);
            row.add(1);
            for (int j = 0; j < i; ++j) {
                row.add(lastRow.get(j) + lastRow.get(j + 1));
            }
            row.add(1);
            lastRow = row;
        }
        return ret;
    }
}
