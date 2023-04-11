import java.util.LinkedList;

// https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
public class PopulatingNextRightPointersInEachNodeII {
    public NextNode connect(NextNode root) {
        if (root == null) {
            return root;
        }
        LinkedList<NextNode> jobs = new LinkedList<>();
        jobs.add(root);
        while (!jobs.isEmpty()) {
            int n = jobs.size();
            for (int i = 0; i < n; ++i) {
                NextNode top = jobs.removeFirst();
                if (i != n - 1) {
                    top.next = jobs.getFirst();
                }
                if (top.left != null) {
                    jobs.add(top.left);
                }
                if (top.right != null) {
                    jobs.add(top.right);
                }
            }
        }
        return root;
    }
}
