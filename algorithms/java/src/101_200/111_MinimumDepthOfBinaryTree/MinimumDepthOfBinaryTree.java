// https://leetcode.com/problems/minimum-depth-of-binary-tree/
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        // if one side is null, the the min depth is the other side
        // the leaf case is also contained
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }
}
