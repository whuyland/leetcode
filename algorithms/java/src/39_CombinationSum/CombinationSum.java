import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/combination-sum/
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ret = new LinkedList<>();
        solve(candidates, 0, target, ret, new LinkedList<Integer>());
        return ret;
    }

    private void solve(int[] candidates, int startIndex, int target, List<List<Integer>> ret, LinkedList<Integer> current) {
        if (target == 0) {
            ret.add(new LinkedList<>(current));
            return;
        }
        if (target < 0) {
            return;
        }

        for (int i = startIndex; i < candidates.length; ++i) {
            int val = candidates[i];
            target -= val;
            if (target < 0) {
                break;
            }
            current.add(val);
            // we never use values before index i again
            solve(candidates, i, target, ret, current);
            current.removeLast();
            target += val;
        }
    }
}
