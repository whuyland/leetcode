import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
public class BinaryTreeLevelTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> ret = new LinkedList<>();
        if (root == null) {
            return ret;
        }
        LinkedList<TreeNode> jobs = new LinkedList<>();
        jobs.add(root);
        while (!jobs.isEmpty()) {
            int n = jobs.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                TreeNode top = jobs.removeFirst();
                level.add(top.val);
                if (top.left != null) {
                    jobs.add(top.left);
                }
                if (top.right != null) {
                    jobs.add(top.right);
                }
            }
            ret.addFirst(level);
        }
        return ret;
    }
}
