import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/copy-list-with-random-pointer/
public class CopyListWithRandomPointerWithMap {
    public Node copyRandomList(Node head) {
        Map<Node, Node> oldToNew = new HashMap<>();
        Node guard = new Node(0);
        guard.next = head;
        Node copyGuard = new Node(0);
        Node prev = copyGuard;

        while (head != null) {
            Node cur;
            if (oldToNew.containsKey(head)) {
                cur = oldToNew.get(head);
            } else {
                cur = new Node(head.val);
                oldToNew.put(head, cur);
            }
            if (head.random != null) {
                if (oldToNew.containsKey(head.random)) {
                    cur.random = oldToNew.get(head.random);
                } else {
                    cur.random = new Node(head.random.val);
                    oldToNew.put(head.random, cur.random);
                }
            }
            prev.next = cur;
            prev = cur;
            head = head.next;
        }
        return copyGuard.next;
    }
}
