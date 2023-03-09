import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-inorder-traversal/
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new LinkedList<>();
        traverse(root, ret);
        return ret;
    }

    private void traverse(TreeNode root, List<Integer> ret) {
        if (root == null) {
            return;
        }

        traverse(root.left, ret);
        ret.add(root.val);
        traverse(root.right, ret);
    }
}
