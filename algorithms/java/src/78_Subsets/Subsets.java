import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/subsets/
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new LinkedList<>();
        ret.add(new LinkedList<>());
        backtrack(nums, nums.length, 0, ret, new LinkedList<>());
        return ret;
    }

    private void backtrack(int[] nums, int k, int l, List<List<Integer>> ret, LinkedList<Integer> current) {
        if (k == 0) {
            return;
        }
        for (int i = l; i < nums.length; ++i) {
            current.add(nums[i]);
            ret.add(new LinkedList<>(current));
            backtrack(nums, k - 1, i + 1, ret, current);
            current.removeLast();
        }
    }
}
