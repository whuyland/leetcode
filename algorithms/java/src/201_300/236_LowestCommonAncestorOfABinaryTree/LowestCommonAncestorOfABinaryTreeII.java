import java.util.LinkedList;

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
public class LowestCommonAncestorOfABinaryTreeII {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> pPath = new LinkedList<>();
        LinkedList<TreeNode> qPath = new LinkedList<>();
        reachChild(root, p, pPath);
        reachChild(root, q, qPath);
        TreeNode prev = null;
        while (!pPath.isEmpty() && !qPath.isEmpty() && pPath.getFirst() == qPath.getFirst()) {
            prev = pPath.removeFirst();
            qPath.removeFirst();
        }
        return prev;
    }

    private boolean reachChild(TreeNode root, TreeNode target, LinkedList<TreeNode> path) {
        if (root == null) {
            return false;
        }

        path.add(root);
        if (root == target) {
            return true;
        }
        if (reachChild(root.left, target, path)) {
            return true;
        }
        if (reachChild(root.right, target, path)) {
            return true;
        }
        path.removeLast();
        return false;
    }
}
