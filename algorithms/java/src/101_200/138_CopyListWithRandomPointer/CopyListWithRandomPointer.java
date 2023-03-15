import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/copy-list-with-random-pointer/
public class CopyListWithRandomPointer {
    public RandomNode copyRandomList(RandomNode head) {
        RandomNode guard = new RandomNode(0);
        guard.next = head;
        RandomNode copyGuard = new RandomNode(0);

        List<RandomNode> copies = new ArrayList<>();

        // copy the list, use val of origin list to mark which node the random point
        RandomNode prev = copyGuard;
        int i = 0;
        while (head != null) {
            prev.next = new RandomNode(head.val);
            prev = prev.next;

            copies.add(prev);
            head.val = i++;
            head = head.next;
        }

        // set random pointer
        head = guard.next;
        RandomNode copy = copyGuard.next;
        while (head != null) {
            if (head.random != null) {
                copy.random = copies.get(head.random.val);
            }
            head = head.next;
            copy = copy.next;
        }

        // restore val of origin list
        head = guard.next;
        copy = copyGuard.next;
        while (head != null) {
            head.val = copy.val;
            head = head.next;
            copy = copy.next;
        }

        return copyGuard.next;
    }
}
