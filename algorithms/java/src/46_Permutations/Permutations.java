import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/permutations/
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new LinkedList<>();
        backtrack(nums, ret, new LinkedList<Integer>());
        return ret;
    }

    private void backtrack(int[] nums, List<List<Integer>> ret, LinkedList<Integer> current) {
        if (current.size() == nums.length) {
            ret.add(new LinkedList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 100) {
                continue;
            }
            current.add(nums[i]);
            nums[i] = 100;
            backtrack(nums, ret, current);
            nums[i] = current.removeLast();
        }
    }
}
