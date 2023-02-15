import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/combination-sum-ii/
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ret = new LinkedList<>();
        solve(candidates, 0, target, ret, new LinkedList<Integer>());
        return ret;
    }

    private void solve(int[] candidates, int startIndex, int target, List<List<Integer>> ret, LinkedList<Integer> current) {
        if (target == 0) {
            ret.add(new LinkedList<Integer>(current));
            return;
        }

        for (int i = startIndex; i < candidates.length; ++i) {
            if (i != startIndex && candidates[i] == candidates[i - 1]) {
                // we will add element at position: current.size(),
                // which should be unique
                continue;
            }
            int val = candidates[i];
            target -= val;
            if (target < 0) {
                break;
            }
            current.add(val);
            solve(candidates, i + 1, target, ret, current);
            current.removeLast();
            target += val;
        }
    }
}
