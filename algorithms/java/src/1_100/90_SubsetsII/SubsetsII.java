import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/subsets-ii/
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new LinkedList<>();
        ret.add(new LinkedList<>());
        solve(nums, 0, ret, new LinkedList<>());
        return ret;
    }

    private void solve(int[] nums, int start, List<List<Integer>> ret, LinkedList<Integer> cur) {
        for (int i = start; i < nums.length; ++i) {
            if (i == start || nums[i] != nums[i - 1]) {
                cur.add(nums[i]);
                ret.add(new ArrayList<>(cur));
                solve(nums, i + 1, ret, cur);
                cur.removeLast();
            }
        }
    }
}
