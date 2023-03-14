// https://leetcode.com/problems/diameter-of-binary-tree/
public class DiameterOfBinaryTree {
    private int maxLen;

    public int diameterOfBinaryTree(TreeNode root) {
        maxLen = 0;
        traverse(root);
        return maxLen - 1;
    }

    private int traverse(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = traverse(root.left);
        int right = traverse(root.right);
        maxLen = Math.max(maxLen, left + right + 1);
        return Math.max(left, right) + 1;
    }
}
