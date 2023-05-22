// https://leetcode.com/problems/sum-root-to-leaf-numbers/
public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return traverse(root, 0);
    }

    private int traverse(TreeNode root, int parent) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return parent * 10 + root.val;
        }

        int partialSum = parent * 10 + root.val;
        int left = traverse(root.left, partialSum);
        int right = traverse(root.right, partialSum);
        return left + right;
    }
}
