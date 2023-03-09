import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/binary-tree-level-order-traversal/
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> jobs = new LinkedList<>();
        jobs.add(root);
        while (!jobs.isEmpty()) {
            int n = jobs.size();
            List<Integer> container = new ArrayList<>(n);
            for (int i = 0; i < n; ++i) {
                TreeNode top = jobs.poll();
                container.add(top.val);
                if (top.left != null) {
                    jobs.offer(top.left);
                }
                if (top.right != null) {
                    jobs.offer(top.right);
                }
            }
            ret.add(container);
        }
        return ret;
    }
}
