// https://leetcode.com/problems/minimum-depth-of-binary-tree/
public class MinimumDepthOfBinaryTreeI {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // root is leaf
        if (root.left == null && root.right == null) {
            return 1;
        }

        int left = root.left != null ? minDepth(root.left) : Integer.MAX_VALUE;
        int right = root.right != null ? minDepth(root.right) : Integer.MAX_VALUE;
        return Math.min(left, right) + 1;
    }
}
