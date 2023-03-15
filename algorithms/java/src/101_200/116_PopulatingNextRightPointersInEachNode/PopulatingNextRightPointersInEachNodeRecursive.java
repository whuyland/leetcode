import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
public class PopulatingNextRightPointersInEachNodeRecursive {
    private final List<NextNode> prev = new ArrayList<>();

    public NextNode connect(NextNode root) {
        return traverse(root, 0);
    }

    private NextNode traverse(NextNode root, int level) {
        if (root == null) {
            return root;
        }
        if (prev.size() <= level) {
            prev.add(null);
        }
        traverse(root.right, level + 1);
        traverse(root.left, level + 1);
        root.next = prev.get(level);
        prev.set(level, root);
        return root;
    }
}
