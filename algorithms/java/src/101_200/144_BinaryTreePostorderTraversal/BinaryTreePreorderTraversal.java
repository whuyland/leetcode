import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-preorder-traversal/
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> container = new ArrayList<>();
        traverse(root, container);
        return container;
    }

    private void traverse(TreeNode root, List<Integer> container) {
        if (root == null) {
            return;
        }

        container.add(root.val);
        traverse(root.left, container);
        traverse(root.right, container);
    }
}
