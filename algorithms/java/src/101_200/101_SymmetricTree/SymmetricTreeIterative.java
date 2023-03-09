import java.util.LinkedList;

// https://leetcode.com/problems/symmetric-tree/
public class SymmetricTreeIterative {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        LinkedList<TreeNode> jobs = new LinkedList<>();
        jobs.add(root.left);
        jobs.add(root.right);

        while (jobs.size() >= 2) {
            TreeNode left = jobs.removeFirst();
            TreeNode right = jobs.removeLast();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            jobs.addFirst(left.right);
            jobs.addFirst(left.left);
            jobs.add(right.left);
            jobs.add(right.right);
        }
        return jobs.isEmpty();
    }
}
