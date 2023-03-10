import java.util.LinkedList;

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
public class LowestCommonAncestorOfABinaryTreeI {
    private TreeNode ans = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        traverse(root, p, q);
        return ans;
    }

    private int traverse(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return 0;
        }

        if (ans != null) {
            return 3;
        }

        int left = traverse(root.left, p, q);
        int right = traverse(root.right, p, q);
        int ret = left | right;
        if (root == p) {
            ret |= 1;
        }
        if (root == q) {
            ret |= 2;
        }
        if (ret == 3 && ans == null) {
            ans = root;
        }
        return ret;
    }
}
