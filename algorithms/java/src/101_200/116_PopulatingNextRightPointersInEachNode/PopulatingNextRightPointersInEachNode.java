import java.util.LinkedList;

// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
public class PopulatingNextRightPointersInEachNode {
    public NextNode connect(NextNode root) {
        if (root == null) {
            return root;
        }

        LinkedList<NextNode> jobs = new LinkedList<>();
        jobs.add(root);
        while (!jobs.isEmpty()) {
            int n = jobs.size();
            NextNode prev = null;
            for (int i = 1; i <= n; ++i) {
                NextNode top = jobs.removeLast();
                top.next = prev;
                prev = top;
                if (top.left != null) {
                    jobs.addFirst(top.right);
                    jobs.addFirst(top.left);
                }
            }
        }
        return root;
    }
}
