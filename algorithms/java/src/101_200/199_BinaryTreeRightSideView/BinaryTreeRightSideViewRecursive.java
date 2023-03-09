import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-right-side-view/
public class BinaryTreeRightSideViewRecursive {
    public List<Integer> rightSideView(TreeNode root) {
        return traverse(root, 0, new ArrayList<>());
    }

    private List<Integer> traverse(TreeNode root, int level, List<Integer> ret) {
        if (root == null) {
            return ret;
        }
        if (ret.size() == level) {
            ret.add(root.val);
        }
        traverse(root.right, level + 1, ret);
        traverse(root.left, level + 1, ret);
        return ret;
    }
}
