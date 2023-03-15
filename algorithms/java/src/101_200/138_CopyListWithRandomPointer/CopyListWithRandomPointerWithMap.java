import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/copy-list-with-random-pointer/
public class CopyListWithRandomPointerWithMap {
    public RandomNode copyRandomList(RandomNode head) {
        Map<RandomNode, RandomNode> oldToNew = new HashMap<>();
        RandomNode guard = new RandomNode(0);
        guard.next = head;
        RandomNode copyGuard = new RandomNode(0);
        RandomNode prev = copyGuard;

        while (head != null) {
            RandomNode cur;
            if (oldToNew.containsKey(head)) {
                cur = oldToNew.get(head);
            } else {
                cur = new RandomNode(head.val);
                oldToNew.put(head, cur);
            }
            if (head.random != null) {
                if (oldToNew.containsKey(head.random)) {
                    cur.random = oldToNew.get(head.random);
                } else {
                    cur.random = new RandomNode(head.random.val);
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
