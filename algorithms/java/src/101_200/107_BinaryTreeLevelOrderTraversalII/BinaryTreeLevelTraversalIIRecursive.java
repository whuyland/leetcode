import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
public class BinaryTreeLevelTraversalIIRecursive {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        return traverse(root, new LinkedList<>(), 0);
    }

    private LinkedList<List<Integer>> traverse(TreeNode root, LinkedList<List<Integer>> ret, int level) {
        if (root == null) {
            return ret;
        }

        if (level == ret.size()) {
            ret.addFirst(new ArrayList<>());
        }
        traverse(root.left, ret, level + 1);
        traverse(root.right, ret, level + 1);
        ret.get(ret.size() - 1 - level).add(root.val);
        return ret;
    }
}

