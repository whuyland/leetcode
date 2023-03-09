import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/combination-sum/
public class CombinationSumI {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return solve(candidates, candidates.length - 1, target);
    }

    private List<List<Integer>> solve(int[] candidates, int endIndex, int target) {
        List<List<Integer>> ret = new LinkedList<>();
        if (target == 0) {
            ret.add(new LinkedList<Integer>());
            return ret;
        }
        if (endIndex < 0) {
            return ret;
        }
        List<Integer> counter = new LinkedList<>();
        while (target >= 0) {
            List<List<Integer>> sub = solve(candidates, endIndex - 1, target);
            if (!sub.isEmpty()) {
                for (List<Integer> sol : sub) {
                    sol.addAll(counter);
                }
                ret.addAll(sub);
            }
            target -= candidates[endIndex];
            counter.add(candidates[endIndex]);
        }
        return ret;
    }
}
