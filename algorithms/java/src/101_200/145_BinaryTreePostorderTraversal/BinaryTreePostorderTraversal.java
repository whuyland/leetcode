import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-postorder-traversal/
public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> container = new LinkedList<>();
        traverse(root, container);
        return container;
    }

    private void traverse(TreeNode root, List<Integer> container) {
        if (root == null) {
            return;
        }

        traverse(root.left, container);
        traverse(root.right, container);
        container.add(root.val);
    }
}
