// https://leetcode.com/problems/balanced-binary-tree/
public class BalancedBinaryTree {
    private boolean isValid = true;

    public boolean isBalanced(TreeNode root) {
        check(root);
        return isValid;
    }

    // return height
    private int check(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = check(root.left);
        int right = check(root.right);
        if (Math.abs(left - right) > 1) {
            isValid = false;
        }
        return Math.max(left, right) + 1;
    }
}
