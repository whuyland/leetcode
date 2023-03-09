import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-right-side-view/
public class BinaryTreeRightSideViewIterative {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new LinkedList<>();
        if (root == null) {
            return ret;
        }

        LinkedList<TreeNode> jobs = new LinkedList<>();
        jobs.add(root);
        while (!jobs.isEmpty()) {
            int n = jobs.size();
            ret.add(jobs.getLast().val);
            for (int i = 0; i < n; ++i) {
                TreeNode top = jobs.removeFirst();
                if (top.left != null) {
                    jobs.add(top.left);
                }
                if (top.right != null) {
                    jobs.add(top.right);
                }
            }
        }
        return ret;
    }
}
