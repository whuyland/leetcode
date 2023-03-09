import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/unique-binary-search-trees-ii/
public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }

    private List<TreeNode> generate(int l, int r) {
        List<TreeNode> ret = new LinkedList<>();
        for (int i = l; i <= r; ++i) {
            List<TreeNode> left = generate(l, i - 1);
            List<TreeNode> right = generate(i + 1, r);
            for (TreeNode ll : left) {
                for (TreeNode rr : right) {
                    ret.add(new TreeNode(i, ll, rr));
                }
            }
        }
        if (ret.isEmpty()) {
            ret.add(null);
        }
        return ret;
    }
}
