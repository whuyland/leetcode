import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/recover-binary-search-tree/
public class RecoverBinarySearchTree {
    public void recoverTree(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        build(root, nodes);
        TreeNode larger = null;
        TreeNode smaller = null;

        // find the first one
        for (int i = 0; i < nodes.size(); ++i) {
            if (nodes.get(i).val > nodes.get(i + 1).val) {
                larger = nodes.get(i);
                break;
            }
        }

        // find the last one
        for (int i = nodes.size() - 1; i >= 0; --i) {
            if (i > 0 && nodes.get(i).val < nodes.get(i - 1).val) {
                smaller = nodes.get(i);
                break;
            }
        }

        swap(larger, smaller);
    }

    private void build(TreeNode root, List<TreeNode> nodes) {
        if (root == null) {
            return;
        }
        build(root.left, nodes);
        nodes.add(root);
        build(root.right, nodes);
    }

    private void swap(TreeNode a, TreeNode b) {
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }
}
