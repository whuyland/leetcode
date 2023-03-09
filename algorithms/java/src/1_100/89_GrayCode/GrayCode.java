import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/gray-code/
public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<>();
        solve(n, ret);
        return ret;
    }

    private void solve(int n, List<Integer> ret) {
        if (n == 0) {
            ret.add(0);
            return;
        }
        solve(n - 1, ret);
        int len = ret.size();
        for (int i = len - 1; i >= 0; --i) {
            ret.add((1 << n - 1) | ret.get(i));
        }
    }
}
