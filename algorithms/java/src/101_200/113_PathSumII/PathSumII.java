import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/path-sum-ii/
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        return traverse(root, targetSum, new LinkedList<>(), new LinkedList<>());
    }

    private List<List<Integer>> traverse(TreeNode root, int targetSum, List<List<Integer>> ret, LinkedList<Integer> current) {
        if (root == null) {
            return ret;
        }
        if (root.left == null && root.right == null) {
            if (targetSum == root.val) {
                List<Integer> ans = new LinkedList<>(current);
                ans.add(targetSum);
                ret.add(ans);
            }
            return ret;
        }
        current.add(root.val);
        traverse(root.left, targetSum - root.val, ret, current);
        traverse(root.right, targetSum - root.val, ret, current);
        current.removeLast();
        return ret;
    }
}
