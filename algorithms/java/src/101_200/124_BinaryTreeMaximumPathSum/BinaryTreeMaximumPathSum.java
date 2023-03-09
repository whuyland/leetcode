// https://leetcode.com/problems/binary-tree-maximum-path-sum/
public class BinaryTreeMaximumPathSum {
    public int maxPathSum(TreeNode root) {
        int[] ret = new int[]{Integer.MIN_VALUE};
        solve(root, ret);
        return ret[0];
    }

    // return max value contains root
    private int solve(TreeNode root, int[] ret) {
        if (root == null) {
            return 0;
        }

        int left = solve(root.left, ret);
        int right = solve(root.right, ret);
        ret[0] = Math.max(ret[0], root.val + left + right);
        int val = Math.max(left, right) + root.val;
        return Math.max(val, 0);
    }
}
