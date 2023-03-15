import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<>();
        if (root == null) {
            return ret;
        }
        LinkedList<TreeNode> jobs = new LinkedList<>();
        jobs.add(root);
        boolean forward = true;
        while (!jobs.isEmpty()) {
            LinkedList<Integer> row = new LinkedList<>();
            int n = jobs.size();
            for (int i = 0; i < n; ++i) {
                TreeNode top = jobs.removeFirst();
                if (top.left != null) {
                    jobs.add(top.left);
                }
                if (top.right != null) {
                    jobs.add(top.right);
                }
                if (forward) {
                    row.add(top.val);
                } else {
                    row.addFirst(top.val);
                }
            }
            ret.add(row);
            forward = !forward;
        }
        return ret;
    }
}
