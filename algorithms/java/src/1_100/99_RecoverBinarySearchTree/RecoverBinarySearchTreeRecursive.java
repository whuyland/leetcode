import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/recover-binary-search-tree/
public class RecoverBinarySearchTreeRecursive {
    private TreeNode prev;
    private TreeNode next;

    public void recoverTree(TreeNode root) {
        TreeNode larger = findFirstLarge(root);
        TreeNode smaller = findLastSmall(root);
        swap(larger, smaller);
    }

    private TreeNode findFirstLarge(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode larger = findFirstLarge(root.left);
        if (larger != null) {
            return larger;
        }

        if (prev != null && prev.val > root.val) {
            return prev;
        }
        prev = root;
        return findFirstLarge(root.right);
    }

    private TreeNode findLastSmall(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode smaller = findLastSmall(root.right);
        if (smaller != null) {
            return smaller;
        }
        if (next != null && next.val < root.val) {
            return next;
        }
        next = root;
        return findLastSmall(root.left);
    }

    private void swap(TreeNode a, TreeNode b) {
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }
}
