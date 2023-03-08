// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        solve(root);
    }

    // return the last node
    private TreeNode solve(TreeNode root) {
        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            return root;
        }
        TreeNode leftTail = solve(root.left);
        TreeNode rightTail = solve(root.right);
        if (leftTail != null && rightTail != null) {
            leftTail.right = root.right;
            root.right = root.left;
            root.left = null;
            return rightTail;
        }
        if (leftTail != null) {
            root.right = root.left;
            root.left = null;
            return leftTail;
        }
        return rightTail;
    }
}
